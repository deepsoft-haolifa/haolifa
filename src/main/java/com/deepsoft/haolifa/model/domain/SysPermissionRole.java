package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysPermissionRole {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private Date createTime;

    private Date updateTime;

    public SysPermissionRole(Integer id, Integer roleId, Integer permissionId, Date createTime, Date updateTime) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysPermissionRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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