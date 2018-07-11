package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class RoleUserRelation {
    private Long id;

    private Long sysUserId;

    private Long sysRoleId;

    private Date ctime;

    private Date utime;

    public RoleUserRelation(Long id, Long sysUserId, Long sysRoleId, Date ctime, Date utime) {
        this.id = id;
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
        this.ctime = ctime;
        this.utime = utime;
    }

    public RoleUserRelation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
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