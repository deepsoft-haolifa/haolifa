package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PressureInspectResult {
    private Integer id;

    private String inspectNo;

    private String orderNo;

    private Integer testingNumber;

    private Integer reinspectNumber;

    private Integer qualifiedNumber;

    private Integer unqualifiedNumber;

    private Date inspecteTime;

    private String testingPerson;

    private Date createTime;

    private Date updateTime;

    public PressureInspectResult(Integer id, String inspectNo, String orderNo, Integer testingNumber, Integer reinspectNumber, Integer qualifiedNumber, Integer unqualifiedNumber, Date inspecteTime, String testingPerson, Date createTime, Date updateTime) {
        this.id = id;
        this.inspectNo = inspectNo;
        this.orderNo = orderNo;
        this.testingNumber = testingNumber;
        this.reinspectNumber = reinspectNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.inspecteTime = inspecteTime;
        this.testingPerson = testingPerson;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PressureInspectResult() {
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

    public Date getInspecteTime() {
        return inspecteTime;
    }

    public void setInspecteTime(Date inspecteTime) {
        this.inspecteTime = inspecteTime;
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
}