package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算方案参数描述表对象 y_yctxcs_index_description
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class YYctxcsIndexDescription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 退休年龄描述 */
    @Excel(name = "退休年龄描述")
    private String retireDescription;

    /** 参保率描述 */
    @Excel(name = "参保率描述")
    private String insureDescription;

    /** 个人缴费率描述 */
    @Excel(name = "个人缴费率描述")
    private String individualRateDescription;

    /** 企业缴费率描述 */
    @Excel(name = "企业缴费率描述")
    private String enterpriseRateDescription;

    /** 收缴率描述 */
    @Excel(name = "收缴率描述")
    private String collectRateDescription;

    /** 在岗平均工资描述 */
    @Excel(name = "在岗平均工资描述")
    private String avgSalaryDescription;

    /** 个人账户记账利率描述 */
    @Excel(name = "个人账户记账利率描述")
    private String accountRateDescription;

    /** 过渡系数描述 */
    @Excel(name = "过渡系数描述")
    private String transitionDescription;

    /** 养老金增长率描述 */
    @Excel(name = "养老金增长率描述")
    private String growthDescription;

    /** 城镇化率描述 */
    @Excel(name = "城镇化率描述")
    private String urbanizationDescription;

    /** 就业率描述 */
    @Excel(name = "就业率描述")
    private String employmentRateDescription;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRetireDescription(String retireDescription) 
    {
        this.retireDescription = retireDescription;
    }

    public String getRetireDescription() 
    {
        return retireDescription;
    }
    public void setInsureDescription(String insureDescription) 
    {
        this.insureDescription = insureDescription;
    }

    public String getInsureDescription() 
    {
        return insureDescription;
    }
    public void setIndividualRateDescription(String individualRateDescription) 
    {
        this.individualRateDescription = individualRateDescription;
    }

    public String getIndividualRateDescription() 
    {
        return individualRateDescription;
    }
    public void setEnterpriseRateDescription(String enterpriseRateDescription) 
    {
        this.enterpriseRateDescription = enterpriseRateDescription;
    }

    public String getEnterpriseRateDescription() 
    {
        return enterpriseRateDescription;
    }
    public void setCollectRateDescription(String collectRateDescription) 
    {
        this.collectRateDescription = collectRateDescription;
    }

    public String getCollectRateDescription() 
    {
        return collectRateDescription;
    }
    public void setAvgSalaryDescription(String avgSalaryDescription) 
    {
        this.avgSalaryDescription = avgSalaryDescription;
    }

    public String getAvgSalaryDescription() 
    {
        return avgSalaryDescription;
    }
    public void setAccountRateDescription(String accountRateDescription) 
    {
        this.accountRateDescription = accountRateDescription;
    }

    public String getAccountRateDescription() 
    {
        return accountRateDescription;
    }
    public void setTransitionDescription(String transitionDescription) 
    {
        this.transitionDescription = transitionDescription;
    }

    public String getTransitionDescription() 
    {
        return transitionDescription;
    }
    public void setGrowthDescription(String growthDescription) 
    {
        this.growthDescription = growthDescription;
    }

    public String getGrowthDescription() 
    {
        return growthDescription;
    }
    public void setUrbanizationDescription(String urbanizationDescription) 
    {
        this.urbanizationDescription = urbanizationDescription;
    }

    public String getUrbanizationDescription() 
    {
        return urbanizationDescription;
    }
    public void setEmploymentRateDescription(String employmentRateDescription) 
    {
        this.employmentRateDescription = employmentRateDescription;
    }

    public String getEmploymentRateDescription() 
    {
        return employmentRateDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("retireDescription", getRetireDescription())
            .append("insureDescription", getInsureDescription())
            .append("individualRateDescription", getIndividualRateDescription())
            .append("enterpriseRateDescription", getEnterpriseRateDescription())
            .append("collectRateDescription", getCollectRateDescription())
            .append("avgSalaryDescription", getAvgSalaryDescription())
            .append("accountRateDescription", getAccountRateDescription())
            .append("transitionDescription", getTransitionDescription())
            .append("growthDescription", getGrowthDescription())
            .append("urbanizationDescription", getUrbanizationDescription())
            .append("employmentRateDescription", getEmploymentRateDescription())
            .toString();
    }
}
