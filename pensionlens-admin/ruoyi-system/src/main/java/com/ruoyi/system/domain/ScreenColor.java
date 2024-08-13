package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏颜色设置对象 screen_color
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public class ScreenColor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据颜色id */
    @Excel(name = "数据颜色id")
    private Long dataColorId;

    /** 数据颜色名称 */
    @Excel(name = "数据颜色名称")
    private String dataColorName;

    /** 数据颜色列表，需要序列化和反序列化 */
    @Excel(name = "数据颜色列表，需要序列化和反序列化")
    private String dataColor;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    public void setDataColorId(Long dataColorId) 
    {
        this.dataColorId = dataColorId;
    }

    public Long getDataColorId() 
    {
        return dataColorId;
    }
    public void setDataColorName(String dataColorName) 
    {
        this.dataColorName = dataColorName;
    }

    public String getDataColorName() 
    {
        return dataColorName;
    }
    public void setDataColor(String dataColor) 
    {
        this.dataColor = dataColor;
    }

    public String getDataColor() 
    {
        return dataColor;
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
            .append("dataColorId", getDataColorId())
            .append("dataColorName", getDataColorName())
            .append("dataColor", getDataColor())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .toString();
    }
}
