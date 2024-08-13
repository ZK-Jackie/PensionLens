package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算方案参数表（按年龄）对象 t_yctxcs_plan_index_age
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPlanIndexAge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 方案id */
    @Excel(name = "方案id")
    private Long planId;

    /** 男性就业率 */
    @Excel(name = "男性就业率")
    private BigDecimal mEmploymentRate;

    /** 女性就业率 */
    @Excel(name = "女性就业率")
    private BigDecimal fEmploymentRate;

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
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setmEmploymentRate(BigDecimal mEmploymentRate) 
    {
        this.mEmploymentRate = mEmploymentRate;
    }

    public BigDecimal getmEmploymentRate() 
    {
        return mEmploymentRate;
    }
    public void setfEmploymentRate(BigDecimal fEmploymentRate) 
    {
        this.fEmploymentRate = fEmploymentRate;
    }

    public BigDecimal getfEmploymentRate() 
    {
        return fEmploymentRate;
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
            .append("age", getAge())
            .append("planId", getPlanId())
            .append("mEmploymentRate", getmEmploymentRate())
            .append("fEmploymentRate", getfEmploymentRate())
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
