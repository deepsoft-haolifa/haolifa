package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class RejectMaterialRecord {
    private Long id;

    private String recordNo;

    private String purchaseOrderNo;

    private String batchNumber;

    private String materialGraphNo;

    private Integer number;

    private Integer acceptNumber;

    private Integer entrustNumber;

    private Integer backNumber;

    private Byte status;

    private Long inspectId;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public RejectMaterialRecord(Long id, String recordNo, String purchaseOrderNo, String batchNumber, String materialGraphNo, Integer number, Integer acceptNumber, Integer entrustNumber, Integer backNumber, Byte status, Long inspectId, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.recordNo = recordNo;
        this.purchaseOrderNo = purchaseOrderNo;
        this.batchNumber = batchNumber;
        this.materialGraphNo = materialGraphNo;
        this.number = number;
        this.acceptNumber = acceptNumber;
        this.entrustNumber = entrustNumber;
        this.backNumber = backNumber;
        this.status = status;
        this.inspectId = inspectId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public RejectMaterialRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo == null ? null : recordNo.trim();
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(Integer acceptNumber) {
        this.acceptNumber = acceptNumber;
    }

    public Integer getEntrustNumber() {
        return entrustNumber;
    }

    public void setEntrustNumber(Integer entrustNumber) {
        this.entrustNumber = entrustNumber;
    }

    public Integer getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(Integer backNumber) {
        this.backNumber = backNumber;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getInspectId() {
        return inspectId;
    }

    public void setInspectId(Long inspectId) {
        this.inspectId = inspectId;
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