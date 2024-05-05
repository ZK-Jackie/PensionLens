import config as cfg
import pymysql
from pymysql.converters import escape_string
import datetime
import requests


def update_state(state, error, id, env, userid):
    if env == 'gstest':

        db = pymysql.connect(host=cfg.host,
                             user=cfg.cs_user,
                             password=cfg.cs_password,
                             port=cfg.cs_port)
        cursor = db.cursor()
        cursor.execute("use %s" % cfg.cs_database)

    else:
        db = pymysql.connect(host=cfg.host,
                             user=cfg.dev_user,
                             password=cfg.dev_password,
                             port=cfg.dev_port)
        cursor = db.cursor()
        cursor.execute("use %s" % cfg.dev_database)

    """
    更新表中的【execute_status】字段
    
    """
    sys_time = datetime.datetime.now()

    def read_sql(sql):
        print('read_sql', sql)

    if state == 2:

        sql1 = """
        
        update t_yctxcs_plan set execute_status=%s where id='%s'
        
        """ % (state, id)

        sql2 = """
        insert into t_yctxcs_plan_history 
        SELECT replace(uuid(),"-",""), '%s',plan_name,plan_area,
        start_year,end_year,%s,execute_time,plan_version,
              last_year_sum_surplus,retire_person_types,
              birth_mode,null,change_type,is_deleted,
             insert_user_id,insert_time,'%s',
             '%s',delete_user_id,delete_time,
              '%s','%s',
             retire_plan_type,retire_plan_value 
             FROM t_yctxcs_plan_history 
              WHERE plan_id = '%s'
              AND change_type = 'EXECUTE' 
              ORDER BY change_time DESC LIMIT 1              
        
        """ % (id, state, userid, sys_time, userid, sys_time, id)

        cursor.execute(sql1)
        # read_sql(sql2)
        cursor.execute(sql2)
        db.commit()

    else:

        sql1 = """
        update t_yctxcs_plan set execute_status=%s,error_reason='%s' where id='%s'
        
        """ % (state, escape_string(error), id)

        sql2 = """
        insert into t_yctxcs_plan_history 
        SELECT replace(uuid(),"-",""), '%s',plan_name,plan_area,
        start_year,end_year,%s,execute_time,plan_version,
              last_year_sum_surplus,retire_person_types,
              birth_mode,'%s',change_type,is_deleted,
             insert_user_id,insert_time,'%s',
             '%s',delete_user_id,delete_time,
              '%s','%s',
             retire_plan_type,retire_plan_value 
             FROM t_yctxcs_plan_history 
              WHERE plan_id = '%s'
              AND change_type = 'EXECUTE' 
              ORDER BY change_time DESC LIMIT 1             
         
         """ % (id, state, escape_string(error), userid, sys_time, userid, sys_time, id)

        cursor.execute(sql1)
        # read_sql(sql2)
        cursor.execute(sql2)
        db.commit()

    sql_his_id = """
    select id
    FROM t_yctxcs_plan_history 
         WHERE plan_id = '%s' 
         AND change_type = 'EXECUTE' 
         ORDER BY change_time DESC LIMIT 1
    
    """ % id
    cursor.execute(sql_his_id)
    cols = cursor.fetchall()
    his_id = list(cols[0])[0]

    if state == 2:

        insert_sql = """insert into t_yctxcs_results_history (id,plan_history_id,\
            year, expense, income, surplus,last_year_sum_surplus)
        select replace(uuid(),"-",""),'%s',year, expense, income, surplus,\
            last_year_sum_surplus from t_yctxcs_results where plan_id='%s'""" % (his_id, id)

        cursor.execute(insert_sql)

        db.commit()

        if env == 'gstest':

            requests.get(url=cfg.cs_url, params={'planHisId': '%s' % his_id})

        else:
            requests.get(url=cfg.dev_url, params={'planHisId': '%s' % his_id})

        db.close()
