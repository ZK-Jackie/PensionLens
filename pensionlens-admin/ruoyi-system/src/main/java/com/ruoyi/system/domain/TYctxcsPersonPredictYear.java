package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人口预测参数（按年份）对象 t_yctxcs_person_predict_year
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPersonPredictYear extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    private Long planArea;

    /** 年份 */
    private Long year;

    /** 男性预期寿命-死亡水平 */
    @Excel(name = "男性预期寿命-死亡水平")
    private BigDecimal malePreLife;

    /** 女性预期寿命-死亡水平 */
    @Excel(name = "女性预期寿命-死亡水平")
    private BigDecimal femalePreLife;

    /** 出生性别比 */
    @Excel(name = "出生性别比")
    private BigDecimal sexRatioBirth;

    /** 男性迁移水平 */
    @Excel(name = "男性迁移水平")
    private Long maleMigrationNumber;

    /** 女性迁移水平 */
    @Excel(name = "女性迁移水平")
    private Long femaleMigrationNumber;

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
    public void setMalePreLife(BigDecimal malePreLife) 
    {
        this.malePreLife = malePreLife;
    }

    public BigDecimal getMalePreLife() 
    {
        return malePreLife;
    }
    public void setFemalePreLife(BigDecimal femalePreLife) 
    {
        this.femalePreLife = femalePreLife;
    }

    public BigDecimal getFemalePreLife() 
    {
        return femalePreLife;
    }
    public void setSexRatioBirth(BigDecimal sexRatioBirth) 
    {
        this.sexRatioBirth = sexRatioBirth;
    }

    public BigDecimal getSexRatioBirth() 
    {
        return sexRatioBirth;
    }
    public void setMaleMigrationNumber(Long maleMigrationNumber) 
    {
        this.maleMigrationNumber = maleMigrationNumber;
    }

    public Long getMaleMigrationNumber() 
    {
        return maleMigrationNumber;
    }
    public void setFemaleMigrationNumber(Long femaleMigrationNumber) 
    {
        this.femaleMigrationNumber = femaleMigrationNumber;
    }

    public Long getFemaleMigrationNumber() 
    {
        return femaleMigrationNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planArea", getPlanArea())
            .append("year", getYear())
            .append("malePreLife", getMalePreLife())
            .append("femalePreLife", getFemalePreLife())
            .append("sexRatioBirth", getSexRatioBirth())
            .append("maleMigrationNumber", getMaleMigrationNumber())
            .append("femaleMigrationNumber", getFemaleMigrationNumber())
            .toString();
    }
}
