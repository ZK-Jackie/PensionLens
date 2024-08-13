package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算默认人口数量表对象 t_yctxcs_person_index
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPersonIndex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 年龄 */
    private Long age;

    /** 男性死亡率 */
    @Excel(name = "男性死亡率")
    private BigDecimal mDeathRate;

    /** 女性死亡率 */
    @Excel(name = "女性死亡率")
    private BigDecimal fDeathRate;

    /** 男性就业率 */
    @Excel(name = "男性就业率")
    private BigDecimal mEmploymentRate;

    /** 女性就业率 */
    @Excel(name = "女性就业率")
    private BigDecimal fEmploymentRate;

    public void setPlanArea(Long planArea) 
    {
        this.planArea = planArea;
    }

    public Long getPlanArea() 
    {
        return planArea;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setmDeathRate(BigDecimal mDeathRate) 
    {
        this.mDeathRate = mDeathRate;
    }

    public BigDecimal getmDeathRate() 
    {
        return mDeathRate;
    }
    public void setfDeathRate(BigDecimal fDeathRate) 
    {
        this.fDeathRate = fDeathRate;
    }

    public BigDecimal getfDeathRate() 
    {
        return fDeathRate;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("age", getAge())
            .append("mDeathRate", getmDeathRate())
            .append("fDeathRate", getfDeathRate())
            .append("mEmploymentRate", getmEmploymentRate())
            .append("fEmploymentRate", getfEmploymentRate())
            .toString();
    }
}
