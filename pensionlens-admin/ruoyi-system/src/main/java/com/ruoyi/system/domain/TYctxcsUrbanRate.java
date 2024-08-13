package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算城镇化率默认参数表对象 t_yctxcs_urban_rate
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsUrbanRate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 年份 */
    private Long year;

    /** 年龄 */
    private Long age;

    /** 城镇化率 */
    @Excel(name = "城镇化率")
    private BigDecimal urbanRate;

    public void setPlanArea(Long planArea) 
    {
        this.planArea = planArea;
    }

    public Long getPlanArea() 
    {
        return planArea;
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
    public void setUrbanRate(BigDecimal urbanRate) 
    {
        this.urbanRate = urbanRate;
    }

    public BigDecimal getUrbanRate() 
    {
        return urbanRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("year", getYear())
            .append("age", getAge())
            .append("urbanRate", getUrbanRate())
            .toString();
    }
}
