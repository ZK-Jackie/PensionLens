DROP DATABASE IF EXISTS calc;
CREATE DATABASE calc;
USE calc;
/****************************************************
  *                                                 *
  *         养老保险大数据测算平台数据库设计v1           *
  *                                                 *
  *    数据库编码：UTF-8        数据库引擎：InnoDB      *
*****************************************************/

/****************测算表格部分****************/
-- -------------------------
-- 1 延迟退休测算计划表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan;
CREATE TABLE t_yctxcs_plan
(
    id                    BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '方案id',
    plan_name             VARCHAR(150) NOT NULL COMMENT '方案名称',
    plan_area             INT          NOT NULL COMMENT '统筹区域',
    start_year            VARCHAR(4)   NOT NULL COMMENT '测算起始年份',
    end_year              VARCHAR(4)   NOT NULL COMMENT '测算结束年份',
    execute_status        VARCHAR(2)   NOT NULL COMMENT '测算执行状态',
    execute_time          DATETIME COMMENT '测算执行时间',
    plan_version          VARCHAR(10)  NOT NULL COMMENT '方案版本号',
    last_year_sum_surplus DECIMAL(20, 4) COMMENT '上一年度养老金累计结余',
    retire_person_types   VARCHAR(10)  NOT NULL COMMENT '退休人员类型',
    birth_mode            VARCHAR(1)   NOT NULL COMMENT '生育模式',
    is_deleted            VARCHAR(1)   NOT NULL DEFAULT 'N' COMMENT '是否删除Y/N',
    insert_user_id        BIGINT(20)   NOT NULL COMMENT '插入人id',
    insert_time           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id   BIGINT(20) COMMENT '最后更新人id',
    last_update_time      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id        BIGINT(20) COMMENT '删除人id',
    delete_time           DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 2 延迟退休测算方案历史表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_history;
CREATE TABLE t_yctxcs_plan_history
(
    id                    BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '方案历史id',
    plan_id               BIGINT(20)   NOT NULL COMMENT '方案id',
    plan_name             VARCHAR(150) NOT NULL COMMENT '方案名称',
    plan_area             INT          NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    start_year            VARCHAR(4)   NOT NULL COMMENT '测算起始年份',
    end_year              VARCHAR(4)   NOT NULL COMMENT '测算结束年份',
    execute_status        VARCHAR(2)   NOT NULL COMMENT '测算执行状态，对应EXECUTE_STATUS字典',
    execute_time          DATETIME COMMENT '测算执行时间',
    plan_version          VARCHAR(10)  NOT NULL COMMENT '测算方案版本',
    last_year_sum_surplus DECIMAL(20, 4) COMMENT '上一年度养老金累计结余',
    retire_person_types   VARCHAR(10)  NOT NULL COMMENT '退休人员类型，对应RETIRE_PERSON_TYPE字典，以多个逗号分隔',
    birth_mode            VARCHAR(1)   NOT NULL COMMENT '生育模式，对应BIRTH_MODE字典',
    change_type           VARCHAR(2)   NOT NULL COMMENT '操作类型，对应CHANGE_TYPE字典：ADD-新增；UPDATE-修改；DELETE-删除',
    change_user_id        BIGINT(20)   NOT NULL COMMENT '操作人id',
    change_time           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '变更时间',
    is_deleted            VARCHAR(1)   NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id        BIGINT(20)   NOT NULL COMMENT '插入人id',
    insert_time           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id   BIGINT(20) COMMENT '最后更新人id',
    last_update_time      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id        BIGINT(20) COMMENT '删除人id',
    delete_time           DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);
-- -------------------------
-- 3 延迟退休测算方案默认参数表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_index;
CREATE TABLE t_yctxcs_index
(
    plan_area       INT           NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    year            INT           NOT NULL COMMENT '年份',
    m_retire        DECIMAL(4, 2) NOT NULL COMMENT '男职工退休年龄',
    f_retire        DECIMAL(4, 2) NOT NULL COMMENT '女职工退休年龄',
    fc_retire       DECIMAL(4, 2) NOT NULL COMMENT '女干部退休年龄',
    avg_salary      DECIMAL(7, 1) NOT NULL COMMENT '在岗平均工资',
    individual_rate DECIMAL(3, 2) NOT NULL COMMENT '个人缴费率',
    enterprise_rate DECIMAL(3, 2) NOT NULL COMMENT '企业缴费率',
    insurance_rate  DECIMAL(6, 5) NOT NULL COMMENT '参保率',
    growth          DECIMAL(6, 5) NOT NULL COMMENT '养老金增长率',
    collect_rate    DECIMAL(6, 5) NOT NULL COMMENT '收缴率',
    transition      DECIMAL(4, 3) NOT NULL COMMENT '过渡系数',
    account_rate    DECIMAL(5, 3) NOT NULL COMMENT '个人账户记账利率',
    m_monthly       INT           NOT NULL COMMENT '男职工计发月数',
    f_monthly       INT           NOT NULL COMMENT '女职工计发月数',
    fc_monthly      INT           NOT NULL COMMENT '女干部计发月数',
    PRIMARY KEY (plan_area, year)
);

-- -------------------------
-- 4 延迟退休测算方案参数描述表
-- -------------------------
DROP TABLE IF EXISTS y_yctxcs_index_description;
CREATE TABLE y_yctxcs_index_description
(
    id                          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    retire_description          TEXT       NOT NULL COMMENT '退休年龄描述',
    insure_description          TEXT       NOT NULL COMMENT '参保率描述',
    individual_rate_description TEXT       NOT NULL COMMENT '个人缴费率描述',
    enterprise_rate_description TEXT       NOT NULL COMMENT '企业缴费率描述',
    collect_rate_description    TEXT       NOT NULL COMMENT '收缴率描述',
    avg_salary_description      TEXT       NOT NULL COMMENT '在岗平均工资描述',
    account_rate_description    TEXT       NOT NULL COMMENT '个人账户记账利率描述',
    transition_description      TEXT       NOT NULL COMMENT '过渡系数描述',
    growth_description          TEXT       NOT NULL COMMENT '养老金增长率描述',
    urbanization_description    TEXT       NOT NULL COMMENT '城镇化率描述',
    employment_rate_description TEXT       NOT NULL COMMENT '就业率描述',
    PRIMARY KEY (id)
);

-- -------------------------
-- 5 测算方案参数表（按年）
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_index_year;
CREATE TABLE t_yctxcs_plan_index_year
(
    id                  BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    year                INT           NOT NULL COMMENT '年份',
    plan_id             BIGINT(20)    NOT NULL COMMENT '方案id',
    m_retire            DECIMAL(4, 2) NOT NULL COMMENT '男职工退休年龄',
    f_retire            DECIMAL(4, 2) NOT NULL COMMENT '女职工退休年龄',
    fc_retire           DECIMAL(4, 2) NOT NULL COMMENT '女干部退休年龄',
    insurance_rate      DECIMAL(6, 5) NOT NULL COMMENT '参保率',
    individual_rate     DECIMAL(3, 2) NOT NULL COMMENT '个人缴费率',
    enterprise_rate     DECIMAL(3, 2) NOT NULL COMMENT '企业缴费率',
    collect_rate        DECIMAL(6, 5) NOT NULL COMMENT '收缴率',
    avg_salary          DECIMAL(7, 1) NOT NULL COMMENT '在岗平均工资',
    account_rate        DECIMAL(5, 4) NOT NULL COMMENT '个人账户记账利率',
    transition          DECIMAL(4, 3) NOT NULL COMMENT '过渡系数',
    growth              DECIMAL(6, 5) NOT NULL COMMENT '养老金增长率',
    is_deleted          VARCHAR(1)    NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)    NOT NULL COMMENT '插入人id',
    insert_time         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 6 测算方案参数历史表（按年）
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_index_year_his;
CREATE TABLE t_yctxcs_plan_index_year_his
(
    id                  BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    year                INT           NOT NULL COMMENT '年份',
    plan_history_id     BIGINT(20)    NOT NULL COMMENT '方案历史id',
    m_retire            DECIMAL(4, 2) NOT NULL COMMENT '男职工退休年龄',
    f_retire            DECIMAL(4, 2) NOT NULL COMMENT '女职工退休年龄',
    fc_retire           DECIMAL(4, 2) NOT NULL COMMENT '女干部退休年龄',
    insurance_rate      DECIMAL(6, 5) NOT NULL COMMENT '参保率',
    individual_rate     DECIMAL(3, 2) NOT NULL COMMENT '个人缴费率',
    enterprise_rate     DECIMAL(3, 2) NOT NULL COMMENT '企业缴费率',
    collect_rate        DECIMAL(6, 5) NOT NULL COMMENT '收缴率',
    avg_salary          DECIMAL(7, 1) NOT NULL COMMENT '在岗平均工资',
    account_rate        DECIMAL(4, 3) NOT NULL COMMENT '个人账户记账利率',
    transition          DECIMAL(4, 3) NOT NULL COMMENT '过渡系数',
    growth              DECIMAL(6, 5) NOT NULL COMMENT '养老金增长率',
    is_deleted          VARCHAR(1)    NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)    NOT NULL COMMENT '插入人id',
    insert_time         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 7 测算方案参数表（按年龄）
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_index_age;
CREATE TABLE t_yctxcs_plan_index_age
(
    id                  BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    age                 INT           NOT NULL COMMENT '年龄',
    plan_id             BIGINT(20)    NOT NULL COMMENT '方案id',
    m_employment_rate   DECIMAL(6, 5) NOT NULL COMMENT '男性就业率',
    f_employment_rate   DECIMAL(6, 5) NOT NULL COMMENT '女性就业率',
    is_deleted          VARCHAR(1)    NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)    NOT NULL COMMENT '插入人id',
    insert_time         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 8 测算方案参数历史表（按年龄）
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_index_age_his;
CREATE TABLE t_yctxcs_plan_index_age_his
(
    id                  BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    age                 INT           NOT NULL COMMENT '年龄',
    plan_history_id     BIGINT(20)    NOT NULL COMMENT '方案历史id',
    m_employment_rate   DECIMAL(6, 5) NOT NULL COMMENT '男性就业率',
    f_employment_rate   DECIMAL(6, 5) NOT NULL COMMENT '女性就业率',
    is_deleted          VARCHAR(1)    NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)    NOT NULL COMMENT '插入人id',
    insert_time         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 9 测算城镇化率参数表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_index_urban;
CREATE TABLE t_yctxcs_plan_index_urban
(
    id                  BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    year                INT           NOT NULL COMMENT '年份',
    age                 INT           NOT NULL COMMENT '年龄',
    plan_id             BIGINT(20)    NOT NULL COMMENT '方案id',
    urban_rate          DECIMAL(6, 5) NOT NULL COMMENT '城镇化率',
    is_deleted          VARCHAR(1)    NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)    NOT NULL COMMENT '插入人id',
    insert_time         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 10 测算城镇化率历史表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_index_urban_his;
CREATE TABLE t_yctxcs_plan_index_urban_his
(
    id                  BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    year                INT           NOT NULL COMMENT '年份',
    age                 INT           NOT NULL COMMENT '年龄',
    plan_history_id     BIGINT(20)    NOT NULL COMMENT '方案历史id',
    urban_rate          DECIMAL(6, 5) NOT NULL COMMENT '城镇化率',
    is_deleted          VARCHAR(1)    NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)    NOT NULL COMMENT '插入人id',
    insert_time         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 11 测算方案访问表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_plan_visit;
CREATE TABLE t_yctxcs_plan_visit
(
    id                  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    plan_history_id     BIGINT(20) NOT NULL COMMENT '方案历史id',
    user_id             BIGINT(20) NOT NULL COMMENT '用户id',
    is_deleted          VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20) NOT NULL COMMENT '插入人id',
    insert_time         DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);

-- -------------------------
-- 12 测算默认人口数量表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_person_index;
CREATE TABLE t_yctxcs_person_index
(
    plan_area         INT           NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    age               INT           NOT NULL COMMENT '年龄',
    m_death_rate      DECIMAL(6, 5) NOT NULL COMMENT '男性死亡率',
    f_death_rate      DECIMAL(6, 5) NOT NULL COMMENT '女性死亡率',
    m_employment_rate DECIMAL(6, 5) NOT NULL COMMENT '男性就业率',
    f_employment_rate DECIMAL(6, 5) NOT NULL COMMENT '女性就业率',
    PRIMARY KEY (plan_area, age)
);

-- -------------------------
-- 13 测算城镇化率默认参数表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_urban_rate;
CREATE TABLE t_yctxcs_urban_rate
(
    plan_area  INT           NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    year       INT           NOT NULL COMMENT '年份',
    age        INT           NOT NULL COMMENT '年龄',
    urban_rate DECIMAL(6, 5) NOT NULL COMMENT '城镇化率',
    PRIMARY KEY (plan_area, year, age)
);

-- -------------------------
-- 14 测算默认年份分年龄性别人数
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_person_number;
CREATE TABLE t_yctxcs_person_number
(
    plan_area  INT        NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    birth_mode VARCHAR(1) NOT NULL COMMENT '生育模式，对应BIRTH_MODE字典',
    year       INT        NOT NULL COMMENT '年份',
    age        INT        NOT NULL COMMENT '年龄',
    male       INT        NOT NULL COMMENT '男性人数',
    female     INT        NOT NULL COMMENT '女性人数',
    PRIMARY KEY (plan_area, birth_mode, year, age)
);

-- -------------------------
-- 15 人口预测参数（按年份）
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_person_predict_year;
CREATE TABLE t_yctxcs_person_predict_year
(
    plan_area               INT           NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    year                    INT           NOT NULL COMMENT '年份',
    male_pre_life           DECIMAL(5, 3) NOT NULL COMMENT '男性预期寿命-死亡水平',
    female_pre_life         DECIMAL(5, 3) NOT NULL COMMENT '女性预期寿命-死亡水平',
    sex_ratio_birth         DECIMAL(6, 3) NOT NULL COMMENT '出生性别比',
    male_migration_number   INT           NOT NULL COMMENT '男性迁移水平',
    female_migration_number INT           NOT NULL COMMENT '女性迁移水平',
    PRIMARY KEY (plan_area, year)
);

-- -------------------------
-- 16 人口预测参数（按年龄）
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_person_predict_age;
CREATE TABLE t_yctxcs_person_predict_age
(
    plan_area             INT            NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    age                   INT            NOT NULL COMMENT '年龄',
    male                  INT            NOT NULL COMMENT '男性人数-起始人口',
    female                INT            NOT NULL COMMENT '女性人数-起始人口',
    male_death_mode       DECIMAL(10, 9) NOT NULL COMMENT '男性死亡模式',
    female_death_mode     DECIMAL(10, 9) NOT NULL COMMENT '女性死亡模式',
    birth_mode            VARCHAR(1)     NOT NULL COMMENT '生育模式，对应BIRTH_MODE字典',
    male_migration_mode   DECIMAL(10, 9) NOT NULL COMMENT '男性迁移模式',
    female_migration_mode DECIMAL(10, 9) NOT NULL COMMENT '女性迁移模式',
    PRIMARY KEY (plan_area, age)
);

-- -------------------------
-- 17 结果预测表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_results;
CREATE TABLE t_yctxcs_results
(
    id                    BIGINT(20)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    plan_id               BIGINT(20)     NOT NULL COMMENT '方案id',
    year                  INT            NOT NULL COMMENT '年份',
    expense               DECIMAL(20, 4) NOT NULL COMMENT '养老金支出',
    income                DECIMAL(20, 4) NOT NULL COMMENT '养老金征缴收入',
    surplus               DECIMAL(20, 4) NOT NULL COMMENT '养老金累计结余',
    last_year_sum_surplus DECIMAL(20, 4) COMMENT '上一年度养老金累计结余',
    PRIMARY KEY (id)
);

-- -------------------------
-- 18 结果预测历史表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_results_history;
CREATE TABLE t_yctxcs_results_history
(
    id                    BIGINT(20)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    plan_history_id       BIGINT(20)     NOT NULL COMMENT '方案历史id',
    year                  INT            NOT NULL COMMENT '年份',
    expense               DECIMAL(20, 4) NOT NULL COMMENT '养老金支出',
    income                DECIMAL(20, 4) NOT NULL COMMENT '养老金征缴收入',
    surplus               DECIMAL(20, 4) NOT NULL COMMENT '养老金累计结余',
    last_year_sum_surplus DECIMAL(20, 4) COMMENT '上一年度养老金累计结余',
    PRIMARY KEY (id)
);

-- -------------------------
-- 19 测算结果默认表
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_default_results;
CREATE TABLE t_yctxcs_default_results
(
    plan_area  INT            NOT NULL COMMENT '统筹区域，对应t_yctxcs_area_code_dict的code值',
    birth_mode VARCHAR(1)     NOT NULL COMMENT '生育模式，对应BIRTH_MODE字典',
    year       INT            NOT NULL COMMENT '年份',
    expense    DECIMAL(20, 4) NOT NULL COMMENT '养老金支出',
    income     DECIMAL(20, 4) NOT NULL COMMENT '养老金征缴收入',
    surplus    DECIMAL(20, 4) NOT NULL COMMENT '养老金累计结余',
    PRIMARY KEY (plan_area, birth_mode, year)
);

-- -------------------------
-- 20 测算统筹区域
-- -------------------------
DROP TABLE IF EXISTS t_yctxcs_area_code_dict;
CREATE TABLE t_yctxcs_area_code_dict
(
    code        INT          NOT NULL COMMENT '区域代码',
    area_name   VARCHAR(100) NOT NULL COMMENT '区域名称',
    base_year   INT          NOT NULL COMMENT '计算视同缴费年限的截止年份',
    policy_1999 INT          NOT NULL COMMENT '该统筹区域按照【国发[1997]26号】要求实施相应政策的年份',
    policy_2005 INT          NOT NULL COMMENT '该统筹区域按照【国发[2005]38号】要求实施相应政策的年份',
    PRIMARY KEY (code)
);

-- -------------------------
-- 21 大屏表
-- -------------------------
DROP TABLE IF EXISTS screen;
CREATE TABLE screen
(
    screen_id           BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键id',
    screen_name         VARCHAR(50) NOT NULL COMMENT '大屏名称',
    is_predict          VARCHAR(1)  NOT NULL DEFAULT 'N' COMMENT '是否是预测大屏，N-否，Y-是',
    is_active           VARCHAR(1)  NOT NULL DEFAULT 'N' COMMENT '是否启用，N-否，Y-是',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    create_time         DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    create_user_id      BIGINT(20)  NOT NULL COMMENT '创建人id',
    is_deleted          VARCHAR(1)  NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    delete_time         DATETIME COMMENT '删除时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    PRIMARY KEY (screen_id)
);

-- -------------------------
-- 22 大屏绑定预测方案
-- -------------------------
DROP TABLE IF EXISTS screen_plan;
CREATE TABLE screen_plan
(
    screen_id           BIGINT(20) NOT NULL COMMENT '大屏id',
    plan_id             BIGINT(20) NOT NULL COMMENT '方案id',
    priority            SMALLINT   NOT NULL COMMENT '方案优先级',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (screen_id, plan_id)
);

-- -------------------------
-- 23 大屏配置表
-- -------------------------
DROP TABLE IF EXISTS screen_detail;
CREATE TABLE screen_detail
(
    detail_id           BIGINT(20)  NOT NULL COMMENT '图表配置id',
    screen_id           BIGINT(20)  NOT NULL COMMENT '大屏id',
    detail_spot         SMALLINT    NOT NULL COMMENT '图表位置',
    detail_name         VARCHAR(50) NOT NULL COMMENT '图表名称',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (detail_id, screen_id, detail_spot)
);

-- -------------------------
-- 25 大屏空位与大屏数据对照表
-- -------------------------
DROP TABLE IF EXISTS screen_detail_data;
CREATE TABLE screen_detail_data
(
    detail_id           BIGINT(20)  NOT NULL COMMENT '图表配置id',
    data_id             BIGINT(20)  NOT NULL COMMENT '图表数据id',
    display_mode        VARCHAR(20) NOT NULL COMMENT '图表类型，参照CHART_TYPE字典',
    start_time          DATETIME    NOT NULL COMMENT '数据开始时间',
    end_time            DATETIME    NOT NULL COMMENT '数据结束时间',
    -- predict switch is decided by the screen user
    -- is_predict          VARCHAR(1)  NOT NULL COMMENT '是否是预测数据，N-否，Y-是',
    predict_start_time  DATETIME    NOT NULL COMMENT '预测数据开始时间',
    predict_end_time    DATETIME    NOT NULL COMMENT '预测数据结束时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (detail_id, data_id)
);

-- -------------------------
-- 26 大屏数据定位及数据设定表
-- -------------------------
DROP TABLE IF EXISTS screen_data;
CREATE TABLE screen_data
(
    data_id             BIGINT(20)     NOT NULL COMMENT '数据id',
    data_name           VARCHAR(100)   NOT NULL COMMENT '数据名称',
    data_location       VARCHAR(100)   NOT NULL COMMENT '数据所在表',/*这个字段要隐藏*/
    displayable_mode    VARCHAR(100)   NOT NULL COMMENT '数据可展现的形式，对照CHART_TYPE字典',
    key_label           VARCHAR(20)    NOT NULL COMMENT '数据键的标签名',
    key_unit            VARCHAR(20)    NOT NULL COMMENT '数据键的单位',
    value_label         VARCHAR(20)    NOT NULL COMMENT '数据值的标签名',
    value_unit          VARCHAR(20)    NOT NULL COMMENT '数据值的单位',
    num_precision       DECIMAL(6, 5)  NOT NULL COMMENT '数据呈现精度',
    max_value           DECIMAL(20, 4) NOT NULL COMMENT '数据值最大值',
    min_value           DECIMAL(20, 4) NOT NULL COMMENT '数据值最小值',
    data_color          VARCHAR(7)     NOT NULL COMMENT '数据颜色',
    is_predict          VARCHAR(1)     NOT NULL COMMENT '是否是预测的数据，N-否，Y-是',
    is_info             VARCHAR(1)     NOT NULL COMMENT '是否是资讯类数据，N-否，Y-是',
    is_default          VARCHAR(1)     NOT NULL COMMENT '是否是默认数据，N-否，Y-是',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (data_id)
);


/*****************字典部分******************/
-- -------------------------
-- 1 字典类型
-- -------------------------
DROP TABLE IF EXISTS t_dic_type;
CREATE TABLE t_dic_type
(
    id                  INT AUTO_INCREMENT NOT NULL COMMENT '主键id',
    dic_name            VARCHAR(20)        NOT NULL COMMENT '字典名称',
    dic_type            VARCHAR(20)        NOT NULL COMMENT '字典类型',
    description         VARCHAR(100)       NOT NULL COMMENT '字典描述',
    is_deleted          VARCHAR(1)         NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)         NOT NULL COMMENT '插入人id',
    insert_time         DATETIME           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);
INSERT INTO t_dic_type (dic_name, dic_type, description, insert_user_id)
VALUES ('测算状态', 'EXECUTE_STATUS', '当前测算表进度正处于的状态', 0),
       ('退休人员类型', 'RETIRE_PERSON_TYPE', '退休人员类型', 0),
       ('生育模式', 'BIRTH_MODE', '生育模式', 0),
       ('变更类型', 'CHANGE_TYPE', '变更类型', 0);

-- -------------------------
-- 2 字典数据
-- -------------------------
DROP TABLE IF EXISTS t_dic_data;
CREATE TABLE t_dic_data
(
    id                  INT          NOT NULL AUTO_INCREMENT COMMENT '字典id',
    dic_sort            INT          NOT NULL COMMENT '字典排序',
    dic_label           VARCHAR(20)  NOT NULL COMMENT '字典数据标签',
    dic_value           VARCHAR(20)  NOT NULL COMMENT '字典数据值',
    dic_type            VARCHAR(20)  NOT NULL COMMENT '字典类型id',
    description         VARCHAR(100) NOT NULL COMMENT '字典描述',
    is_default          VARCHAR(1)   NOT NULL DEFAULT 'N' COMMENT '是否默认，N-否，Y-是',
    is_deleted          VARCHAR(1)   NOT NULL DEFAULT 'N' COMMENT '是否删除，N-否，Y-是',
    insert_user_id      BIGINT(20)   NOT NULL COMMENT '插入人id',
    insert_time         DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    delete_user_id      BIGINT(20) COMMENT '删除人id',
    delete_time         DATETIME COMMENT '删除时间',
    PRIMARY KEY (id)
);
INSERT INTO t_dic_data (dic_sort, dic_label, dic_value, dic_type, description, is_default, insert_user_id)
VALUES (1, '未测算', '0', 'EXECUTE_STATUS', '未测算', 'Y', 0),
       (2, '测算中', '1', 'EXECUTE_STATUS', '测算中', 'N', 0),
       (3, '成功', '2', 'EXECUTE_STATUS', '测算完成', 'N', 0),
       (4, '失败', '3', 'EXECUTE_STATUS', '测算失败', 'N', 0),
       (1, '男性', '0', 'RETIRE_PERSON_TYPE', '男职工', 'Y', 0),
       (2, '女职工', '1', 'RETIRE_PERSON_TYPE', '女职工', 'N', 0),
       (3, '女干部', '2', 'RETIRE_PERSON_TYPE', '女干部', 'N', 0),
       (1, '低', '0', 'BIRTH_MODE', '低生育模式', 'N', 0),
       (2, '中', '1', 'BIRTH_MODE', '中生育模式', 'Y', 0),
       (3, '高', '2', 'BIRTH_MODE', '高生育模式', 'N', 0),
       (1, '新增', '0', 'CHANGE_TYPE', '新增', 'N', 0),
       (2, '修改', '1', 'CHANGE_TYPE', '修改', 'N', 0),
       (3, '删除', '2', 'CHANGE_TYPE', '删除', 'N', 0),
       (1, 'Integer', '0', 'PRESENTATION_FORMAT', '整数', 'Y', 0),
       (2, 'Decimal', '1', 'PRESENTATION_FORMAT', '小数', 'N', 0),
       (3, 'Percentage', '2', 'PRESENTATION_FORMAT', '百分比', 'N', 0),
       (4, 'Date', '3', 'PRESENTATION_FORMAT', '日期', 'N', 0),
       (5, 'String', '4', 'PRESENTATION_FORMAT', '字符串', 'N', 0);


/***********************系统管理用户部分***********************/
-- ----------------------------
-- 1、部门表
-- ----------------------------
DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept
(
    dept_id     BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
    parent_id   BIGINT(20)  DEFAULT 0 COMMENT '父部门id',
    ancestors   VARCHAR(50) DEFAULT '' COMMENT '祖级列表',
    dept_name   VARCHAR(30) DEFAULT '' COMMENT '部门名称',
    order_num   INT(4)      DEFAULT 0 COMMENT '显示顺序',
    leader      VARCHAR(20) DEFAULT NULL COMMENT '负责人',
    phone       VARCHAR(11) DEFAULT NULL COMMENT '联系电话',
    email       VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
    status      CHAR(1)     DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
    del_flag    CHAR(1)     DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    create_by   VARCHAR(64) DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by   VARCHAR(64) DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    PRIMARY KEY (dept_id)
) ENGINE = innodb
  AUTO_INCREMENT = 200 COMMENT = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
INSERT INTO sys_dept
VALUES (100, 0, '0', '广东海洋大学', 0, '广海', '15888888888', 'yj@gdou.edu.cn', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (101, 100, '0,100', '深圳总公司', 1, '深圳', '15888888888', 'sz@qq.com', '0', '0', 'admin', SYSDATE(), '', NULL);
INSERT INTO sys_dept
VALUES (102, 100, '0,100', '长沙分公司', 2, '长沙', '15888888888', 'cs@qq.com', '0', '0', 'admin', SYSDATE(), '', NULL);
INSERT INTO sys_dept
VALUES (103, 101, '0,100,101', '研发部门', 1, '研发', '15888888888', 'yf@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (104, 101, '0,100,101', '市场部门', 2, '市场', '15888888888', 'sc@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (105, 101, '0,100,101', '测试部门', 3, '测试', '15888888888', 'cs@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (106, 101, '0,100,101', '财务部门', 4, '财务', '15888888888', 'cw@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (107, 101, '0,100,101', '运维部门', 5, '运维', '15888888888', 'yw@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (108, 102, '0,100,102', '市场部门', 1, '市场', '15888888888', 'sc@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);
INSERT INTO sys_dept
VALUES (109, 102, '0,100,102', '财务部门', 2, '财务', '15888888888', 'cw@qq.com', '0', '0', 'admin', SYSDATE(), '',
        NULL);


-- ----------------------------
-- 2、用户信息表
-- ----------------------------
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    user_id     BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    dept_id     BIGINT(20)   DEFAULT NULL COMMENT '部门ID',
    user_name   VARCHAR(30) NOT NULL COMMENT '用户账号',
    nick_name   VARCHAR(30) NOT NULL COMMENT '用户昵称',
    user_type   VARCHAR(2)   DEFAULT '00' COMMENT '用户类型（00系统用户）',
    email       VARCHAR(50)  DEFAULT '' COMMENT '用户邮箱',
    phonenumber VARCHAR(11)  DEFAULT '' COMMENT '手机号码',
    sex         CHAR(1)      DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
    avatar      VARCHAR(100) DEFAULT '' COMMENT '头像地址',
    password    VARCHAR(100) DEFAULT '' COMMENT '密码',
    status      CHAR(1)      DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
    del_flag    CHAR(1)      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    login_ip    VARCHAR(128) DEFAULT '' COMMENT '最后登录IP',
    login_date  DATETIME COMMENT '最后登录时间',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by   VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (user_id)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
INSERT INTO sys_user
VALUES (1, 103, 'gdouyj', '广东海洋大学阳江校区', '00', 'yj@gdou.edu.cn', '15888888888', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', SYSDATE(), 'admin',
        SYSDATE(), '', NULL, '管理员');
INSERT INTO sys_user
VALUES (2, 105, 'yj', '阳江', '00', 'yj@qq.com', '15666666666', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', SYSDATE(), 'admin',
        SYSDATE(), '', NULL, '测试员');


-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
DROP TABLE IF EXISTS sys_post;
CREATE TABLE sys_post
(
    post_id     BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
    post_code   VARCHAR(64) NOT NULL COMMENT '岗位编码',
    post_name   VARCHAR(50) NOT NULL COMMENT '岗位名称',
    post_sort   INT(4)      NOT NULL COMMENT '显示顺序',
    status      CHAR(1)     NOT NULL COMMENT '状态（0正常 1停用）',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by   VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (post_id)
) ENGINE = innodb COMMENT = '岗位信息表';

-- ----------------------------
-- 初始化-岗位信息表数据
-- ----------------------------
INSERT INTO sys_post
VALUES (1, 'ceo', '董事长', 1, '0', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_post
VALUES (2, 'se', '项目经理', 2, '0', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_post
VALUES (3, 'hr', '人力资源', 3, '0', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_post
VALUES (4, 'user', '普通员工', 4, '0', 'admin', SYSDATE(), '', NULL, '');


-- ----------------------------
-- 4、角色信息表
-- ----------------------------
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    role_id             BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    role_name           VARCHAR(30)  NOT NULL COMMENT '角色名称',
    role_key            VARCHAR(100) NOT NULL COMMENT '角色权限字符串',
    role_sort           INT(4)       NOT NULL COMMENT '显示顺序',
    data_scope          CHAR(1)      DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
    menu_check_strictly TINYINT(1)   DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
    dept_check_strictly TINYINT(1)   DEFAULT 1 COMMENT '部门树选择项是否关联显示',
    status              CHAR(1)      NOT NULL COMMENT '角色状态（0正常 1停用）',
    del_flag            CHAR(1)      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    create_by           VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time         DATETIME COMMENT '创建时间',
    update_by           VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time         DATETIME COMMENT '更新时间',
    remark              VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (role_id)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
INSERT INTO sys_role
VALUES ('1', '超级管理员', 'admin', 1, 1, 1, 1, '0', '0', 'admin', SYSDATE(), '', NULL, '超级管理员');
INSERT INTO sys_role
VALUES ('2', '普通角色', 'common', 2, 2, 1, 1, '0', '0', 'admin', SYSDATE(), '', NULL, '普通角色');


-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu
(
    menu_id     BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    menu_name   VARCHAR(50) NOT NULL COMMENT '菜单名称',
    parent_id   BIGINT(20)   DEFAULT 0 COMMENT '父菜单ID',
    order_num   INT(4)       DEFAULT 0 COMMENT '显示顺序',
    path        VARCHAR(200) DEFAULT '' COMMENT '路由地址',
    component   VARCHAR(255) DEFAULT NULL COMMENT '组件路径',
    query       VARCHAR(255) DEFAULT NULL COMMENT '路由参数',
    is_frame    INT(1)       DEFAULT 1 COMMENT '是否为外链（0是 1否）',
    is_cache    INT(1)       DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
    menu_type   CHAR(1)      DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
    visible     CHAR(1)      DEFAULT 0 COMMENT '菜单状态（0显示 1隐藏）',
    status      CHAR(1)      DEFAULT 0 COMMENT '菜单状态（0正常 1停用）',
    perms       VARCHAR(100) DEFAULT NULL COMMENT '权限标识',
    icon        VARCHAR(100) DEFAULT '#' COMMENT '菜单图标',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by   VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark      VARCHAR(500) DEFAULT '' COMMENT '备注',
    PRIMARY KEY (menu_id)
) ENGINE = innodb
  AUTO_INCREMENT = 2000 COMMENT = '菜单权限表';

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
INSERT INTO sys_menu
VALUES ('1', '系统管理', '0', '1', 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', SYSDATE(), '', NULL,
        '系统管理目录');
INSERT INTO sys_menu
VALUES ('2', '系统监控', '0', '2', 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', SYSDATE(), '',
        NULL, '系统监控目录');
INSERT INTO sys_menu
VALUES ('3', '系统工具', '0', '3', 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', SYSDATE(), '', NULL,
        '系统工具目录');
-- 二级菜单
INSERT INTO sys_menu
VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user',
        'admin', SYSDATE(), '', NULL, '用户管理菜单');
INSERT INTO sys_menu
VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list',
        'peoples', 'admin', SYSDATE(), '', NULL, '角色管理菜单');
INSERT INTO sys_menu
VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list',
        'tree-table', 'admin', SYSDATE(), '', NULL, '菜单管理菜单');
INSERT INTO sys_menu
VALUES ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree',
        'admin', SYSDATE(), '', NULL, '部门管理菜单');
INSERT INTO sys_menu
VALUES ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post',
        'admin', SYSDATE(), '', NULL, '岗位管理菜单');
INSERT INTO sys_menu
VALUES ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict',
        'admin', SYSDATE(), '', NULL, '字典管理菜单');
INSERT INTO sys_menu
VALUES ('106', '参数设置', '1', '7', 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list',
        'edit', 'admin', SYSDATE(), '', NULL, '参数设置菜单');
INSERT INTO sys_menu
VALUES ('107', '通知公告', '1', '8', 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list',
        'message', 'admin', SYSDATE(), '', NULL, '通知公告菜单');
INSERT INTO sys_menu
VALUES ('108', '日志管理', '1', '9', 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', SYSDATE(), '', NULL,
        '日志管理菜单');
INSERT INTO sys_menu
VALUES ('109', '在线用户', '2', '1', 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list',
        'online', 'admin', SYSDATE(), '', NULL, '在线用户菜单');
INSERT INTO sys_menu
VALUES ('110', '定时任务', '2', '2', 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job',
        'admin', SYSDATE(), '', NULL, '定时任务菜单');
INSERT INTO sys_menu
VALUES ('111', '数据监控', '2', '3', 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list',
        'druid', 'admin', SYSDATE(), '', NULL, '数据监控菜单');
INSERT INTO sys_menu
VALUES ('112', '服务监控', '2', '4', 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list',
        'server', 'admin', SYSDATE(), '', NULL, '服务监控菜单');
INSERT INTO sys_menu
VALUES ('113', '缓存监控', '2', '5', 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list',
        'redis', 'admin', SYSDATE(), '', NULL, '缓存监控菜单');
INSERT INTO sys_menu
VALUES ('114', '缓存列表', '2', '6', 'cacheList', 'monitor/cache/list', '', 1, 0, 'C', '0', '0', 'monitor:cache:list',
        'redis-list', 'admin', SYSDATE(), '', NULL, '缓存列表菜单');
INSERT INTO sys_menu
VALUES ('115', '表单构建', '3', '1', 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build',
        'admin', SYSDATE(), '', NULL, '表单构建菜单');
INSERT INTO sys_menu
VALUES ('116', '代码生成', '3', '2', 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin',
        SYSDATE(), '', NULL, '代码生成菜单');
INSERT INTO sys_menu
VALUES ('117', '系统接口', '3', '3', 'swagger', 'tool/swagger/index', '', 1, 0, 'C', '0', '0', 'tool:swagger:list',
        'swagger', 'admin', SYSDATE(), '', NULL, '系统接口菜单');
-- 三级菜单
INSERT INTO sys_menu
VALUES ('500', '操作日志', '108', '1', 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0',
        'monitor:operlog:list', 'form', 'admin', SYSDATE(), '', NULL, '操作日志菜单');
INSERT INTO sys_menu
VALUES ('501', '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0',
        'monitor:logininfor:list', 'logininfor', 'admin', SYSDATE(), '', NULL, '登录日志菜单');
-- 用户管理按钮
INSERT INTO sys_menu
VALUES ('1000', '用户查询', '100', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1001', '用户新增', '100', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1002', '用户修改', '100', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1003', '用户删除', '100', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1004', '用户导出', '100', '5', '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1005', '用户导入', '100', '6', '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1006', '重置密码', '100', '7', '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin',
        SYSDATE(), '', NULL, '');
-- 角色管理按钮
INSERT INTO sys_menu
VALUES ('1007', '角色查询', '101', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1008', '角色新增', '101', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1009', '角色修改', '101', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1010', '角色删除', '101', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1011', '角色导出', '101', '5', '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', SYSDATE(),
        '', NULL, '');
-- 菜单管理按钮
INSERT INTO sys_menu
VALUES ('1012', '菜单查询', '102', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1013', '菜单新增', '102', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1014', '菜单修改', '102', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1015', '菜单删除', '102', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
-- 部门管理按钮
INSERT INTO sys_menu
VALUES ('1016', '部门查询', '103', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1017', '部门新增', '103', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1018', '部门修改', '103', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1019', '部门删除', '103', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
-- 岗位管理按钮
INSERT INTO sys_menu
VALUES ('1020', '岗位查询', '104', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1021', '岗位新增', '104', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1022', '岗位修改', '104', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1023', '岗位删除', '104', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1024', '岗位导出', '104', '5', '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', SYSDATE(),
        '', NULL, '');
-- 字典管理按钮
INSERT INTO sys_menu
VALUES ('1025', '字典查询', '105', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1026', '字典新增', '105', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1027', '字典修改', '105', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1028', '字典删除', '105', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1029', '字典导出', '105', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', SYSDATE(),
        '', NULL, '');
-- 参数设置按钮
INSERT INTO sys_menu
VALUES ('1030', '参数查询', '106', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1031', '参数新增', '106', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1032', '参数修改', '106', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1033', '参数删除', '106', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1034', '参数导出', '106', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin',
        SYSDATE(), '', NULL, '');
-- 通知公告按钮
INSERT INTO sys_menu
VALUES ('1035', '公告查询', '107', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1036', '公告新增', '107', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1037', '公告修改', '107', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1038', '公告删除', '107', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin',
        SYSDATE(), '', NULL, '');
-- 操作日志按钮
INSERT INTO sys_menu
VALUES ('1039', '操作查询', '500', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1040', '操作删除', '500', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1041', '日志导出', '500', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin',
        SYSDATE(), '', NULL, '');
-- 登录日志按钮
INSERT INTO sys_menu
VALUES ('1042', '登录查询', '501', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1043', '登录删除', '501', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1044', '日志导出', '501', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1045', '账户解锁', '501', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:unlock', '#', 'admin',
        SYSDATE(), '', NULL, '');
-- 在线用户按钮
INSERT INTO sys_menu
VALUES ('1046', '在线查询', '109', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1047', '批量强退', '109', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1048', '单条强退', '109', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin',
        SYSDATE(), '', NULL, '');
-- 定时任务按钮
INSERT INTO sys_menu
VALUES ('1049', '任务查询', '110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1050', '任务新增', '110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1051', '任务修改', '110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1052', '任务删除', '110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1053', '状态修改', '110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin',
        SYSDATE(), '', NULL, '');
INSERT INTO sys_menu
VALUES ('1054', '任务导出', '110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', SYSDATE(),
        '', NULL, '');
-- 代码生成按钮
INSERT INTO sys_menu
VALUES ('1055', '生成查询', '116', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1056', '生成修改', '116', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_menu
VALUES ('1057', '生成删除', '116', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1058', '导入代码', '116', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1059', '预览代码', '116', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_menu
VALUES ('1060', '生成代码', '116', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', SYSDATE(), '',
        NULL, '');


-- ----------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    user_id BIGINT(20) NOT NULL COMMENT '用户ID',
    role_id BIGINT(20) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (user_id, role_id)
) ENGINE = innodb COMMENT = '用户和角色关联表';

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
INSERT INTO sys_user_role
VALUES ('1', '1');
INSERT INTO sys_user_role
VALUES ('2', '2');


-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu
(
    role_id BIGINT(20) NOT NULL COMMENT '角色ID',
    menu_id BIGINT(20) NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (role_id, menu_id)
) ENGINE = innodb COMMENT = '角色和菜单关联表';

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
INSERT INTO sys_role_menu
VALUES ('2', '1');
INSERT INTO sys_role_menu
VALUES ('2', '2');
INSERT INTO sys_role_menu
VALUES ('2', '3');
INSERT INTO sys_role_menu
VALUES ('2', '4');
INSERT INTO sys_role_menu
VALUES ('2', '100');
INSERT INTO sys_role_menu
VALUES ('2', '101');
INSERT INTO sys_role_menu
VALUES ('2', '102');
INSERT INTO sys_role_menu
VALUES ('2', '103');
INSERT INTO sys_role_menu
VALUES ('2', '104');
INSERT INTO sys_role_menu
VALUES ('2', '105');
INSERT INTO sys_role_menu
VALUES ('2', '106');
INSERT INTO sys_role_menu
VALUES ('2', '107');
INSERT INTO sys_role_menu
VALUES ('2', '108');
INSERT INTO sys_role_menu
VALUES ('2', '109');
INSERT INTO sys_role_menu
VALUES ('2', '110');
INSERT INTO sys_role_menu
VALUES ('2', '111');
INSERT INTO sys_role_menu
VALUES ('2', '112');
INSERT INTO sys_role_menu
VALUES ('2', '113');
INSERT INTO sys_role_menu
VALUES ('2', '114');
INSERT INTO sys_role_menu
VALUES ('2', '115');
INSERT INTO sys_role_menu
VALUES ('2', '116');
INSERT INTO sys_role_menu
VALUES ('2', '117');
INSERT INTO sys_role_menu
VALUES ('2', '500');
INSERT INTO sys_role_menu
VALUES ('2', '501');
INSERT INTO sys_role_menu
VALUES ('2', '1000');
INSERT INTO sys_role_menu
VALUES ('2', '1001');
INSERT INTO sys_role_menu
VALUES ('2', '1002');
INSERT INTO sys_role_menu
VALUES ('2', '1003');
INSERT INTO sys_role_menu
VALUES ('2', '1004');
INSERT INTO sys_role_menu
VALUES ('2', '1005');
INSERT INTO sys_role_menu
VALUES ('2', '1006');
INSERT INTO sys_role_menu
VALUES ('2', '1007');
INSERT INTO sys_role_menu
VALUES ('2', '1008');
INSERT INTO sys_role_menu
VALUES ('2', '1009');
INSERT INTO sys_role_menu
VALUES ('2', '1010');
INSERT INTO sys_role_menu
VALUES ('2', '1011');
INSERT INTO sys_role_menu
VALUES ('2', '1012');
INSERT INTO sys_role_menu
VALUES ('2', '1013');
INSERT INTO sys_role_menu
VALUES ('2', '1014');
INSERT INTO sys_role_menu
VALUES ('2', '1015');
INSERT INTO sys_role_menu
VALUES ('2', '1016');
INSERT INTO sys_role_menu
VALUES ('2', '1017');
INSERT INTO sys_role_menu
VALUES ('2', '1018');
INSERT INTO sys_role_menu
VALUES ('2', '1019');
INSERT INTO sys_role_menu
VALUES ('2', '1020');
INSERT INTO sys_role_menu
VALUES ('2', '1021');
INSERT INTO sys_role_menu
VALUES ('2', '1022');
INSERT INTO sys_role_menu
VALUES ('2', '1023');
INSERT INTO sys_role_menu
VALUES ('2', '1024');
INSERT INTO sys_role_menu
VALUES ('2', '1025');
INSERT INTO sys_role_menu
VALUES ('2', '1026');
INSERT INTO sys_role_menu
VALUES ('2', '1027');
INSERT INTO sys_role_menu
VALUES ('2', '1028');
INSERT INTO sys_role_menu
VALUES ('2', '1029');
INSERT INTO sys_role_menu
VALUES ('2', '1030');
INSERT INTO sys_role_menu
VALUES ('2', '1031');
INSERT INTO sys_role_menu
VALUES ('2', '1032');
INSERT INTO sys_role_menu
VALUES ('2', '1033');
INSERT INTO sys_role_menu
VALUES ('2', '1034');
INSERT INTO sys_role_menu
VALUES ('2', '1035');
INSERT INTO sys_role_menu
VALUES ('2', '1036');
INSERT INTO sys_role_menu
VALUES ('2', '1037');
INSERT INTO sys_role_menu
VALUES ('2', '1038');
INSERT INTO sys_role_menu
VALUES ('2', '1039');
INSERT INTO sys_role_menu
VALUES ('2', '1040');
INSERT INTO sys_role_menu
VALUES ('2', '1041');
INSERT INTO sys_role_menu
VALUES ('2', '1042');
INSERT INTO sys_role_menu
VALUES ('2', '1043');
INSERT INTO sys_role_menu
VALUES ('2', '1044');
INSERT INTO sys_role_menu
VALUES ('2', '1045');
INSERT INTO sys_role_menu
VALUES ('2', '1046');
INSERT INTO sys_role_menu
VALUES ('2', '1047');
INSERT INTO sys_role_menu
VALUES ('2', '1048');
INSERT INTO sys_role_menu
VALUES ('2', '1049');
INSERT INTO sys_role_menu
VALUES ('2', '1050');
INSERT INTO sys_role_menu
VALUES ('2', '1051');
INSERT INTO sys_role_menu
VALUES ('2', '1052');
INSERT INTO sys_role_menu
VALUES ('2', '1053');
INSERT INTO sys_role_menu
VALUES ('2', '1054');
INSERT INTO sys_role_menu
VALUES ('2', '1055');
INSERT INTO sys_role_menu
VALUES ('2', '1056');
INSERT INTO sys_role_menu
VALUES ('2', '1057');
INSERT INTO sys_role_menu
VALUES ('2', '1058');
INSERT INTO sys_role_menu
VALUES ('2', '1059');
INSERT INTO sys_role_menu
VALUES ('2', '1060');

-- ----------------------------
-- 8、角色和部门关联表  角色1-N部门
-- ----------------------------
DROP TABLE IF EXISTS sys_role_dept;
CREATE TABLE sys_role_dept
(
    role_id BIGINT(20) NOT NULL COMMENT '角色ID',
    dept_id BIGINT(20) NOT NULL COMMENT '部门ID',
    PRIMARY KEY (role_id, dept_id)
) ENGINE = innodb COMMENT = '角色和部门关联表';

-- ----------------------------
-- 初始化-角色和部门关联表数据
-- ----------------------------
INSERT INTO sys_role_dept
VALUES ('2', '100');
INSERT INTO sys_role_dept
VALUES ('2', '101');
INSERT INTO sys_role_dept
VALUES ('2', '105');


-- ----------------------------
-- 9、用户与岗位关联表  用户1-N岗位
-- ----------------------------
DROP TABLE IF EXISTS sys_user_post;
CREATE TABLE sys_user_post
(
    user_id BIGINT(20) NOT NULL COMMENT '用户ID',
    post_id BIGINT(20) NOT NULL COMMENT '岗位ID',
    PRIMARY KEY (user_id, post_id)
) ENGINE = innodb COMMENT = '用户与岗位关联表';

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
INSERT INTO sys_user_post
VALUES ('1', '1');
INSERT INTO sys_user_post
VALUES ('2', '2');


-- ----------------------------
-- 10、操作日志记录
-- ----------------------------
DROP TABLE IF EXISTS sys_oper_log;
CREATE TABLE sys_oper_log
(
    oper_id        BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
    title          VARCHAR(50)   DEFAULT '' COMMENT '模块标题',
    business_type  INT(2)        DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
    method         VARCHAR(100)  DEFAULT '' COMMENT '方法名称',
    request_method VARCHAR(10)   DEFAULT '' COMMENT '请求方式',
    operator_type  INT(1)        DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
    oper_name      VARCHAR(50)   DEFAULT '' COMMENT '操作人员',
    dept_name      VARCHAR(50)   DEFAULT '' COMMENT '部门名称',
    oper_url       VARCHAR(255)  DEFAULT '' COMMENT '请求URL',
    oper_ip        VARCHAR(128)  DEFAULT '' COMMENT '主机地址',
    oper_location  VARCHAR(255)  DEFAULT '' COMMENT '操作地点',
    oper_param     VARCHAR(2000) DEFAULT '' COMMENT '请求参数',
    json_result    VARCHAR(2000) DEFAULT '' COMMENT '返回参数',
    status         INT(1)        DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
    error_msg      VARCHAR(2000) DEFAULT '' COMMENT '错误消息',
    oper_time      DATETIME COMMENT '操作时间',
    cost_time      BIGINT(20)    DEFAULT 0 COMMENT '消耗时间',
    PRIMARY KEY (oper_id),
    KEY idx_sys_oper_log_bt (business_type),
    KEY idx_sys_oper_log_s (status),
    KEY idx_sys_oper_log_ot (oper_time)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '操作日志记录';


-- ----------------------------
-- 11、字典类型表
-- ----------------------------
DROP TABLE IF EXISTS sys_dict_type;
CREATE TABLE sys_dict_type
(
    dict_id     BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
    dict_name   VARCHAR(100) DEFAULT '' COMMENT '字典名称',
    dict_type   VARCHAR(100) DEFAULT '' COMMENT '字典类型',
    status      CHAR(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by   VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (dict_id),
    UNIQUE (dict_type)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '字典类型表';

INSERT INTO sys_dict_type
VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', SYSDATE(), '', NULL, '用户性别列表');
INSERT INTO sys_dict_type
VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', SYSDATE(), '', NULL, '菜单状态列表');
INSERT INTO sys_dict_type
VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', SYSDATE(), '', NULL, '系统开关列表');
INSERT INTO sys_dict_type
VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', SYSDATE(), '', NULL, '任务状态列表');
INSERT INTO sys_dict_type
VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', SYSDATE(), '', NULL, '任务分组列表');
INSERT INTO sys_dict_type
VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', SYSDATE(), '', NULL, '系统是否列表');
INSERT INTO sys_dict_type
VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', SYSDATE(), '', NULL, '通知类型列表');
INSERT INTO sys_dict_type
VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', SYSDATE(), '', NULL, '通知状态列表');
INSERT INTO sys_dict_type
VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', SYSDATE(), '', NULL, '操作类型列表');
INSERT INTO sys_dict_type
VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', SYSDATE(), '', NULL, '登录状态列表');


-- ----------------------------
-- 12、字典数据表
-- ----------------------------
DROP TABLE IF EXISTS sys_dict_data;
CREATE TABLE sys_dict_data
(
    dict_code   BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
    dict_sort   INT(4)       DEFAULT 0 COMMENT '字典排序',
    dict_label  VARCHAR(100) DEFAULT '' COMMENT '字典标签',
    dict_value  VARCHAR(100) DEFAULT '' COMMENT '字典键值',
    dict_type   VARCHAR(100) DEFAULT '' COMMENT '字典类型',
    css_class   VARCHAR(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
    list_class  VARCHAR(100) DEFAULT NULL COMMENT '表格回显样式',
    is_default  CHAR(1)      DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
    status      CHAR(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by   VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (dict_code)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '字典数据表';

INSERT INTO sys_dict_data
VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', SYSDATE(), '', NULL, '性别男');
INSERT INTO sys_dict_data
VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', SYSDATE(), '', NULL, '性别女');
INSERT INTO sys_dict_data
VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', SYSDATE(), '', NULL, '性别未知');
INSERT INTO sys_dict_data
VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', SYSDATE(), '', NULL, '显示菜单');
INSERT INTO sys_dict_data
VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '隐藏菜单');
INSERT INTO sys_dict_data
VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', SYSDATE(), '', NULL, '正常状态');
INSERT INTO sys_dict_data
VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '停用状态');
INSERT INTO sys_dict_data
VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', SYSDATE(), '', NULL, '正常状态');
INSERT INTO sys_dict_data
VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '停用状态');
INSERT INTO sys_dict_data
VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', SYSDATE(), '', NULL, '默认分组');
INSERT INTO sys_dict_data
VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', SYSDATE(), '', NULL, '系统分组');
INSERT INTO sys_dict_data
VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', SYSDATE(), '', NULL, '系统默认是');
INSERT INTO sys_dict_data
VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '系统默认否');
INSERT INTO sys_dict_data
VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', SYSDATE(), '', NULL, '通知');
INSERT INTO sys_dict_data
VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', SYSDATE(), '', NULL, '公告');
INSERT INTO sys_dict_data
VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', SYSDATE(), '', NULL, '正常状态');
INSERT INTO sys_dict_data
VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '关闭状态');
INSERT INTO sys_dict_data
VALUES (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', SYSDATE(), '', NULL, '其他操作');
INSERT INTO sys_dict_data
VALUES (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', SYSDATE(), '', NULL, '新增操作');
INSERT INTO sys_dict_data
VALUES (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', SYSDATE(), '', NULL, '修改操作');
INSERT INTO sys_dict_data
VALUES (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '删除操作');
INSERT INTO sys_dict_data
VALUES (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', SYSDATE(), '', NULL, '授权操作');
INSERT INTO sys_dict_data
VALUES (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', SYSDATE(), '', NULL, '导出操作');
INSERT INTO sys_dict_data
VALUES (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', SYSDATE(), '', NULL, '导入操作');
INSERT INTO sys_dict_data
VALUES (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '强退操作');
INSERT INTO sys_dict_data
VALUES (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', SYSDATE(), '', NULL, '生成操作');
INSERT INTO sys_dict_data
VALUES (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '清空操作');
INSERT INTO sys_dict_data
VALUES (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', SYSDATE(), '', NULL, '正常状态');
INSERT INTO sys_dict_data
VALUES (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '停用状态');


-- ----------------------------
-- 13、参数配置表
-- ----------------------------
DROP TABLE IF EXISTS sys_config;
CREATE TABLE sys_config
(
    config_id    INT(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
    config_name  VARCHAR(100) DEFAULT '' COMMENT '参数名称',
    config_key   VARCHAR(100) DEFAULT '' COMMENT '参数键名',
    config_value VARCHAR(500) DEFAULT '' COMMENT '参数键值',
    config_type  CHAR(1)      DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
    create_by    VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time  DATETIME COMMENT '创建时间',
    update_by    VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time  DATETIME COMMENT '更新时间',
    remark       VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (config_id)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '参数配置表';

INSERT INTO sys_config
VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', SYSDATE(), '', NULL,
        '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO sys_config
VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', SYSDATE(), '', NULL,
        '初始化密码 123456');
INSERT INTO sys_config
VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', SYSDATE(), '', NULL,
        '深色主题theme-dark，浅色主题theme-light');
INSERT INTO sys_config
VALUES (4, '账号自助-验证码开关', 'sys.account.captchaEnabled', 'true', 'Y', 'admin', SYSDATE(), '', NULL,
        '是否开启验证码功能（true开启，false关闭）');
INSERT INTO sys_config
VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', SYSDATE(), '', NULL,
        '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO sys_config
VALUES (6, '用户登录-黑名单列表', 'sys.login.blackIPList', '', 'Y', 'admin', SYSDATE(), '', NULL,
        '设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');


-- ----------------------------
-- 14、系统访问记录
-- ----------------------------
DROP TABLE IF EXISTS sys_logininfor;
CREATE TABLE sys_logininfor
(
    info_id        BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    user_name      VARCHAR(50)  DEFAULT '' COMMENT '用户账号',
    ipaddr         VARCHAR(128) DEFAULT '' COMMENT '登录IP地址',
    login_location VARCHAR(255) DEFAULT '' COMMENT '登录地点',
    browser        VARCHAR(50)  DEFAULT '' COMMENT '浏览器类型',
    os             VARCHAR(50)  DEFAULT '' COMMENT '操作系统',
    status         CHAR(1)      DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    msg            VARCHAR(255) DEFAULT '' COMMENT '提示消息',
    login_time     DATETIME COMMENT '访问时间',
    PRIMARY KEY (info_id),
    KEY idx_sys_logininfor_s (status),
    KEY idx_sys_logininfor_lt (login_time)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '系统访问记录';


-- ----------------------------
-- 15、定时任务调度表
-- ----------------------------
DROP TABLE IF EXISTS sys_job;
CREATE TABLE sys_job
(
    job_id          BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '任务ID',
    job_name        VARCHAR(64)  DEFAULT '' COMMENT '任务名称',
    job_group       VARCHAR(64)  DEFAULT 'DEFAULT' COMMENT '任务组名',
    invoke_target   VARCHAR(500) NOT NULL COMMENT '调用目标字符串',
    cron_expression VARCHAR(255) DEFAULT '' COMMENT 'cron执行表达式',
    misfire_policy  VARCHAR(20)  DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
    concurrent      CHAR(1)      DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
    status          CHAR(1)      DEFAULT '0' COMMENT '状态（0正常 1暂停）',
    create_by       VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time     DATETIME COMMENT '创建时间',
    update_by       VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time     DATETIME COMMENT '更新时间',
    remark          VARCHAR(500) DEFAULT '' COMMENT '备注信息',
    PRIMARY KEY (job_id, job_name, job_group)
) ENGINE = innodb
  AUTO_INCREMENT = 100 COMMENT = '定时任务调度表';

INSERT INTO sys_job
VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', SYSDATE(), '',
        NULL, '');
INSERT INTO sys_job
VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', SYSDATE(),
        '', NULL, '');
INSERT INTO sys_job
VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?',
        '3', '1', '1', 'admin', SYSDATE(), '', NULL, '');


-- ----------------------------
-- 16、定时任务调度日志表
-- ----------------------------
DROP TABLE IF EXISTS sys_job_log;
CREATE TABLE sys_job_log
(
    job_log_id     BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
    job_name       VARCHAR(64)  NOT NULL COMMENT '任务名称',
    job_group      VARCHAR(64)  NOT NULL COMMENT '任务组名',
    invoke_target  VARCHAR(500) NOT NULL COMMENT '调用目标字符串',
    job_message    VARCHAR(500) COMMENT '日志信息',
    status         CHAR(1)       DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
    exception_info VARCHAR(2000) DEFAULT '' COMMENT '异常信息',
    create_time    DATETIME COMMENT '创建时间',
    PRIMARY KEY (job_log_id)
) ENGINE = innodb COMMENT = '定时任务调度日志表';


-- ----------------------------
-- 17、通知公告表
-- ----------------------------
DROP TABLE IF EXISTS sys_notice;
CREATE TABLE sys_notice
(
    notice_id      INT(4)      NOT NULL AUTO_INCREMENT COMMENT '公告ID',
    notice_title   VARCHAR(50) NOT NULL COMMENT '公告标题',
    notice_type    CHAR(1)     NOT NULL COMMENT '公告类型（1通知 2公告）',
    notice_content LONGBLOB     DEFAULT NULL COMMENT '公告内容',
    status         CHAR(1)      DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
    create_by      VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time    DATETIME COMMENT '创建时间',
    update_by      VARCHAR(64)  DEFAULT '' COMMENT '更新者',
    update_time    DATETIME COMMENT '更新时间',
    remark         VARCHAR(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (notice_id)
) ENGINE = innodb
  AUTO_INCREMENT = 10 COMMENT = '通知公告表';

-- ----------------------------
-- 初始化-公告信息表数据
-- ----------------------------
INSERT INTO sys_notice
VALUES ('1', '温馨提醒：2024-02-01 数据库出生啦', '2', '新版本内容', '0', 'admin', SYSDATE(), '', NULL, '管理员');
INSERT INTO sys_notice
VALUES ('2', '维护通知：2024-02-02 项目名称初定为IntelligentCal', '1', '维护内容', '0', 'admin', SYSDATE(), '', NULL,
        '管理员');

-- ----------------------------
-- 18、代码生成业务表
-- ----------------------------
drop table if exists gen_table;
create table gen_table (
  table_id          bigint(20)      not null auto_increment    comment '编号',
  table_name        varchar(200)    default ''                 comment '表名称',
  table_comment     varchar(500)    default ''                 comment '表描述',
  sub_table_name    varchar(64)     default null               comment '关联子表的表名',
  sub_table_fk_name varchar(64)     default null               comment '子表关联的外键名',
  class_name        varchar(100)    default ''                 comment '实体类名称',
  tpl_category      varchar(200)    default 'crud'             comment '使用的模板（crud单表操作 tree树表操作）',
  tpl_web_type      varchar(30)     default ''                 comment '前端模板类型（element-ui模版 element-plus模版）',
  package_name      varchar(100)                               comment '生成包路径',
  module_name       varchar(30)                                comment '生成模块名',
  business_name     varchar(30)                                comment '生成业务名',
  function_name     varchar(50)                                comment '生成功能名',
  function_author   varchar(50)                                comment '生成功能作者',
  gen_type          char(1)         default '0'                comment '生成代码方式（0zip压缩包 1自定义路径）',
  gen_path          varchar(200)    default '/'                comment '生成路径（不填默认项目路径）',
  options           varchar(1000)                              comment '其它生成选项',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (table_id)
) engine=innodb auto_increment=1 comment = '代码生成业务表';


-- ----------------------------
-- 19、代码生成业务表字段
-- ----------------------------
drop table if exists gen_table_column;
create table gen_table_column (
  column_id         bigint(20)      not null auto_increment    comment '编号',
  table_id          bigint(20)                                 comment '归属表编号',
  column_name       varchar(200)                               comment '列名称',
  column_comment    varchar(500)                               comment '列描述',
  column_type       varchar(100)                               comment '列类型',
  java_type         varchar(500)                               comment 'JAVA类型',
  java_field        varchar(200)                               comment 'JAVA字段名',
  is_pk             char(1)                                    comment '是否主键（1是）',
  is_increment      char(1)                                    comment '是否自增（1是）',
  is_required       char(1)                                    comment '是否必填（1是）',
  is_insert         char(1)                                    comment '是否为插入字段（1是）',
  is_edit           char(1)                                    comment '是否编辑字段（1是）',
  is_list           char(1)                                    comment '是否列表字段（1是）',
  is_query          char(1)                                    comment '是否查询字段（1是）',
  query_type        varchar(200)    default 'EQ'               comment '查询方式（等于、不等于、大于、小于、范围）',
  html_type         varchar(200)                               comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  dict_type         varchar(200)    default ''                 comment '字典类型',
  sort              int                                        comment '排序',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (column_id)
) engine=innodb auto_increment=1 comment = '代码生成业务表字段';
