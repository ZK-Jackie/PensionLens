package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏绑定预测方案对象 screen_plan
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public class ScreenPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 大屏id */
    private Long screenId;

    /** 方案id */
    private Long planId;

    /** 方案优先级 */
    @Excel(name = "方案优先级")
    private Long priority;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    public void setScreenId(Long screenId) 
    {
        this.screenId = screenId;
    }

    public Long getScreenId() 
    {
        return screenId;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setPriority(Long priority) 
    {
        this.priority = priority;
    }

    public Long getPriority() 
    {
        return priority;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("screenId", getScreenId())
            .append("planId", getPlanId())
            .append("priority", getPriority())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .toString();
    }
}
