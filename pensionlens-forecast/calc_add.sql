# 查询参保人数和year之间的关系,调试对应的sql代码

#完成参保率的查询
select  year,t_yctxcs_plan_index_year.insurance_rate FROM t_yctxcs_plan_index_year
  where plan_id=2;

#每一年预测期内人数的查询
select year,sum(male)+sum(female) 总人数 FROM t_yctxcs_person_number
  where plan_area=44 and year in (
      select year FROM t_yctxcs_plan_index_year
                  WHERE plan_id=2
      )
  GROUP BY year;


#就业率是固定的，不考虑随年份的变化,从年份的角度来看相当于是一个定值
select avg(m_employment_rate)+avg(f_employment_rate) 平均就业率 FROM t_yctxcs_plan_index_age
  where plan_id=2;

#城镇化率，不同年份有不同的城镇化率
select year,avg(urban_rate) 平均城镇化率 FROM t_yctxcs_plan_index_urban
  where plan_id=2
GROUP BY year;

SELECT
    piy.year AS x,
    pn.总人数 * u.平均城镇化率 * piy.insurance_rate * e.平均就业率 AS y
FROM
    (SELECT year, insurance_rate FROM t_yctxcs_plan_index_year WHERE plan_id=2) piy
JOIN
    (SELECT year, SUM(male) + SUM(female) AS 总人数
     FROM t_yctxcs_person_number
     WHERE plan_area=44
     AND year IN (SELECT year FROM t_yctxcs_plan_index_year WHERE plan_id=2)
     GROUP BY year) pn
ON piy.year = pn.year
JOIN
    (SELECT AVG(m_employment_rate) + AVG(f_employment_rate) AS 平均就业率
     FROM t_yctxcs_plan_index_age
     WHERE plan_id=2) e
JOIN
    (SELECT year, AVG(urban_rate) AS 平均城镇化率
     FROM t_yctxcs_plan_index_urban
     WHERE plan_id=2
     GROUP BY year) u
ON piy.year = u.year;

#查询老人的人均基本养老金的钱
select year AS x,sum(basic_pension)/sum(person_count)/12 AS y FROM t_member
  where plan_id=2 and member_type=0
GROUP BY year;


#查询新人的人均基本养老金,新人可能还没退休

#查询老中人的人均个人养老金
select year AS x,sum(individual_pension)/sum(person_count)/12 AS y FROM t_member
  where plan_id=2 and member_type=1
GROUP BY year;

#查询老中人的人均过渡养老金
select year AS x,sum(transitional_pension)/sum(person_count)/12 AS y FROM t_member
 where plan_id=2 and member_type=1
GROUP BY year;

#查询新中人的人均个人养老金
select  year AS x,sum(individual_pension)/sum(person_count)/12 AS y FROM t_member
 where plan_id=2 and member_type=2
GROUP BY year;

#查询新中人人均过渡养老金
select year AS x,sum(transitional_pension)/sum(person_count)/12 AS y FROM t_member
 where plan_id=2 and member_type=2
GROUP BY year;

#查询新人的人均基本养老金
select year AS x,sum(basic_pension)/sum(person_count)/12 AS y FROM t_member
  where plan_id=2 and member_type=3
GROUP BY year;

#查询新人的人均个人养老金
select year AS x,sum(individual_pension)/sum(person_count)/12 AS y FROM t_member
 where plan_id=2 and member_type=3
GROUP BY year;

create table t_member
(
    id                   int auto_increment comment '标识id ',
    plan_id              tinyint        null comment '测算方案id',
    member_type          tinyint        not null comment '人员类型,0-老人，1-老中人,2-新中人,3-新人',
    member_group         tinyint        not null comment '员工所属类别,0-男性,1-女职工,2-女干部',
    year                 int            null comment '年份',
    age                  int            null comment '年龄',
    basic_pension        decimal(20, 4) null comment '一年总基本养老金',
    transitional_pension decimal(20, 4) null comment '一年总过渡养老金',
    individual_pension   decimal(20, 4) null comment '一年总个人养老金',
    person_count         bigint         null comment '一年总参保人数',
    constraint t_member_pk
        unique (id)
)
    comment '人员类型表';
