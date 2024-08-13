package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    /**
     * 计划id
     */
    private Integer id;
    /**
     * 计划名称
     */
    private String planName;
    /**
     * 统筹区域
     */
    private Integer planArea;
    /**
     * 测算起始年份
     */
    private Integer startYear;
    /**
     * 测算结束年份
     */
    private Integer endYear;
    /**
     * 测算状态
     */
    private Integer executeStatus;
    /**
     * 测算时间
     */
    private LocalDateTime executeTime;
    /**
     * 计划版本
     */
    private String planVersion;
    /**
     * 上一年养老保险累计结余
     */
    private BigDecimal lastYearSumSurplus;
    /**
     * 退休人员类型
     */
    private List<Integer> retirePersonTypes;
    /**
     * 生育模式
     */
    private Integer birthMode;
    /**
     * 计划描述
     */
    private String planDescription;
    /**
     * 计划优先级
     */
    private Integer planPriority;
    /**
     * 以年龄为索引的数据
     */
    private List<PlanAge> planAge;
    /**
     * 以地区为索引的数据
     */
    private List<PlanUrban> planUrban;
    /**
     * 以年份为索引的数据
     */
    private List<PlanYear> planYear;
    /**
     * 计划插入人id
     */
    private Integer insertUserId;
}
