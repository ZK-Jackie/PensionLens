package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人口预测参数（按年龄）对象 t_yctxcs_person_predict_age
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPersonPredictAge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 年龄 */
    private Long age;

    /** 男性人数-起始人口 */
    @Excel(name = "男性人数-起始人口")
    private Long male;

    /** 女性人数-起始人口 */
    @Excel(name = "女性人数-起始人口")
    private Long female;

    /** 男性死亡模式 */
    @Excel(name = "男性死亡模式")
    private BigDecimal maleDeathMode;

    /** 女性死亡模式 */
    @Excel(name = "女性死亡模式")
    private BigDecimal femaleDeathMode;

    /** 生育模式，对应BIRTH_MODE字典 */
    @Excel(name = "生育模式，对应BIRTH_MODE字典")
    private String birthMode;

    /** 男性迁移模式 */
    @Excel(name = "男性迁移模式")
    private BigDecimal maleMigrationMode;

    /** 女性迁移模式 */
    @Excel(name = "女性迁移模式")
    private BigDecimal femaleMigrationMode;

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
    public void setMaleDeathMode(BigDecimal maleDeathMode) 
    {
        this.maleDeathMode = maleDeathMode;
    }

    public BigDecimal getMaleDeathMode() 
    {
        return maleDeathMode;
    }
    public void setFemaleDeathMode(BigDecimal femaleDeathMode) 
    {
        this.femaleDeathMode = femaleDeathMode;
    }

    public BigDecimal getFemaleDeathMode() 
    {
        return femaleDeathMode;
    }
    public void setBirthMode(String birthMode) 
    {
        this.birthMode = birthMode;
    }

    public String getBirthMode() 
    {
        return birthMode;
    }
    public void setMaleMigrationMode(BigDecimal maleMigrationMode) 
    {
        this.maleMigrationMode = maleMigrationMode;
    }

    public BigDecimal getMaleMigrationMode() 
    {
        return maleMigrationMode;
    }
    public void setFemaleMigrationMode(BigDecimal femaleMigrationMode) 
    {
        this.femaleMigrationMode = femaleMigrationMode;
    }

    public BigDecimal getFemaleMigrationMode() 
    {
        return femaleMigrationMode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("age", getAge())
            .append("male", getMale())
            .append("female", getFemale())
            .append("maleDeathMode", getMaleDeathMode())
            .append("femaleDeathMode", getFemaleDeathMode())
            .append("birthMode", getBirthMode())
            .append("maleMigrationMode", getMaleMigrationMode())
            .append("femaleMigrationMode", getFemaleMigrationMode())
            .toString();
    }
}
