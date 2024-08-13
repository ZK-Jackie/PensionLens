package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算方案参数表（按年）对象 t_yctxcs_plan_index_year
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPlanIndexYear extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 方案id */
    @Excel(name = "方案id")
    private Long planId;

    /** 男职工退休年龄 */
    @Excel(name = "男职工退休年龄")
    private BigDecimal mRetire;

    /** 女职工退休年龄 */
    @Excel(name = "女职工退休年龄")
    private BigDecimal fRetire;

    /** 女干部退休年龄 */
    @Excel(name = "女干部退休年龄")
    private BigDecimal fcRetire;

    /** 参保率 */
    @Excel(name = "参保率")
    private BigDecimal insuranceRate;

    /** 个人缴费率 */
    @Excel(name = "个人缴费率")
    private BigDecimal individualRate;

    /** 企业缴费率 */
    @Excel(name = "企业缴费率")
    private BigDecimal enterpriseRate;

    /** 收缴率 */
    @Excel(name = "收缴率")
    private BigDecimal collectRate;

    /** 在岗平均工资 */
    @Excel(name = "在岗平均工资")
    private BigDecimal avgSalary;

    /** 个人账户记账利率 */
    @Excel(name = "个人账户记账利率")
    private BigDecimal accountRate;

    /** 过渡系数 */
    @Excel(name = "过渡系数")
    private BigDecimal transition;

    /** 养老金增长率 */
    @Excel(name = "养老金增长率")
    private BigDecimal growth;

    /** 是否删除，N-否，Y-是 */
    @Excel(name = "是否删除，N-否，Y-是")
    private String isDeleted;

    /** 插入人id */
    @Excel(name = "插入人id")
    private Long insertUserId;

    /** 插入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "插入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date insertTime;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    /** 删除人id */
    @Excel(name = "删除人id")
    private Long deleteUserId;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
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
    public void setInsuranceRate(BigDecimal insuranceRate) 
    {
        this.insuranceRate = insuranceRate;
    }

    public BigDecimal getInsuranceRate() 
    {
        return insuranceRate;
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
    public void setCollectRate(BigDecimal collectRate) 
    {
        this.collectRate = collectRate;
    }

    public BigDecimal getCollectRate() 
    {
        return collectRate;
    }
    public void setAvgSalary(BigDecimal avgSalary) 
    {
        this.avgSalary = avgSalary;
    }

    public BigDecimal getAvgSalary() 
    {
        return avgSalary;
    }
    public void setAccountRate(BigDecimal accountRate) 
    {
        this.accountRate = accountRate;
    }

    public BigDecimal getAccountRate() 
    {
        return accountRate;
    }
    public void setTransition(BigDecimal transition) 
    {
        this.transition = transition;
    }

    public BigDecimal getTransition() 
    {
        return transition;
    }
    public void setGrowth(BigDecimal growth) 
    {
        this.growth = growth;
    }

    public BigDecimal getGrowth() 
    {
        return growth;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }
    public void setInsertUserId(Long insertUserId) 
    {
        this.insertUserId = insertUserId;
    }

    public Long getInsertUserId() 
    {
        return insertUserId;
    }
    public void setInsertTime(Date insertTime) 
    {
        this.insertTime = insertTime;
    }

    public Date getInsertTime() 
    {
        return insertTime;
    }
    public void setLastUpdateUserId(Long lastUpdateUserId) 
    {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Long getLastUpdateUserId() 
    {
        return lastUpdateUserId;
    }
    public void setLastUpdateTime(Date lastUpdateTime) 
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateTime() 
    {
        return lastUpdateTime;
    }
    public void setDeleteUserId(Long deleteUserId) 
    {
        this.deleteUserId = deleteUserId;
    }

    public Long getDeleteUserId() 
    {
        return deleteUserId;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("planId", getPlanId())
            .append("mRetire", getmRetire())
            .append("fRetire", getfRetire())
            .append("fcRetire", getFcRetire())
            .append("insuranceRate", getInsuranceRate())
            .append("individualRate", getIndividualRate())
            .append("enterpriseRate", getEnterpriseRate())
            .append("collectRate", getCollectRate())
            .append("avgSalary", getAvgSalary())
            .append("accountRate", getAccountRate())
            .append("transition", getTransition())
            .append("growth", getGrowth())
            .append("isDeleted", getIsDeleted())
            .append("insertUserId", getInsertUserId())
            .append("insertTime", getInsertTime())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .append("deleteUserId", getDeleteUserId())
            .append("deleteTime", getDeleteTime())
            .toString();
    }
}
