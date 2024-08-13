package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测算统筹区域对象 t_yctxcs_area_code_dict
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsAreaCodeDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 区域代码 */
    private Long code;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String areaName;

    /** 计算视同缴费年限的截止年份 */
    @Excel(name = "计算视同缴费年限的截止年份")
    private Long baseYear;

    /** 该统筹区域按照【国发[1997]26号】要求实施相应政策的年份 */
    @Excel(name = "该统筹区域按照【国发[1997]26号】要求实施相应政策的年份")
    private Long policy1999;

    /** 该统筹区域按照【国发[2005]38号】要求实施相应政策的年份 */
    @Excel(name = "该统筹区域按照【国发[2005]38号】要求实施相应政策的年份")
    private Long policy2005;

    public void setCode(Long code) 
    {
        this.code = code;
    }

    public Long getCode() 
    {
        return code;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setBaseYear(Long baseYear) 
    {
        this.baseYear = baseYear;
    }

    public Long getBaseYear() 
    {
        return baseYear;
    }
    public void setPolicy1999(Long policy1999) 
    {
        this.policy1999 = policy1999;
    }

    public Long getPolicy1999() 
    {
        return policy1999;
    }
    public void setPolicy2005(Long policy2005) 
    {
        this.policy2005 = policy2005;
    }

    public Long getPolicy2005() 
    {
        return policy2005;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("code", getCode())
            .append("areaName", getAreaName())
            .append("baseYear", getBaseYear())
            .append("policy1999", getPolicy1999())
            .append("policy2005", getPolicy2005())
            .toString();
    }
}
