package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayOrderRelationMoreUser {
    private Integer id;

    private Integer relationProcedureId;

    private Integer userId;

    private Integer qualifiedNumber;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayOrderRelationMoreUser(Integer id, Integer relationProcedureId, Integer userId, Integer qualifiedNumber, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.relationProcedureId = relationProcedureId;
        this.userId = userId;
        this.qualifiedNumber = qualifiedNumber;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayOrderRelationMoreUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRelationProcedureId() {
        return relationProcedureId;
    }

    public void setRelationProcedureId(Integer relationProcedureId) {
        this.relationProcedureId = relationProcedureId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
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