package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 延迟退休测算方案历史表对象 t_yctxcs_plan_history
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public class TYctxcsPlanHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方案历史id */
    private Long id;

    /** 方案id */
    @Excel(name = "方案id")
    private Long planId;

    /** 方案名称 */
    @Excel(name = "方案名称")
    private String planName;

    /** 统筹区域，对应t_yctxcs_area_code_dict的code值 */
    @Excel(name = "统筹区域，对应t_yctxcs_area_code_dict的code值")
    private Long planArea;

    /** 测算起始年份 */
    @Excel(name = "测算起始年份")
    private String startYear;

    /** 测算结束年份 */
    @Excel(name = "测算结束年份")
    private String endYear;

    /** 测算执行状态，对应EXECUTE_STATUS字典 */
    @Excel(name = "测算执行状态，对应EXECUTE_STATUS字典")
    private String executeStatus;

    /** 测算执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测算执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date executeTime;

    /** 测算方案版本 */
    @Excel(name = "测算方案版本")
    private String planVersion;

    /** 上一年度养老金累计结余 */
    @Excel(name = "上一年度养老金累计结余")
    private BigDecimal lastYearSumSurplus;

    /** 退休人员类型，对应RETIRE_PERSON_TYPE字典，以多个逗号分隔 */
    @Excel(name = "退休人员类型，对应RETIRE_PERSON_TYPE字典，以多个逗号分隔")
    private String retirePersonTypes;

    /** 生育模式，对应BIRTH_MODE字典 */
    @Excel(name = "生育模式，对应BIRTH_MODE字典")
    private String birthMode;

    /** 操作类型，对应CHANGE_TYPE字典：ADD-新增；UPDATE-修改；DELETE-删除 */
    @Excel(name = "操作类型，对应CHANGE_TYPE字典：ADD-新增；UPDATE-修改；DELETE-删除")
    private String changeType;

    /** 操作人id */
    @Excel(name = "操作人id")
    private Long changeUserId;

    /** 变更时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "变更时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date changeTime;

    /** 是否删除，N-否，Y-是 */
    @Excel(name = "是否删除，N-否，Y-是")
    private String isDeleted;

    /** 插入人id */
    @Excel(name = "插入人id")
    private Long insertUserId;

    /** 插入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "插入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date insertTime;

    /** 最后更新人id */
    @Excel(name = "最后更新人id")
    private Long lastUpdateUserId;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    /** 删除人id */
    @Excel(name = "删除人id")
    private Long deleteUserId;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setPlanArea(Long planArea) 
    {
        this.planArea = planArea;
    }

    public Long getPlanArea() 
    {
        return planArea;
    }
    public void setStartYear(String startYear) 
    {
        this.startYear = startYear;
    }

    public String getStartYear() 
    {
        return startYear;
    }
    public void setEndYear(String endYear) 
    {
        this.endYear = endYear;
    }

    public String getEndYear() 
    {
        return endYear;
    }
    public void setExecuteStatus(String executeStatus) 
    {
        this.executeStatus = executeStatus;
    }

    public String getExecuteStatus() 
    {
        return executeStatus;
    }
    public void setExecuteTime(Date executeTime) 
    {
        this.executeTime = executeTime;
    }

    public Date getExecuteTime() 
    {
        return executeTime;
    }
    public void setPlanVersion(String planVersion) 
    {
        this.planVersion = planVersion;
    }

    public String getPlanVersion() 
    {
        return planVersion;
    }
    public void setLastYearSumSurplus(BigDecimal lastYearSumSurplus) 
    {
        this.lastYearSumSurplus = lastYearSumSurplus;
    }

    public BigDecimal getLastYearSumSurplus() 
    {
        return lastYearSumSurplus;
    }
    public void setRetirePersonTypes(String retirePersonTypes) 
    {
        this.retirePersonTypes = retirePersonTypes;
    }

    public String getRetirePersonTypes() 
    {
        return retirePersonTypes;
    }
    public void setBirthMode(String birthMode) 
    {
        this.birthMode = birthMode;
    }

    public String getBirthMode() 
    {
        return birthMode;
    }
    public void setChangeType(String changeType) 
    {
        this.changeType = changeType;
    }

    public String getChangeType() 
    {
        return changeType;
    }
    public void setChangeUserId(Long changeUserId) 
    {
        this.changeUserId = changeUserId;
    }

    public Long getChangeUserId() 
    {
        return changeUserId;
    }
    public void setChangeTime(Date changeTime) 
    {
        this.changeTime = changeTime;
    }

    public Date getChangeTime() 
    {
        return changeTime;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }
    public void setInsertUserId(Long insertUserId) 
    {
        this.insertUserId = insertUserId;
    }

    public Long getInsertUserId() 
    {
        return insertUserId;
    }
    public void setInsertTime(Date insertTime) 
    {
        this.insertTime = insertTime;
    }

    public Date getInsertTime() 
    {
        return insertTime;
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
    public void setDeleteUserId(Long deleteUserId) 
    {
        this.deleteUserId = deleteUserId;
    }

    public Long getDeleteUserId() 
    {
        return deleteUserId;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planId", getPlanId())
            .append("planName", getPlanName())
            .append("planArea", getPlanArea())
            .append("startYear", getStartYear())
            .append("endYear", getEndYear())
            .append("executeStatus", getExecuteStatus())
            .append("executeTime", getExecuteTime())
            .append("planVersion", getPlanVersion())
            .append("lastYearSumSurplus", getLastYearSumSurplus())
            .append("retirePersonTypes", getRetirePersonTypes())
            .append("birthMode", getBirthMode())
            .append("changeType", getChangeType())
            .append("changeUserId", getChangeUserId())
            .append("changeTime", getChangeTime())
            .append("isDeleted", getIsDeleted())
            .append("insertUserId", getInsertUserId())
            .append("insertTime", getInsertTime())
            .append("lastUpdateUserId", getLastUpdateUserId())
            .append("lastUpdateTime", getLastUpdateTime())
            .append("deleteUserId", getDeleteUserId())
            .append("deleteTime", getDeleteTime())
            .toString();
    }
}
