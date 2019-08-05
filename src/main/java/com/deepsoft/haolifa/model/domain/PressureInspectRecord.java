package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PressureInspectRecord {
    private Integer id;

    private String orderNo;

    private String productNo;

    private String productModel;

    private String productSpecifications;

    private Integer testingNumber;

    private Integer reinspectNumber;

    private Integer qualifiedNumber;

    private Integer unqualifiedNumber;

    private String reason;

    private String testingPerson;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private String accessory;

    public PressureInspectRecord(Integer id, String orderNo, String productNo, String productModel, String productSpecifications, Integer testingNumber, Integer reinspectNumber, Integer qualifiedNumber, Integer unqualifiedNumber, String reason, String testingPerson, Date createTime, Date updateTime, Integer createUserId, String accessory) {
        this.id = id;
        this.orderNo = orderNo;
        this.productNo = productNo;
        this.productModel = productModel;
        this.productSpecifications = productSpecifications;
        this.testingNumber = testingNumber;
        this.reinspectNumber = reinspectNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.reason = reason;
        this.testingPerson = testingPerson;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.accessory = accessory;
    }

    public PressureInspectRecord() {
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

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(String productSpecifications) {
        this.productSpecifications = productSpecifications == null ? null : productSpecifications.trim();
    }

    public Integer getTestingNumber() {
        return testingNumber;
    }

    public void setTestingNumber(Integer testingNumber) {
        this.testingNumber = testingNumber;
    }

    public Integer getReinspectNumber() {
        return reinspectNumber;
    }

    public void setReinspectNumber(Integer reinspectNumber) {
        this.reinspectNumber = reinspectNumber;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getTestingPerson() {
        return testingPerson;
    }

    public void setTestingPerson(String testingPerson) {
        this.testingPerson = testingPerson == null ? null : testingPerson.trim();
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

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory == null ? null : accessory.trim();
    }
}