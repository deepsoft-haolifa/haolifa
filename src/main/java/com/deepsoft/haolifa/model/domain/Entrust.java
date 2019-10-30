package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Entrust {
    private Integer id;

    private String materialGraphName;

    private String purchaseNo;

    private String entrustNo;

    private String materialGraphNo;

    private Byte workshopType;

    private String supplierName;

    private String supplierNo;

    private String batchNumber;

    private Integer number;

    private BigDecimal purchasePrice;

    private Byte status;

    private String entrustPerson;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Byte inspectStatus;

    private Integer qualifiedNumber;

    private String processedGraphNo;

    private Byte busType;

    public Entrust(Integer id, String materialGraphName, String purchaseNo, String entrustNo, String materialGraphNo, Byte workshopType, String supplierName, String supplierNo, String batchNumber, Integer number, BigDecimal purchasePrice, Byte status, String entrustPerson, Byte isDelete, Date createTime, Date updateTime, Integer createUserId, Byte inspectStatus, Integer qualifiedNumber, String processedGraphNo, Byte busType) {
        this.id = id;
        this.materialGraphName = materialGraphName;
        this.purchaseNo = purchaseNo;
        this.entrustNo = entrustNo;
        this.materialGraphNo = materialGraphNo;
        this.workshopType = workshopType;
        this.supplierName = supplierName;
        this.supplierNo = supplierNo;
        this.batchNumber = batchNumber;
        this.number = number;
        this.purchasePrice = purchasePrice;
        this.status = status;
        this.entrustPerson = entrustPerson;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.inspectStatus = inspectStatus;
        this.qualifiedNumber = qualifiedNumber;
        this.processedGraphNo = processedGraphNo;
        this.busType = busType;
    }

    public Entrust() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialGraphName() {
        return materialGraphName;
    }

    public void setMaterialGraphName(String materialGraphName) {
        this.materialGraphName = materialGraphName == null ? null : materialGraphName.trim();
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }

    public String getEntrustNo() {
        return entrustNo;
    }

    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo == null ? null : entrustNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Byte getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(Byte workshopType) {
        this.workshopType = workshopType;
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getEntrustPerson() {
        return entrustPerson;
    }

    public void setEntrustPerson(String entrustPerson) {
        this.entrustPerson = entrustPerson == null ? null : entrustPerson.trim();
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

    public Byte getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(Byte inspectStatus) {
        this.inspectStatus = inspectStatus;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public String getProcessedGraphNo() {
        return processedGraphNo;
    }

    public void setProcessedGraphNo(String processedGraphNo) {
        this.processedGraphNo = processedGraphNo == null ? null : processedGraphNo.trim();
    }

    public Byte getBusType() {
        return busType;
    }

    public void setBusType(Byte busType) {
        this.busType = busType;
    }
}