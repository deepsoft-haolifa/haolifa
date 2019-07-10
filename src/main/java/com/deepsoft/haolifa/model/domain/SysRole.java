package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysRole {
    private Integer id;

    private Integer deptId;

    private Integer pid;

    private String roleNo;

    private String roleName;

    private String description;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    public SysRole(Integer id, Integer deptId, Integer pid, String roleNo, String roleName, String description, Byte isDelete, Date createTime, Date updateTime) {
        this.id = id;
        this.deptId = deptId;
        this.pid = pid;
        this.roleNo = roleNo;
        this.roleName = roleName;
        this.description = description;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}