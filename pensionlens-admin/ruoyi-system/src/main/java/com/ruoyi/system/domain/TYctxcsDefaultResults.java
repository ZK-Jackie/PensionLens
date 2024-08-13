package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算结果默认表对象 t_yctxcs_default_results
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsDefaultResults extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 生育模式，对应BIRTH_MODE字典 */
    private String birthMode;

    /** 年份 */
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

    public void setPlanArea(Long planArea) 
    {
        this.planArea = planArea;
    }

    public Long getPlanArea() 
    {
        return planArea;
    }
    public void setBirthMode(String birthMode) 
    {
        this.birthMode = birthMode;
    }

    public String getBirthMode() 
    {
        return birthMode;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("birthMode", getBirthMode())
            .append("year", getYear())
            .append("expense", getExpense())
            .append("income", getIncome())
            .append("surplus", getSurplus())
            .toString();
    }
}
