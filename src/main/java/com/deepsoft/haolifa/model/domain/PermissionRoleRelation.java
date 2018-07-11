package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PermissionRoleRelation {
    private Long id;

    private Long roleId;

    private Long permissionId;

    private Date ctime;

    private Date utime;

    public PermissionRoleRelation(Long id, Long roleId, Long permissionId, Date ctime, Date utime) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.ctime = ctime;
        this.utime = utime;
    }

    public PermissionRoleRelation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}