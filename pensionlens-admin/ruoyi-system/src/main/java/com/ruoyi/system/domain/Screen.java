package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏表对象 screen
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public class Screen extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long screenId;

    /** 大屏名称 */
    @Excel(name = "大屏名称")
    private String screenName;

    /** 是否是预测大屏，N-否，Y-是 */
    @Excel(name = "是否是预测大屏，N-否，Y-是")
    private String isPredict;

    /** 是否启用，N-否，Y-是 */
    @Excel(name = "是否启用，N-否，Y-是")
    private String isActive;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 是否删除，N-否，Y-是 */
    @Excel(name = "是否删除，N-否，Y-是")
    private String isDeleted;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    /** 删除人id */
    @Excel(name = "删除人id")
    private Long deleteUserId;

    public void setScreenId(Long screenId) 
    {
        this.screenId = screenId;
    }

    public Long getScreenId() 
    {
        return screenId;
    }
    public void setScreenName(String screenName) 
    {
        this.screenName = screenName;
    }

    public String getScreenName() 
    {
        return screenName;
    }
    public void setIsPredict(String isPredict) 
    {
        this.isPredict = isPredict;
    }

    public String getIsPredict() 
    {
        return isPredict;
    }
    public void setIsActive(String isActive) 
    {
        this.isActive = isActive;
    }

    public String getIsActive() 
    {
        return isActive;
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
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }
    public void setDeleteUserId(Long deleteUserId) 
    {
        this.deleteUserId = deleteUserId;
    }

    public Long getDeleteUserId() 
    {
        return deleteUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("screenId", getScreenId())
            .append("screenName", getScreenName())
            .append("isPredict", getIsPredict())
            .append("isActive", getIsActive())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .append("createTime", getCreateTime())
            .append("createUserId", getCreateUserId())
            .append("isDeleted", getIsDeleted())
            .append("deleteTime", getDeleteTime())
            .append("deleteUserId", getDeleteUserId())
            .toString();
    }
}
