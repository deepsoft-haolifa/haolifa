package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FinanceInfo {
    private Integer id;

    private String orderNo;

    private Byte type;

    private Integer totalAmount;

    private Byte state;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public FinanceInfo(Integer id, String orderNo, Byte type, Integer totalAmount, Byte state, Byte isDelete, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.orderNo = orderNo;
        this.type = type;
        this.totalAmount = totalAmount;
        this.state = state;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public FinanceInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}