package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Entrust {
    private Integer id;

    private String materialClassifyName;

    private String purchaseNo;

    private String entrustNo;

    private String materialGraphNo;

    private String materialGraphName;

    private String specifications;

    private String model;

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

    private Integer unqualifiedNumber;

    private String processedGraphNo;

    private Byte busType;

    private Byte outRoomStatus;

    private Byte taskStatus;

    public Entrust(Integer id, String materialClassifyName, String purchaseNo, String entrustNo, String materialGraphNo, String materialGraphName, String specifications, String model, Byte workshopType, String supplierName, String supplierNo, String batchNumber, Integer number, BigDecimal purchasePrice, Byte status, String entrustPerson, Byte isDelete, Date createTime, Date updateTime, Integer createUserId, Byte inspectStatus, Integer qualifiedNumber, Integer unqualifiedNumber, String processedGraphNo, Byte busType, Byte outRoomStatus, Byte taskStatus) {
        this.id = id;
        this.materialClassifyName = materialClassifyName;
        this.purchaseNo = purchaseNo;
        this.entrustNo = entrustNo;
        this.materialGraphNo = materialGraphNo;
        this.materialGraphName = materialGraphName;
        this.specifications = specifications;
        this.model = model;
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
        this.unqualifiedNumber = unqualifiedNumber;
        this.processedGraphNo = processedGraphNo;
        this.busType = busType;
        this.outRoomStatus = outRoomStatus;
        this.taskStatus = taskStatus;
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

    public String getMaterialClassifyName() {
        return materialClassifyName;
    }

    public void setMaterialClassifyName(String materialClassifyName) {
        this.materialClassifyName = materialClassifyName == null ? null : materialClassifyName.trim();
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

    public String getMaterialGraphName() {
        return materialGraphName;
    }

    public void setMaterialGraphName(String materialGraphName) {
        this.materialGraphName = materialGraphName == null ? null : materialGraphName.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
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

    public Byte getOutRoomStatus() {
        return outRoomStatus;
    }

    public void setOutRoomStatus(Byte outRoomStatus) {
        this.outRoomStatus = outRoomStatus;
    }

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }
}