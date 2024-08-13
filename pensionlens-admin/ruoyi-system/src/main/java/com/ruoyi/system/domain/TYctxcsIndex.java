package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 延迟退休测算方案默认参数表对象 t_yctxcs_index
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsIndex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 年份 */
    private Long year;

    /** 男职工退休年龄 */
    @Excel(name = "男职工退休年龄")
    private BigDecimal mRetire;

    /** 女职工退休年龄 */
    @Excel(name = "女职工退休年龄")
    private BigDecimal fRetire;

    /** 女干部退休年龄 */
    @Excel(name = "女干部退休年龄")
    private BigDecimal fcRetire;

    /** 在岗平均工资 */
    @Excel(name = "在岗平均工资")
    private BigDecimal avgSalary;

    /** 个人缴费率 */
    @Excel(name = "个人缴费率")
    private BigDecimal individualRate;

    /** 企业缴费率 */
    @Excel(name = "企业缴费率")
    private BigDecimal enterpriseRate;

    /** 参保率 */
    @Excel(name = "参保率")
    private BigDecimal insuranceRate;

    /** 养老金增长率 */
    @Excel(name = "养老金增长率")
    private BigDecimal growth;

    /** 收缴率 */
    @Excel(name = "收缴率")
    private BigDecimal collectRate;

    /** 过渡系数 */
    @Excel(name = "过渡系数")
    private BigDecimal transition;

    /** 个人账户记账利率 */
    @Excel(name = "个人账户记账利率")
    private BigDecimal accountRate;

    /** 男职工计发月数 */
    @Excel(name = "男职工计发月数")
    private Long mMonthly;

    /** 女职工计发月数 */
    @Excel(name = "女职工计发月数")
    private Long fMonthly;

    /** 女干部计发月数 */
    @Excel(name = "女干部计发月数")
    private Long fcMonthly;

    public void setPlanArea(Long planArea) 
    {
        this.planArea = planArea;
    }

    public Long getPlanArea() 
    {
        return planArea;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setmRetire(BigDecimal mRetire) 
    {
        this.mRetire = mRetire;
    }

    public BigDecimal getmRetire() 
    {
        return mRetire;
    }
    public void setfRetire(BigDecimal fRetire) 
    {
        this.fRetire = fRetire;
    }

    public BigDecimal getfRetire() 
    {
        return fRetire;
    }
    public void setFcRetire(BigDecimal fcRetire) 
    {
        this.fcRetire = fcRetire;
    }

    public BigDecimal getFcRetire() 
    {
        return fcRetire;
    }
    public void setAvgSalary(BigDecimal avgSalary) 
    {
        this.avgSalary = avgSalary;
    }

    public BigDecimal getAvgSalary() 
    {
        return avgSalary;
    }
    public void setIndividualRate(BigDecimal individualRate) 
    {
        this.individualRate = individualRate;
    }

    public BigDecimal getIndividualRate() 
    {
        return individualRate;
    }
    public void setEnterpriseRate(BigDecimal enterpriseRate) 
    {
        this.enterpriseRate = enterpriseRate;
    }

    public BigDecimal getEnterpriseRate() 
    {
        return enterpriseRate;
    }
    public void setInsuranceRate(BigDecimal insuranceRate) 
    {
        this.insuranceRate = insuranceRate;
    }

    public BigDecimal getInsuranceRate() 
    {
        return insuranceRate;
    }
    public void setGrowth(BigDecimal growth) 
    {
        this.growth = growth;
    }

    public BigDecimal getGrowth() 
    {
        return growth;
    }
    public void setCollectRate(BigDecimal collectRate) 
    {
        this.collectRate = collectRate;
    }

    public BigDecimal getCollectRate() 
    {
        return collectRate;
    }
    public void setTransition(BigDecimal transition) 
    {
        this.transition = transition;
    }

    public BigDecimal getTransition() 
    {
        return transition;
    }
    public void setAccountRate(BigDecimal accountRate) 
    {
        this.accountRate = accountRate;
    }

    public BigDecimal getAccountRate() 
    {
        return accountRate;
    }
    public void setmMonthly(Long mMonthly) 
    {
        this.mMonthly = mMonthly;
    }

    public Long getmMonthly() 
    {
        return mMonthly;
    }
    public void setfMonthly(Long fMonthly) 
    {
        this.fMonthly = fMonthly;
    }

    public Long getfMonthly() 
    {
        return fMonthly;
    }
    public void setFcMonthly(Long fcMonthly) 
    {
        this.fcMonthly = fcMonthly;
    }

    public Long getFcMonthly() 
    {
        return fcMonthly;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("year", getYear())
            .append("mRetire", getmRetire())
            .append("fRetire", getfRetire())
            .append("fcRetire", getFcRetire())
            .append("avgSalary", getAvgSalary())
            .append("individualRate", getIndividualRate())
            .append("enterpriseRate", getEnterpriseRate())
            .append("insuranceRate", getInsuranceRate())
            .append("growth", getGrowth())
            .append("collectRate", getCollectRate())
            .append("transition", getTransition())
            .append("accountRate", getAccountRate())
            .append("mMonthly", getmMonthly())
            .append("fMonthly", getfMonthly())
            .append("fcMonthly", getFcMonthly())
            .toString();
    }
}
