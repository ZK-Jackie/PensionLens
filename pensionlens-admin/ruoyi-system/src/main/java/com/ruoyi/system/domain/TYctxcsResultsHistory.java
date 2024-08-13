package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 结果预测历史表对象 t_yctxcs_results_history
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsResultsHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 方案历史id */
    @Excel(name = "方案历史id")
    private Long planHistoryId;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 养老金支出 */
    @Excel(name = "养老金支出")
    private BigDecimal expense;

    /** 养老金征缴收入 */
    @Excel(name = "养老金征缴收入")
    private BigDecimal income;

    /** 养老金累计结余 */
    @Excel(name = "养老金累计结余")
    private BigDecimal surplus;

    /** 上一年度养老金累计结余 */
    @Excel(name = "上一年度养老金累计结余")
    private BigDecimal lastYearSumSurplus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlanHistoryId(Long planHistoryId) 
    {
        this.planHistoryId = planHistoryId;
    }

    public Long getPlanHistoryId() 
    {
        return planHistoryId;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setExpense(BigDecimal expense) 
    {
        this.expense = expense;
    }

    public BigDecimal getExpense() 
    {
        return expense;
    }
    public void setIncome(BigDecimal income) 
    {
        this.income = income;
    }

    public BigDecimal getIncome() 
    {
        return income;
    }
    public void setSurplus(BigDecimal surplus) 
    {
        this.surplus = surplus;
    }

    public BigDecimal getSurplus() 
    {
        return surplus;
    }
    public void setLastYearSumSurplus(BigDecimal lastYearSumSurplus) 
    {
        this.lastYearSumSurplus = lastYearSumSurplus;
    }

    public BigDecimal getLastYearSumSurplus() 
    {
        return lastYearSumSurplus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planHistoryId", getPlanHistoryId())
            .append("year", getYear())
            .append("expense", getExpense())
            .append("income", getIncome())
            .append("surplus", getSurplus())
            .append("lastYearSumSurplus", getLastYearSumSurplus())
            .toString();
    }
}
