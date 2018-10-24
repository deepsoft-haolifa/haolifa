package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysMessage {
    private Integer id;

    private Byte type;

    private Date showTime;

    private Integer createUser;

    private Date createTime;

    private Date updateTime;

    private String content;

    public SysMessage(Integer id, Byte type, Date showTime, Integer createUser, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.type = type;
        this.showTime = showTime;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public SysMessage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}