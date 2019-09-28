package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class CheckMaterialLock {
    private Integer id;

    private String orderNo;

    private String materialGraphNo;

    private Byte type;

    private Integer lockQuantity;

    private Date createTime;

    private Date updateTime;

    public CheckMaterialLock(Integer id, String orderNo, String materialGraphNo, Byte type, Integer lockQuantity, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.materialGraphNo = materialGraphNo;
        this.type = type;
        this.lockQuantity = lockQuantity;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CheckMaterialLock() {
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

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getLockQuantity() {
        return lockQuantity;
    }

    public void setLockQuantity(Integer lockQuantity) {
        this.lockQuantity = lockQuantity;
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