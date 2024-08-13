USE calc;

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
    min_data_unit       VARCHAR(20) NOT NULL COMMENT '最小数据量单位',
    is_multi_option     VARCHAR(1)  NOT NULL DEFAULT 'N' COMMENT '是否含有多选按钮，N-否，Y-是',
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
    detail_id           BIGINT(20)   NOT NULL COMMENT '图表配置id',
    data_id             BIGINT(20)   NOT NULL COMMENT '图表数据id',
    data_name           VARCHAR(100) NOT NULL COMMENT '数据名称数组，需要序列化和反序列化',
    display_mode        VARCHAR(20)  NOT NULL COMMENT '图表类型，参照CHART_TYPE字典',
    displayable_mode    VARCHAR(20)  NOT NULL COMMENT '图表可展现的形式，参照CHART_TYPE字典',
    start_time          DATETIME     NOT NULL COMMENT '数据开始时间',
    end_time            DATETIME     NOT NULL COMMENT '数据结束时间',
    is_info             VARCHAR(1)   NOT NULL COMMENT '是否是资讯类数据，N-否，Y-是',
    is_predict          VARCHAR(1)   NOT NULL COMMENT '是否是预测数据，N-否，Y-是',
    predict_start_time  DATETIME     NOT NULL COMMENT '预测数据开始时间',
    predict_end_time    DATETIME     NOT NULL COMMENT '预测数据结束时间',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
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
    data_location       VARCHAR(100)   NOT NULL COMMENT '数据所在表',/*这个字段要隐藏，随后变成data数组和predictData数组*/
    displayable_mode    VARCHAR(100)   NOT NULL COMMENT '数据可展现的形式数组，对照CHART_TYPE字典，需要序列化和反序列化',
    key_label           VARCHAR(20)    NOT NULL COMMENT '数据键的标签名',
    key_unit            VARCHAR(20)    NOT NULL COMMENT '数据键的单位',
    value_label         VARCHAR(20)    NOT NULL COMMENT '数据值的标签名',
    value_unit          VARCHAR(20)    NOT NULL COMMENT '数据值的单位',
    num_precision       DECIMAL(6, 5)  NOT NULL COMMENT '数据呈现精度',
    max_value           DECIMAL(20, 4) NOT NULL COMMENT '数据值最大值',
    min_value           DECIMAL(20, 4) NOT NULL COMMENT '数据值最小值',
    data_color_id       BIGINT(20)     NOT NULL COMMENT '数据颜色id',
    is_predict          VARCHAR(1)     NOT NULL COMMENT '是否是预测的数据，N-否，Y-是',
    is_info             VARCHAR(1)     NOT NULL COMMENT '是否是资讯类数据，N-否，Y-是',
    is_default          VARCHAR(1)     NOT NULL COMMENT '是否是默认数据，N-否，Y-是',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (data_id)
);

DROP TABLE IF EXISTS screen_data_color;
CREATE TABLE screen_data_color
(
    data_color_id       BIGINT(20) NOT NULL COMMENT '数据颜色id',
    data_id             BIGINT(20) NOT NULL COMMENT '数据id',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (data_color_id, data_id)
);

DROP TABLE IF EXISTS screen_color;
CREATE TABLE screen_color
(
    data_color_id   BIGINT(20)  NOT NULL COMMENT '数据颜色id',
    data_color_name VARCHAR(20) NOT NULL COMMENT '数据颜色名称',
    data_color      VARCHAR(20) NOT NULL COMMENT '数据颜色列表，需要序列化和反序列化',
    last_update_user_id BIGINT(20) COMMENT '最后更新人id',
    last_update_time    DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间'
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
