package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏空位与大屏数据对照表对象 screen_detail_data
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public class ScreenDetailData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图表配置id */
    private Long detailId;

    /** 图表数据id */
    private Long dataId;

    /** 图表类型，参照CHART_TYPE字典 */
    @Excel(name = "图表类型，参照CHART_TYPE字典")
    private String displayMode;

    /** 图表可展现的形式，参照CHART_TYPE字典 */
    @Excel(name = "图表可展现的形式，参照CHART_TYPE字典")
    private String displayableMode;

    /** 数据开始时间 */
    @Excel(name = "数据开始时间")
    private String startTime;

    /** 数据结束时间 */
    @Excel(name = "数据结束时间")
    private String endTime;

    /** 是否是资讯类数据，N-否，Y-是 */
    @Excel(name = "是否是资讯类数据，N-否，Y-是")
    private String isInfo;

    /** 是否是预测数据，N-否，Y-是 */
    @Excel(name = "是否是预测数据，N-否，Y-是")
    private String isPredict;

    /** 预测数据开始时间 */
    @Excel(name = "预测数据开始时间")
    private String predictStartTime;

    /** 预测数据结束时间 */
    @Excel(name = "预测数据结束时间")
    private String predictEndTime;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    /** 是否是默认被选中的项 */
    @Excel(name = "是否是默认被选中的项")
    private String isDefault;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }
    public void setDataId(Long dataId) 
    {
        this.dataId = dataId;
    }

    public Long getDataId() 
    {
        return dataId;
    }
    public void setDisplayMode(String displayMode) 
    {
        this.displayMode = displayMode;
    }

    public String getDisplayMode() 
    {
        return displayMode;
    }
    public void setDisplayableMode(String displayableMode) 
    {
        this.displayableMode = displayableMode;
    }

    public String getDisplayableMode() 
    {
        return displayableMode;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setIsInfo(String isInfo) 
    {
        this.isInfo = isInfo;
    }

    public String getIsInfo() 
    {
        return isInfo;
    }
    public void setIsPredict(String isPredict) 
    {
        this.isPredict = isPredict;
    }

    public String getIsPredict() 
    {
        return isPredict;
    }
    public void setPredictStartTime(String predictStartTime) 
    {
        this.predictStartTime = predictStartTime;
    }

    public String getPredictStartTime() 
    {
        return predictStartTime;
    }
    public void setPredictEndTime(String predictEndTime) 
    {
        this.predictEndTime = predictEndTime;
    }

    public String getPredictEndTime() 
    {
        return predictEndTime;
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
    public void setIsDefault(String isDefault) 
    {
        this.isDefault = isDefault;
    }

    public String getIsDefault() 
    {
        return isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailId", getDetailId())
            .append("dataId", getDataId())
            .append("displayMode", getDisplayMode())
            .append("displayableMode", getDisplayableMode())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("isInfo", getIsInfo())
            .append("isPredict", getIsPredict())
            .append("predictStartTime", getPredictStartTime())
            .append("predictEndTime", getPredictEndTime())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .append("isDefault", getIsDefault())
            .toString();
    }
}
