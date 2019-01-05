package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;

public class InspectHistory {
    private Integer id;

    private String purchaseNo;

    private String inspectNo;

    private String batchNumber;

    private String materialGraphNo;

    private String materialGraphName;

    private Integer testNumber;

    private Integer qualifiedNumber;

    private Integer unqualifiedNumber;

    private String handlingSuggestion;

    private BigDecimal purchasePrice;

    private String remark;

    private Byte status;

    private Byte type;

    private String supplierName;

    private String supplierNo;

    public InspectHistory(Integer id, String purchaseNo, String inspectNo, String batchNumber, String materialGraphNo, String materialGraphName, Integer testNumber, Integer qualifiedNumber, Integer unqualifiedNumber, String handlingSuggestion, BigDecimal purchasePrice, String remark, Byte status, Byte type, String supplierName, String supplierNo) {
        this.id = id;
        this.purchaseNo = purchaseNo;
        this.inspectNo = inspectNo;
        this.batchNumber = batchNumber;
        this.materialGraphNo = materialGraphNo;
        this.materialGraphName = materialGraphName;
        this.testNumber = testNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.handlingSuggestion = handlingSuggestion;
        this.purchasePrice = purchasePrice;
        this.remark = remark;
        this.status = status;
        this.type = type;
        this.supplierName = supplierName;
        this.supplierNo = supplierNo;
    }

    public InspectHistory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }

    public String getInspectNo() {
        return inspectNo;
    }

    public void setInspectNo(String inspectNo) {
        this.inspectNo = inspectNo == null ? null : inspectNo.trim();
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

    public String getMaterialGraphName() {
        return materialGraphName;
    }

    public void setMaterialGraphName(String materialGraphName) {
        this.materialGraphName = materialGraphName == null ? null : materialGraphName.trim();
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
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

    public String getHandlingSuggestion() {
        return handlingSuggestion;
    }

    public void setHandlingSuggestion(String handlingSuggestion) {
        this.handlingSuggestion = handlingSuggestion == null ? null : handlingSuggestion.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
}