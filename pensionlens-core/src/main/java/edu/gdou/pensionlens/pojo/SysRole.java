package edu.gdou.pensionlens.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 * @TableName sys_role
 */
@Data
public class SysRole implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * del_flag
     */
    private Integer delFlag;

    /**
     * 
     */
    private Long createBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Long updateBy;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
}