package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysRoleUser {
    private Integer id;

    private Integer sysUserId;

    private Integer sysRoleId;

    private Date createTime;

    private Date updateTime;

    public SysRoleUser(Integer id, Integer sysUserId, Integer sysRoleId, Date createTime, Date updateTime) {
        this.id = id;
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysRoleUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
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