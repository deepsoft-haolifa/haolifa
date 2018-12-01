package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Inspect {
    private Integer id;

    private String inspectNo;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Date arrivalTime;

    private String supplierName;

    public Inspect(Integer id, String inspectNo, Byte status, Date createTime, Date updateTime, Integer createUserId, Date arrivalTime, String supplierName) {
        this.id = id;
        this.inspectNo = inspectNo;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.arrivalTime = arrivalTime;
        this.supplierName = supplierName;
    }

    public Inspect() {
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }
}