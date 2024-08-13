package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算城镇化率历史表对象 t_yctxcs_plan_index_urban_his
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPlanIndexUrbanHis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 方案历史id */
    @Excel(name = "方案历史id")
    private Long planHistoryId;

    /** 城镇化率 */
    @Excel(name = "城镇化率")
    private BigDecimal urbanRate;

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
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setPlanHistoryId(Long planHistoryId) 
    {
        this.planHistoryId = planHistoryId;
    }

    public Long getPlanHistoryId() 
    {
        return planHistoryId;
    }
    public void setUrbanRate(BigDecimal urbanRate) 
    {
        this.urbanRate = urbanRate;
    }

    public BigDecimal getUrbanRate() 
    {
        return urbanRate;
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
            .append("age", getAge())
            .append("planHistoryId", getPlanHistoryId())
            .append("urbanRate", getUrbanRate())
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
