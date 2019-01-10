package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SupplierEvaluationRecord {
    private Integer id;

    private String supplierNo;

    private String supplierFile;

    private String accessory;

    private Byte auditResult;

    private Date createData;

    private Date updateDate;

    public SupplierEvaluationRecord(Integer id, String supplierNo, String supplierFile, String accessory, Byte auditResult, Date createData, Date updateDate) {
        this.id = id;
        this.supplierNo = supplierNo;
        this.supplierFile = supplierFile;
        this.accessory = accessory;
        this.auditResult = auditResult;
        this.createData = createData;
        this.updateDate = updateDate;
    }

    public SupplierEvaluationRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public String getSupplierFile() {
        return supplierFile;
    }

    public void setSupplierFile(String supplierFile) {
        this.supplierFile = supplierFile == null ? null : supplierFile.trim();
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory == null ? null : accessory.trim();
    }

    public Byte getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Byte auditResult) {
        this.auditResult = auditResult;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}