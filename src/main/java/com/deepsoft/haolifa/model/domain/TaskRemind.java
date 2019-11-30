package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class TaskRemind {
    private Integer id;

    private String title;

    private String content;

    private Integer roleId;

    private Byte readStatus;

    private Date createTime;

    private Integer createUser;

    private Integer updateUser;

    private Date updateTime;

    public TaskRemind(Integer id, String title, String content, Integer roleId, Byte readStatus, Date createTime, Integer createUser, Integer updateUser, Date updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.roleId = roleId;
        this.readStatus = readStatus;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public TaskRemind() {
        super();
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
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Byte getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Byte readStatus) {
        this.readStatus = readStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}