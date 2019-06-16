package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Inspect {
    private Integer id;

    private String inspectNo;

    private String purchaseNo;

    private String batchNumber;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Date arrivalTime;

    private String supplierName;

    private String supplierNo;

    private String blueprints;

    private Integer qualifiedNumber;

    private Integer totalCount;

    private Integer unqualifiedNumber;

    public Inspect(Integer id, String inspectNo, String purchaseNo, String batchNumber, Byte status, Date createTime, Date updateTime, Integer createUserId, Date arrivalTime, String supplierName, String supplierNo, String blueprints, Integer qualifiedNumber, Integer totalCount, Integer unqualifiedNumber) {
        this.id = id;
        this.inspectNo = inspectNo;
        this.purchaseNo = purchaseNo;
        this.batchNumber = batchNumber;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.arrivalTime = arrivalTime;
        this.supplierName = supplierName;
        this.supplierNo = supplierNo;
        this.blueprints = blueprints;
        this.qualifiedNumber = qualifiedNumber;
        this.totalCount = totalCount;
        this.unqualifiedNumber = unqualifiedNumber;
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

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
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

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public String getBlueprints() {
        return blueprints;
    }

    public void setBlueprints(String blueprints) {
        this.blueprints = blueprints == null ? null : blueprints.trim();
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }
}