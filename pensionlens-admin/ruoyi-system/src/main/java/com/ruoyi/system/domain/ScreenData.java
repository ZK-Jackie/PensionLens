package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏数据定位对象 screen_data
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public class ScreenData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据id */
    private Long dataId;

    /** 数据名称列表，需要序列化和反序列化 */
    @Excel(name = "数据名称列表，需要序列化和反序列化")
    private String dataName;

    /** 数据所在表 */
    @Excel(name = "数据所在表")
    private String dataLocation;

    /** 数据键的标签名 */
    @Excel(name = "数据键的标签名")
    private String keyLabel;

    /** 数据键的单位 */
    @Excel(name = "数据键的单位")
    private String keyUnit;

    /** 数据值的标签名 */
    @Excel(name = "数据值的标签名")
    private String valueLabel;

    /** 数据值的单位 */
    @Excel(name = "数据值的单位")
    private String valueUnit;

    /** 数据呈现精度 */
    @Excel(name = "数据呈现精度")
    private String numPrecision;

    /** 数据值最大值 */
    @Excel(name = "数据值最大值")
    private BigDecimal maxValue;

    /** 数据值最小值 */
    @Excel(name = "数据值最小值")
    private BigDecimal minValue;

    /** 数据颜色id */
    @Excel(name = "数据颜色id")
    private Long dataColorId;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    public void setDataId(Long dataId) 
    {
        this.dataId = dataId;
    }

    public Long getDataId() 
    {
        return dataId;
    }
    public void setDataName(String dataName) 
    {
        this.dataName = dataName;
    }

    public String getDataName() 
    {
        return dataName;
    }
    public void setDataLocation(String dataLocation) 
    {
        this.dataLocation = dataLocation;
    }

    public String getDataLocation() 
    {
        return dataLocation;
    }
    public void setKeyLabel(String keyLabel) 
    {
        this.keyLabel = keyLabel;
    }

    public String getKeyLabel() 
    {
        return keyLabel;
    }
    public void setKeyUnit(String keyUnit) 
    {
        this.keyUnit = keyUnit;
    }

    public String getKeyUnit() 
    {
        return keyUnit;
    }
    public void setValueLabel(String valueLabel) 
    {
        this.valueLabel = valueLabel;
    }

    public String getValueLabel() 
    {
        return valueLabel;
    }
    public void setValueUnit(String valueUnit) 
    {
        this.valueUnit = valueUnit;
    }

    public String getValueUnit() 
    {
        return valueUnit;
    }
    public void setNumPrecision(String numPrecision) 
    {
        this.numPrecision = numPrecision;
    }

    public String getNumPrecision() 
    {
        return numPrecision;
    }
    public void setMaxValue(BigDecimal maxValue) 
    {
        this.maxValue = maxValue;
    }

    public BigDecimal getMaxValue() 
    {
        return maxValue;
    }
    public void setMinValue(BigDecimal minValue) 
    {
        this.minValue = minValue;
    }

    public BigDecimal getMinValue() 
    {
        return minValue;
    }
    public void setDataColorId(Long dataColorId) 
    {
        this.dataColorId = dataColorId;
    }

    public Long getDataColorId() 
    {
        return dataColorId;
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
            .append("dataId", getDataId())
            .append("dataName", getDataName())
            .append("dataLocation", getDataLocation())
            .append("keyLabel", getKeyLabel())
            .append("keyUnit", getKeyUnit())
            .append("valueLabel", getValueLabel())
            .append("valueUnit", getValueUnit())
            .append("numPrecision", getNumPrecision())
            .append("maxValue", getMaxValue())
            .append("minValue", getMinValue())
            .append("dataColorId", getDataColorId())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .toString();
    }
}
