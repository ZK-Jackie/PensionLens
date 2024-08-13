package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算默认年份分年龄性别人数对象 t_yctxcs_person_number
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPersonNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 生育模式，对应BIRTH_MODE字典 */
    private String birthMode;

    /** 年份 */
    private Long year;

    /** 年龄 */
    private Long age;

    /** 男性人数 */
    @Excel(name = "男性人数")
    private Long male;

    /** 女性人数 */
    @Excel(name = "女性人数")
    private Long female;

    public void setPlanArea(Long planArea) 
    {
        this.planArea = planArea;
    }

    public Long getPlanArea() 
    {
        return planArea;
    }
    public void setBirthMode(String birthMode) 
    {
        this.birthMode = birthMode;
    }

    public String getBirthMode() 
    {
        return birthMode;
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
    public void setMale(Long male) 
    {
        this.male = male;
    }

    public Long getMale() 
    {
        return male;
    }
    public void setFemale(Long female) 
    {
        this.female = female;
    }

    public Long getFemale() 
    {
        return female;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("birthMode", getBirthMode())
            .append("year", getYear())
            .append("age", getAge())
            .append("male", getMale())
            .append("female", getFemale())
            .toString();
    }
}
