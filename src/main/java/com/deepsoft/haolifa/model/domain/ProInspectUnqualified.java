package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProInspectUnqualified {
    private Integer id;

    private String inspectNo;

    private String orderNo;

    private String productModel;

    private String productSpecifications;

    private Integer unqualifiedNumber;

    private String reason;

    private String testingPerson;

    private String inspector;

    private Date inspecteTime;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public ProInspectUnqualified(Integer id, String inspectNo, String orderNo, String productModel, String productSpecifications, Integer unqualifiedNumber, String reason, String testingPerson, String inspector, Date inspecteTime, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.inspectNo = inspectNo;
        this.orderNo = orderNo;
        this.productModel = productModel;
        this.productSpecifications = productSpecifications;
        this.unqualifiedNumber = unqualifiedNumber;
        this.reason = reason;
        this.testingPerson = testingPerson;
        this.inspector = inspector;
        this.inspecteTime = inspecteTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public ProInspectUnqualified() {
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

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public Date getInspecteTime() {
        return inspecteTime;
    }

    public void setInspecteTime(Date inspecteTime) {
        this.inspecteTime = inspecteTime;
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