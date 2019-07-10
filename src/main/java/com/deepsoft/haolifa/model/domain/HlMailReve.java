package com.deepsoft.haolifa.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HlMailReve {
    private Integer id;
    private String content;
    private Integer mailId;
    private Integer userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String userName;

    public HlMailReve() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public HlMailReve(Integer id, String content, Integer mailId, Integer userId, Date createTime,String userName) {
        this.id = id;
        this.content = content;
        this.mailId = mailId;
        this.userId = userId;
        this.createTime = createTime;
        this.userName = userName;
    }
}