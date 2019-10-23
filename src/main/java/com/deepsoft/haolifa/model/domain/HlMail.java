package com.deepsoft.haolifa.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class HlMail {
    private Integer id;
    private String title;
    private String users;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Date createTime;
    private Date updateTime;
    private String sendUser;
    private String revUser;

    public HlMail(Integer id, String title, String users, String content, Date createTime, Date updateTime,String sendUser,String revUser) {
        this.id = id;
        this.title = title;
        this.users = users;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendUser = sendUser;
        this.revUser = revUser;
    }

    public HlMail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getRevUser() {
        return revUser;
    }

    public void setRevUser(String revUser) {
        this.revUser = revUser;
    }
}

