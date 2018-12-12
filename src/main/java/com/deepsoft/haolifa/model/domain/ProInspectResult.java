package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProInspectResult {
    private Integer id;

    private String inspectNo;

    private String orderNo;

    private String productModel;

    private String productSpecifications;

    private String testingUnit;

    private String testingProcess;

    private Integer testingNumber;

    private Integer unqualifiedNumber;

    private String testingPerson;

    private String technicalRequirements;

    private String testingResult;

    private String inspector;

    private Date inspecteTime;

    private String reason;

    private String responsibleDepartment;

    private String departmentLeader;

    private Date responsibleAnalyzeTime;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public ProInspectResult(Integer id, String inspectNo, String orderNo, String productModel, String productSpecifications, String testingUnit, String testingProcess, Integer testingNumber, Integer unqualifiedNumber, String testingPerson, String technicalRequirements, String testingResult, String inspector, Date inspecteTime, String reason, String responsibleDepartment, String departmentLeader, Date responsibleAnalyzeTime, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.inspectNo = inspectNo;
        this.orderNo = orderNo;
        this.productModel = productModel;
        this.productSpecifications = productSpecifications;
        this.testingUnit = testingUnit;
        this.testingProcess = testingProcess;
        this.testingNumber = testingNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.testingPerson = testingPerson;
        this.technicalRequirements = technicalRequirements;
        this.testingResult = testingResult;
        this.inspector = inspector;
        this.inspecteTime = inspecteTime;
        this.reason = reason;
        this.responsibleDepartment = responsibleDepartment;
        this.departmentLeader = departmentLeader;
        this.responsibleAnalyzeTime = responsibleAnalyzeTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public ProInspectResult() {
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

    public String getTestingUnit() {
        return testingUnit;
    }

    public void setTestingUnit(String testingUnit) {
        this.testingUnit = testingUnit == null ? null : testingUnit.trim();
    }

    public String getTestingProcess() {
        return testingProcess;
    }

    public void setTestingProcess(String testingProcess) {
        this.testingProcess = testingProcess == null ? null : testingProcess.trim();
    }

    public Integer getTestingNumber() {
        return testingNumber;
    }

    public void setTestingNumber(Integer testingNumber) {
        this.testingNumber = testingNumber;
    }

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public String getTestingPerson() {
        return testingPerson;
    }

    public void setTestingPerson(String testingPerson) {
        this.testingPerson = testingPerson == null ? null : testingPerson.trim();
    }

    public String getTechnicalRequirements() {
        return technicalRequirements;
    }

    public void setTechnicalRequirements(String technicalRequirements) {
        this.technicalRequirements = technicalRequirements == null ? null : technicalRequirements.trim();
    }

    public String getTestingResult() {
        return testingResult;
    }

    public void setTestingResult(String testingResult) {
        this.testingResult = testingResult == null ? null : testingResult.trim();
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getResponsibleDepartment() {
        return responsibleDepartment;
    }

    public void setResponsibleDepartment(String responsibleDepartment) {
        this.responsibleDepartment = responsibleDepartment == null ? null : responsibleDepartment.trim();
    }

    public String getDepartmentLeader() {
        return departmentLeader;
    }

    public void setDepartmentLeader(String departmentLeader) {
        this.departmentLeader = departmentLeader == null ? null : departmentLeader.trim();
    }

    public Date getResponsibleAnalyzeTime() {
        return responsibleAnalyzeTime;
    }

    public void setResponsibleAnalyzeTime(Date responsibleAnalyzeTime) {
        this.responsibleAnalyzeTime = responsibleAnalyzeTime;
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