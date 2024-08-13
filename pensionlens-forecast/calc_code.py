import pandas as pd
import numpy as np
import pymysql
import math
import datetime
import config as cfg


def calculate(id, env):  # 测算
    def get_person_all(t0, person):
        """
        @name 获得t年的所有类别的人的总数
        @param t0 年份
        @param person 人数表
        @return L 总人数
        """
        L = 0

        for j in rt:
            if j == 0:
                col = "male"
            elif j == 1:
                col = "female_worker"
            elif j == 2:
                col = "female_cadre"
            rs = math.modf(rt[j][t0] - 0.01)[1]  # 整数部分
            re = round(math.modf(rt[j][t0])[0], 2)  # 小数部分
            re = re if re != 0.00 else 1
            L += sum(person[(e <= person.age) & (person.age <= rs - 1) &
                            (person.year == t0)][col].values)
            L += person[(person.age == rs) & (person.year == t0)][col].values * re

        return L

    def f_income(t, person):
        """
        @name 养老金收入
        @param t 年份
        @param person 人数表
        @return L 总人数
        """
        L = get_person_all(t, person)
        return L * beta[t] * (q[t] + c[t]) * S[t - 1] * alpha[t]

    # #将range函数调整为0.01为间隔
    # def float_range(a, b):
    #     output = []
    #     while a < b:
    #         output.append(a)
    #         a += 0.01
    #         a = round(a, 2)
    #     return output

    def get_person(t0, j, x, person):
        """
        @name 获得t年的类别为j的年龄为x的人数
        @param t0 年份
        @param j 类别
        @param x 年龄
        @param person 人数表
        @return L 总人数
        """
        if j == 0:
            col = "nmale"
        elif j == 1:
            col = "female_worker"
        elif j == 2:
            col = "female_cadre"
        return np.array(person[(person.age == x) & (person.year == t0)][col].values)

    def get_old(t0, j, x):
        """
        @name 老人的养老金
        @param t0 年份
        @param j 类别
        @param x 年龄
        @return L 总人数
        """
        s_avg = S[t0 - (x - r[j]) - 1]
        g_prod = [(1 + g[t0 - k]) for k in range(0, x - r[j] - 1 + 1)]
        g_prod = np.prod(g_prod)  # 连乘
        return s_avg * f * (g_prod)

    def f_old(t, person, all_j):
        """
        @name 老人的支出
        @param t 年份
        @param person 人数表
        @param all_j 类别
        @return output 总支出
        """
        output = 0
        for j in all_j:
            for x in range(r[j] + t - policy_1997 + 1, w + 1):
                L = get_person(t, j, x, person)
                O = get_old(t, j, x)
                output += L * O * beta[t]
        return output

    def get_b2_1(t0, j, x):
        """
        @name 老中人的统帐支出
        @param t0 年份
        @param j 类别
        @param x 年龄
        @return L 总人数
        """
        s_avg = S[t0 - (x - r[j]) - 1]
        g_prod = [(1 + g[t]) for t in range(t0 - (x - r[j]) + 1, t0 + 1)]
        g_prod = np.prod(g_prod)
        temp = 0.2
        return s_avg * temp * g_prod

    def get_t2_1(t0, j, x):
        """
        @name 老中人的个账支出
        @param t0 年份
        @param j 类别
        @param x 年龄
        @return L 总人数
        """
        s_avg = S[t0 - (x - r[j]) - 1]
        g_prod = [(1 + g[t]) for t in range(t0 - (x - r[j]) + 1, t0 + 1)]
        g_prod = np.prod(g_prod)
        temp = (x - (t0 - base_year) - e) * delta[t0 - (x - r[j])]
        return s_avg * temp * g_prod

    def f2_1(t, person, all_j):
        """
        @name 老中人的统帐支出
        @param t 年份
        @param person 人数表
        @param all_j 类别
        @return output 总支出
        """
        output = 0
        for j in all_j:
            for x in range(r[j] + t - policy_2005 + 1, min(r[j] + t - policy_1997 + 1, w + 1)):
                L = get_person(t, j, x, person)
                B = get_b2_1(t, j, x)
                T = get_t2_1(t, j, x)
                output += L * (B + T) * beta[t]
        return output

    def get_i2(t0, j, x):
        """
        @name 老中人的个账支出
        @param t0 年份
        @param j 类别
        @param x 年龄
        @return 老中人的个账支出
        """

        def temp_i(t0, x, ri):
            output = 0
            for t in range(policy_1997, t0 - (x - ri) - 1 + 1):
                j_prod = [(1 + jk[k]) for k in range(t, t0 - (x - ri) - 1 + 1)]
                j_prod = np.prod(j_prod)
                output += S[t - 1] * alpha[t] * c[t] * j_prod
            return output

        g_prod = [(1 + g[t]) for t in range(t0 - (x - r[j]) + 1, t0 + 1)]
        g_prod = np.prod(g_prod)
        temp1 = 12 / m[j][t0 - (x - r[j])]
        return temp1 * temp_i(t0, x, r[j]) * g_prod

    def f2_2(t, person, all_j):
        """
        老中人的个账支出
        """
        output = 0
        for j in all_j:
            for x in range(r[j] + t - policy_2005 + 1, min(r[j] + t - policy_1997 - 1 + 1,
                                                           w + 1)):  ###-1
                L = get_person(t, j, x, person)
                I = get_i2(t, j, x)
                output += sum(L * I * beta[t])
        return output

    def get_rti(x, t0, j):
        r = rt[j]
        # x = int(x)
        for k in r:
            if x == int(r[k]) - k + t0:
                return int(r[k])
        raise

    def get_j(t0, j, x, r):
        j_sum = np.array([
            alpha[t] for t in range(max(base_year, t0 - (x - e)), t0 -
                                    (x - r) - 1 + 1)
        ])
        return np.sum(j_sum)

    def get_b3_1(t0, j, x, r):
        s_avg = S[t0 - (x - r) - 1] / 2
        g_prod = [1 + g[t]
                  for t in range(t0 - (x - r) + 1, t0 + 1)] if x != r else [1]
        g_prod = np.prod(g_prod)
        temp = (1 + (get_j(t0, j, x, r) + (x - (t0 - base_year) - e)) /
                (r - e)) * (r - e) * 0.01
        return s_avg * temp * g_prod

    def get_t3_1(t0, j, x, r):
        s_avg = S[t0 - (x - r) - 1]
        g_prod = [1 + g[t]
                  for t in range(t0 - (x - r) + 1, t0 + 1)] if x != r else [1]
        g_prod = np.prod(g_prod)
        temp = ((get_j(t0, j, x, r) + (x - (t0 - base_year) - e)) /
                (r - e)) * (x - t0 - e + base_year) * delta[t0 - (x - r)]
        return s_avg * temp * g_prod

    def f3_1(t, person, all_j):
        """
        新中人的统帐支出
        """
        output = 0
        for j in all_j:
            for x in range(max(int(rt[j][t]) + 1, e + t - policy_1997 + 1),
                           min(w + 1, int(rt[j][t]) + t - policy_2005 + 1)):
                rti = get_rti(x, t, j)
                B = get_b3_1(t, j, x, rti)
                T = get_t3_1(t, j, x, rti)
                L = get_person(t, j, x, person)
                output += L * (B + T) * beta[t]
            if int(rt[j][t]) + 1 > e + t - policy_1997 + 1:
                rti = get_rti(int(rt[j][t]), t, j)
                B = get_b3_1(t, j, int(rt[j][t]), rti)
                T = get_t3_1(t, j, int(rt[j][t]), rti)
                L = get_person(t, j, int(rt[j][t]), person)
                output += (int(rt[j][t]) + 1 - rt[j][t]) * L * (B + T) * beta[t] / 20
            elif w > int(rt[j][t]) + t - policy_2005:
                rti = get_rti(int(rt[j][t]) + t - policy_2005, t, j)
                B = get_b3_1(t, j, int(rt[j][t]) + t - policy_2005, rti)
                T = get_t3_1(t, j, int(rt[j][t]) + t - policy_2005, rti)
                L = get_person(t, j, int(rt[j][t]) + t - policy_2005, person)
                output += (rt[j][t] - int(rt[j][t])) * L * (B + T) * beta[t] / 20
            else:
                output = output

        return output

    def get_i3(t0, j, x, r):
        def temp_i(t0, x, ri):
            output = 0
            for t in range(policy_1997, t0 - (x - ri) - 1 + 1):
                j_prod = [(1 + jk[k]) for k in range(t, t0 - (x - ri) - 1 + 1)]
                j_prod = np.prod(j_prod)
                output += S[t - 1] * alpha[t] * c[t] * j_prod
            return output

        g_prod = [1 + g[t]
                  for t in range(t0 - (x - r) + 1, t0 + 1)] if x != r else [1]
        g_prod = np.prod(g_prod)
        temp1 = 12 / m[j][t0 - (x - r)]
        return temp1 * temp_i(t0, x, r) * g_prod

    def f3_2(t, person, all_j):
        """
        新中人的个账支出
        """
        output = 0
        for j in all_j:
            for x in range(max(int(rt[j][t]) + 1, e + t - policy_1997 + 1),
                           min(w + 1, int(rt[j][t]) + t - policy_2005 + 1)):
                rti = get_rti(x, t, j)  # x岁参保人员退休时的法定退休年龄
                L = get_person(t, j, x, person)
                I = get_i3(t, j, x, rti)
                output += sum(L * I * beta[t])
            if int(rt[j][t]) + 1 > e + t - policy_1997 + 1:
                rti = get_rti(int(rt[j][t]), t, j)
                L = get_person(t, j, int(rt[j][t]), person)
                I = get_i3(t, j, int(rt[j][t]), rti)
                output += (int(rt[j][t]) + 1 - rt[j][t]) * sum(L * I * beta[t]) / 20
            elif w > int(rt[j][t]) + t - policy_2005:
                rti = get_rti(int(rt[j][t]) + t - policy_2005, t, j)
                L = get_person(t, j, int(rt[j][t]) + t - policy_2005, person)
                I = get_i3(t, j, int(rt[j][t]) + t - policy_2005, rti)
                output += (rt[j][t] - int(rt[j][t])) * sum(L * I * beta[t]) / 20
            else:
                output = output
        return output

    def get_b4_1(t0, j, x, r):

        s_avg = S[t0 - (x - r) - 1] / 2
        g_prod = [1 + g[t]
                  for t in range(t0 - (x - r) + 1, t0 + 1)] if x != r else [1]
        g_prod = np.prod(g_prod)
        temp = (1 + get_j(t0, j, x, r) / (r - e)) * (r - e) * 0.01
        return s_avg * g_prod * temp

    def f4_1(t, person, all_j):
        """
        新人的统帐支出
        """
        output = 0
        for j in all_j:
            if e + t - policy_1997 >= rt[j][t]:
                for x in range(int(rt[j][t]) + 1, min(e + t - policy_1997 + 1, w + 1)):
                    rti = get_rti(x, t, j)
                    L = get_person(t, j, x, person)
                    B = get_b4_1(t, j, x, rti)
                    output += L * B * beta[t]
                if rt[j][t] - int(rt[j][t]) != 0:
                    rti = get_rti(int(rt[j][t]), t, j)
                    L = get_person(t, j, int(rt[j][t]), person)
                    B = get_b4_1(t, j, int(rt[j][t]), rti)
                    output += (int(rt[j][t]) + 1 - rt[j][t]) * L * B * beta[t] / 20
                else:
                    output = output
            else:
                output += 0
        return output

    def get_i4(t0, j, x, r):
        def temp_i(t0, x, ri):
            output = 0
            for t in range(t0 - (x - e), t0 - (x - ri) - 1 + 1):
                j_prod = [(1 + jk[k]) for k in range(t, t0 - (x - ri) - 1 + 1)]
                j_prod = np.prod(j_prod)
                output += S[t - 1] * alpha[t] * c[t] * j_prod
            return output

        g_prod = [1 + g[t]
                  for t in range(t0 - (x - r) + 1, t0 + 1)] if x != r else [1]
        g_prod = np.prod(g_prod)
        temp1 = 12 / m[j][t0 - (x - r)]
        return temp1 * temp_i(t0, x, r) * g_prod

    def f4_2(t, person, all_j):
        """
        新人的个账支出
        """
        output = 0
        for j in all_j:
            if e + t - policy_1997 >= rt[j][t]:
                for x in range(int(rt[j][t]) + 1, min(e + t - policy_1997 + 1, w + 1)):
                    rti = get_rti(x, t, j)
                    L = get_person(t, j, x, person)
                    I = get_i4(t, j, x, rti)
                    output += sum(L * I * beta[t])
                if rt[j][t] - int(rt[j][t]) != 0:
                    rti = get_rti(int(rt[j][t]), t, j)
                    L = get_person(t, j, int(rt[j][t]), person)
                    I = get_i4(t, j, int(rt[j][t]), rti)
                    output += (int(rt[j][t]) + 1 - rt[j][t]) * sum(L * I * beta[t]) / 20
                else:
                    output = output
            else:
                output += 0
        return output

    def get_d(t0, j, x, person):
        """
        获取t0年类别为j的年龄为x的人数
        """
        if j == 0:
            col = 'death_male'
        elif j == 1:
            col = "death_female_worker"
        elif j == 2:
            col = "death_female_cadre"
        return np.array(person[(person.age == x) & (person.year == t0)][col].values)

    def f5_2(t0, j, x, i, r, person):
        return max((m[j][t0 - (x - r)] / 12 - x + r - 1), 0) * get_d(
            t0, j, x, person) * i * beta[t0]

    def f5_1(t0, j, x, person):
        temp = 0
        for t in range(max(t0 - (x - e), policy_1997), t0 + 1):
            j_prod = [(1 + jk[k]) for k in range(t, t0 + 1)]
            j_prod = np.prod(j_prod)
            temp += S[t - 1] * alpha[t] * c[t] * j_prod
        return get_d(t0, j, x, person) * temp * beta[t0]

    def f_return(t, person, all_j):
        """
        个账返还
        """
        output = 0
        for j in all_j:
            output1 = 0
            for x in range(e, int(rt[j][t]) + 1):  # 【参保年龄，去除小数点后的退休年龄】
                output1 += f5_1(t, j, x, person)

            if rt[j][t] - int(rt[j][t]) != 0:
                output2 = (rt[j][t] - int(rt[j][t])) * f5_1(t, j, int(rt[j][t]), person) / 20
            else:
                output2 = 0
            output += output1 + output2

        for j in all_j:
            output1 = 0
            for x in range(int(rt[j][t]) + 1, min(int(rt[j][policy_1997 + 1] + (t - policy_1997 - 1)), w) + 1):
                rti = get_rti(x, t, j)
                I = get_i3(t, j, x, rti)
                output1 += f5_2(t, j, x, I, rti, person)

            if rt[j][t] - int(rt[j][t]) != 0:
                rti = get_rti(int(rt[j][t]), t, j)
                I = get_i3(t, j, int(rt[j][t]), rti)
                output2 = (int(rt[j][t]) + 1 - rt[j][t]) * f5_2(t, j, int(rt[j][t]), I, rti, person) / 20
            else:
                output2 = 0
            output += output1 + output2

        return output

    def insert_result(id, t, u_o_i, l):
        """
        t:预测年份
        l = f0,f1,f2,f3,f4,f5
        """
        nonlocal last_year_sum_surplus

        expense = (l[1] + l[2] + l[3] + l[4] + l[5])[0]
        income = (l[0])[0]

        surplus = last_year_sum_surplus + income - expense

        insert_sql = """
        insert into t_yctxcs_results (id,plan_id,year, expense, income, surplus,last_year_sum_surplus)
        VALUES (replace(uuid(),"-",""), '%s',%s,%s,%s,%s,%s) 
        """ % (id, t, expense, income, surplus, last_year_sum_surplus)

        update_sql = """
        update t_yctxcs_results t set expense=%s, income=%s, surplus=%s,last_year_sum_surplus=%s
        where plan_id='%s' and year=%s
        """ % (expense, income, surplus, last_year_sum_surplus, id, t)

        if u_o_i:
            cursor.execute(update_sql)
        else:
            cursor.execute(insert_sql)

        db.commit()
        last_year_sum_surplus = surplus

    # if __name__ == "__main__":
    # calculate函数运行主体
    if env == 'gstest':
        # 连接测试服务器
        db = pymysql.connect(host=cfg.host,
                             user=cfg.cs_user,
                             password=cfg.cs_password,
                             port=cfg.cs_port)
        # 创建游标
        cursor = db.cursor()
        cursor.execute("use %s" % cfg.cs_database)

    else:
        # 连接开发服务器
        db = pymysql.connect(host=cfg.host,
                             user=cfg.dev_user,
                             password=cfg.dev_password,
                             port=cfg.dev_port)
        # 创建游标，此游标非数据库游标，此游标是pymysql中的重要数据库查询接口类
        cursor = db.cursor()
        cursor.execute("use %s" % cfg.dev_database)
    # 读取测算参数表，用户给
    cursor.execute("describe t_yctxcs_plan_index_year ")
    cols = cursor.fetchall()  # 获取所有的信息
    cols = [i[0] for i in cols]  # 列表推导式，获取表格所有的字段名
    cursor.execute("select * from t_yctxcs_plan_index_year where plan_id = '%s'" % id)  # 从数据库中获取相应id的测算参数数据
    data1 = pd.DataFrame(cursor.fetchall(), columns=cols)  # 数据库表转pandas-dataframe
    # data1 = data1.astype("float32")
    data1 = data1.sort_values(by=["year"])  # 按照年份排序
    # 读取测算方案表，用户给
    cursor.execute("describe t_yctxcs_plan ")  # 获取测算计划表格的字段名
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_plan where id = '%s'" % id)

    data2 = pd.DataFrame(cursor.fetchall(), columns=cols)
    # data2=data2.select_dtypes(exclude=("datetime"))
    # data2 = data2.astype("float32")
    plan_area = int(data2["plan_area"])
    data1['plan_area'] = plan_area

    # plan_area=data2["plan_area"].astype('int')
    birth_mode = int(data2["birth_mode"])
    start_year = int(data2["start_year"])
    end_year = int(data2["end_year"])
    retire_person_types = list(map(int, list(data2["retire_person_types"])[0].split(',')))

    # 读取测算默认参数表，系统给，有
    cursor.execute("describe t_yctxcs_index ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_index where plan_area = %s" % plan_area)
    data4_0 = pd.DataFrame(cursor.fetchall(), columns=cols)
    data4_0 = data4_0.astype("float32")
    data4_1 = data4_0[data4_0.year <= end_year]
    data4_2 = data4_0[data4_0.year < start_year]
    data4 = pd.concat([data4_2, data1], axis=0)
    data4 = data4.sort_values(by=["year"]).reset_index(drop=True)

    # 下面的每个参数均为字典，其中year为键，对应的值为对应年份的参数值
    # 在岗职工平均工资
    S = dict(data4[["year", "avg_salary"]].astype("float32").values)
    # 个人缴费率
    c = dict(data4[["year", "individual_rate"]].astype("float32").values)
    # 企业缴费率
    q = dict(data4[["year", "enterprise_rate"]].astype("float32").values)
    # 参保率
    beta = dict(data4[["year", "insurance_rate"]].astype("float32").values)
    # 养老金增长率
    g = dict(data4[["year", "growth"]].astype("float32").values)
    # 收缴率
    alpha = dict(data4[["year", "collect_rate"]].astype("float32").values)
    # 过渡系数
    delta = dict(data4[["year", "transition"]].astype("float32").values)
    # 个账记账利率
    jk = dict(data4[["year", "account_rate"]].astype("float32").values)

    # 读取统筹区域字典表，系统给，有
    cursor.execute("describe t_yctxcs_area_code_dict ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_area_code_dict where code = %s" % plan_area)
    data3 = pd.DataFrame(cursor.fetchall(), columns=cols)
    # data3 = data3.astype("float32")
    # 建立个账
    policy_1997 = int(data3["policy_1997"])
    # 调整过渡养老金计发的年份
    policy_2005 = int(data3["policy_2005"])
    # 计算视同缴费年限的基准年份
    base_year = int(data3["base_year"])

    # 最长寿命
    w = 100
    # 最小参保年龄
    e = 16
    # “老人”的计发比例
    f = 0.7
    # 退休年龄
    r_old_male = 60
    r_old_female_worker = 50
    r_old_female_cadre = 55

    r = {0: r_old_male, 1: r_old_female_worker, 2: r_old_female_cadre}

    # 读取默认人数表，系统(padis-int)给，有
    cursor.execute("describe t_yctxcs_person_number ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_person_number where plan_area =%s and mode=%s and year>=%s and year<=%s" % (
        plan_area, birth_mode, start_year, end_year))
    data5 = pd.DataFrame(cursor.fetchall(), columns=cols)
    data5 = data5[data5['age'] >= e].astype("float32")

    # 读取城镇职工人口测算参数表(就业率)，用户给
    cursor.execute("describe t_yctxcs_plan_index_age ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_plan_index_age where plan_id ='%s'" % id)
    data6 = pd.DataFrame(cursor.fetchall(), columns=cols)
    data6 = data6.sort_values(by=["age"])
    data6 = data6[data6['age'] >= e]
    # data6 = data6.astype("float32")

    # 读取城镇化率默认表（城镇化率），用户给
    cursor.execute("describe t_yctxcs_plan_index_urban ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_plan_index_urban where plan_id ='%s' and year>=%s and year<=%s" % (
        id, start_year, end_year))
    data7 = pd.DataFrame(cursor.fetchall(), columns=cols)
    data7 = data7.sort_values(by=["age"])
    data7 = data7[data7['age'] >= e]
    # data7 = data7.astype("float32")

    # 读取城镇职工人口测算默认参数表（死亡率），系统给，有
    cursor.execute("describe t_yctxcs_person_index ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute("select * from t_yctxcs_person_index where plan_area =%s" % plan_area)
    data8 = pd.DataFrame(cursor.fetchall(), columns=cols)
    data8 = data8[data8['age'] >= e].astype("float32")
    data8 = data8.sort_values(by=["age"])

    # 读取默认结果表，系统给？是啥？
    cursor.execute("describe t_yctxcs_default_results ")
    cols = cursor.fetchall()
    cols = [i[0] for i in cols]
    cursor.execute(
        "select * from t_yctxcs_default_results where plan_area =%s and birth_mode=%s" % (plan_area, birth_mode))
    # data9 = pd.DataFrame(cursor.fetchall(), columns=cols)
    # data9 = data9.astype("float32")
    #
    # # 各年当年度养老金结余
    # each_surplus = data9[["year", "retire_person_types", "surplus"]]

    last_year_sum_surplus = float(data2["last_year_sum_surplus"].values)
    # if start_year > datetime.datetime.now().year:
    #
    #     for i in range(datetime.datetime.now().year, start_year):
    #         for rpt in retire_person_types:
    #             a = each_surplus[each_surplus["year"] == i]
    #             last_year_sum_surplus += list(a[a["retire_person_types"] == rpt]['surplus'])[0]
    # else:
    #     last_year_sum_surplus = last_year_sum_surplus

    sql_update_or_insert = """
    select distinct(plan_id) from t_yctxcs_results where plan_id='%s'
    """ % id
    cursor.execute(sql_update_or_insert)
    u_o_i = cursor.fetchall()

    # ---------性别相关参数
    rt = {}
    m = {}

    for i in list(range(start_year, end_year + 1)):
        all_j = []
        person = pd.DataFrame()
        data5_1 = data5[data5.year == i].sort_values(by=["age"])
        data7_1 = data7[data7.year == i].sort_values(by=["age"])
        person["year"] = data5_1["year"].copy()
        person["age"] = data5_1["age"].copy()

        for j in retire_person_types:

            if j == 0:

                # 男性退休年龄
                rt[0] = dict(data4[["year", "m_retire"]].astype("float32").values)
                # 男性计发月数
                m[0] = dict(data4_1[["year", "m_month"]].values)
                all_j.append(0)
                employ1 = data6[["age", "m_employment_rate"]].sort_values(by=["age"])
                # 男性企业职工人数
                person["nmale"] = data5_1["male"].values * \
                                  data7_1["urban_rate"].astype("float32").values * 0.8782 * employ1[
                                      "m_employment_rate"].astype("float32").values
                # 死亡的男性企业职工人数
                person["death_male"] = data8["m_death_rate"].values * data5_1["male"].values / (
                        1 - data8["m_death_rate"].values) \
                                       * data7_1["urban_rate"].astype("float32").values * 0.8782 * employ1[
                                           "m_employment_rate"].astype("float32").values

            elif j == 1:

                # 女职工退休年龄
                rt[1] = dict(data4[["year", "w_retire"]].astype("float32").values)
                # 女职工计发月数
                m[1] = dict(data4_1[["year", "w_month"]].values)
                all_j.append(1)
                employ2 = data6[["age", "f_employment_rate"]].sort_values(by=["age"])
                # 女职工人数
                person["female_worker"] = data5_1["female"].values * \
                                          data7_1["urban_rate"].astype("float32").values * 0.8782 * employ2[
                                              "f_employment_rate"].astype("float32").values * 0.8
                # 死亡的女职工人数
                person["death_female_worker"] = data8["f_death_rate"].values * data5_1["female"].values / (
                        1 - data8["f_death_rate"].values) \
                                                * data7_1["urban_rate"].astype("float32").values * 0.8782 * employ2[
                                                    "f_employment_rate"].astype("float32").values * 0.8

            else:

                # 女干部退休年龄
                rt[2] = dict(data4[["year", "wc_retire"]].astype("float32").values)
                # 女干部计发月数
                m[2] = dict(data4_1[["year", "wc_month"]].values)
                all_j.append(2)
                employ3 = data6[["age", "f_employment_rate"]].sort_values(by=["age"])
                # 女干部人数
                person["female_cadre"] = data5_1["female"].values * \
                                         data7_1["urban_rate"].astype("float32").values * 0.8782 * employ3[
                                             "f_employment_rate"].astype("float32").values * (1 - 0.8)
                # 死亡的女干部人数
                person["death_female_cadre"] = data8["f_death_rate"].values * data5_1["female"].values / (
                        1 - data8["f_death_rate"].values) \
                                               * data7_1["urban_rate"].astype("float32").values * 0.8782 * employ3[
                                                   "f_employment_rate"].astype("float32").values * (1 - 0.8)
        # 第i年养老金收入
        rf0 = f_income(i, person)
        # 第i年老人的支出
        rf1 = f_old(i, person, all_j)
        # 第i年老中人的支出（统筹+个账）
        rf2 = f2_1(i, person, all_j) + f2_2(i, person, all_j)
        # 第i年新中人的支出（统筹+个账）
        rf3 = f3_1(i, person, all_j) + f3_2(i, person, all_j)
        # 第i年新人的支出（统筹+个账）
        rf4 = f4_1(i, person, all_j) + f4_2(i, person, all_j)
        # 第i年个账返还
        rf5 = f_return(i, person, all_j)

        insert_result(id, i, u_o_i, l=[rf0, rf1, rf2, rf3, rf4, rf5])

    db.commit()
    db.close()
