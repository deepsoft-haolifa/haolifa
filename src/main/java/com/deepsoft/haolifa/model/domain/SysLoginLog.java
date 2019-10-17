package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysLoginLog {
    private Integer id;

    private Integer userId;

    private String realName;

    private Date createTime;

    public SysLoginLog(Integer id, Integer userId, String realName, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.realName = realName;
        this.createTime = createTime;
    }

    public SysLoginLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}