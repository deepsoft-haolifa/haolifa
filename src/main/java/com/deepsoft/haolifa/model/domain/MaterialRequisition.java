package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class MaterialRequisition {
    private Integer id;

    private Date createTime;

    private Integer createUser;

    private String receiveNo;

    private String orderNo;

    private String receiveDepartment;

    private String receiveUserId;

    private String receiveUserName;

    public MaterialRequisition(Integer id, Date createTime, Integer createUser, String receiveNo, String orderNo, String receiveDepartment, String receiveUserId, String receiveUserName) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.receiveNo = receiveNo;
        this.orderNo = orderNo;
        this.receiveDepartment = receiveDepartment;
        this.receiveUserId = receiveUserId;
        this.receiveUserName = receiveUserName;
    }

    public MaterialRequisition() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo == null ? null : receiveNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getReceiveDepartment() {
        return receiveDepartment;
    }

    public void setReceiveDepartment(String receiveDepartment) {
        this.receiveDepartment = receiveDepartment == null ? null : receiveDepartment.trim();
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId == null ? null : receiveUserId.trim();
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName == null ? null : receiveUserName.trim();
    }
}