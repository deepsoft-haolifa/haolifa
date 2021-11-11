package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayOrderUserRelationProcedure {
    private Integer id;

    private Integer userId;

    private String orderId;

    private String procedureId;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayOrderUserRelationProcedure(Integer id, Integer userId, String orderId, String procedureId, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.procedureId = procedureId;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayOrderUserRelationProcedure() {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId == null ? null : procedureId.trim();
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