package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class  SysLog {
    private Integer id;

    private Integer userId;

    private String realName;

    private Byte type;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public SysLog(Integer id, Integer userId, String realName, Byte type, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.realName = realName;
        this.type = type;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysLog() {
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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