package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayWagesRelationUser {
    private Integer id;

    private Integer wagesId;

    private Integer userId;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayWagesRelationUser(Integer id, Integer wagesId, Integer userId, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.wagesId = wagesId;
        this.userId = userId;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayWagesRelationUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWagesId() {
        return wagesId;
    }

    public void setWagesId(Integer wagesId) {
        this.wagesId = wagesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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