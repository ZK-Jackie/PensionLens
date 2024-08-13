package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏配置表对象 screen_detail
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public class ScreenDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图表配置id */
    private Long detailId;

    /** 大屏id */
    private Long screenId;

    /** 图表位置 */
    private Long detailSpot;

    /** 图表名称 */
    @Excel(name = "图表名称")
    private String detailName;

    /** 最小数据量单位 */
    @Excel(name = "最小数据量单位")
    private String minDataUnit;

    /** 是否含有多选按钮，N-否，Y-是 */
    @Excel(name = "是否含有多选按钮，N-否，Y-是")
    private String isMultiOption;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }
    public void setScreenId(Long screenId) 
    {
        this.screenId = screenId;
    }

    public Long getScreenId() 
    {
        return screenId;
    }
    public void setDetailSpot(Long detailSpot) 
    {
        this.detailSpot = detailSpot;
    }

    public Long getDetailSpot() 
    {
        return detailSpot;
    }
    public void setDetailName(String detailName) 
    {
        this.detailName = detailName;
    }

    public String getDetailName() 
    {
        return detailName;
    }
    public void setMinDataUnit(String minDataUnit) 
    {
        this.minDataUnit = minDataUnit;
    }

    public String getMinDataUnit() 
    {
        return minDataUnit;
    }
    public void setIsMultiOption(String isMultiOption) 
    {
        this.isMultiOption = isMultiOption;
    }

    public String getIsMultiOption() 
    {
        return isMultiOption;
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
            .append("detailId", getDetailId())
            .append("screenId", getScreenId())
            .append("detailSpot", getDetailSpot())
            .append("detailName", getDetailName())
            .append("minDataUnit", getMinDataUnit())
            .append("isMultiOption", getIsMultiOption())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .toString();
    }
}
