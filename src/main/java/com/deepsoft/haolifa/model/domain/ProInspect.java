package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProInspect {
    private Integer id;

    private String inspectNo;

    private String orderNo;

    private Byte storageStatus;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public ProInspect(Integer id, String inspectNo, String orderNo, Byte storageStatus, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.inspectNo = inspectNo;
        this.orderNo = orderNo;
        this.storageStatus = storageStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public ProInspect() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInspectNo() {
        return inspectNo;
    }

    public void setInspectNo(String inspectNo) {
        this.inspectNo = inspectNo == null ? null : inspectNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Byte getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(Byte storageStatus) {
        this.storageStatus = storageStatus;
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