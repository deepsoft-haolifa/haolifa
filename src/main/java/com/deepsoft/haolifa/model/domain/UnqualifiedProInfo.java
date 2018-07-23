package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class UnqualifiedProInfo {
    private Integer id;

    private String orderNum;

    private String testingUnit;

    private String testingProcess;

    private Long productId;

    private Integer testingNumber;

    private Integer unqualifiedNumber;

    private String testingPerson;

    private String technicalRequirements;

    private String testingResult;

    private String inspector;

    private Date inspecteDate;

    private String reason;

    private String responsibleDepartment;

    private String departmentLeader;

    private Date responsibleAnalyzeDate;

    private String technicalDepartmentOpinion;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public UnqualifiedProInfo(Integer id, String orderNum, String testingUnit, String testingProcess, Long productId, Integer testingNumber, Integer unqualifiedNumber, String testingPerson, String technicalRequirements, String testingResult, String inspector, Date inspecteDate, String reason, String responsibleDepartment, String departmentLeader, Date responsibleAnalyzeDate, String technicalDepartmentOpinion, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.orderNum = orderNum;
        this.testingUnit = testingUnit;
        this.testingProcess = testingProcess;
        this.productId = productId;
        this.testingNumber = testingNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.testingPerson = testingPerson;
        this.technicalRequirements = technicalRequirements;
        this.testingResult = testingResult;
        this.inspector = inspector;
        this.inspecteDate = inspecteDate;
        this.reason = reason;
        this.responsibleDepartment = responsibleDepartment;
        this.departmentLeader = departmentLeader;
        this.responsibleAnalyzeDate = responsibleAnalyzeDate;
        this.technicalDepartmentOpinion = technicalDepartmentOpinion;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public UnqualifiedProInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Date getInspecteDate() {
        return inspecteDate;
    }

    public void setInspecteDate(Date inspecteDate) {
        this.inspecteDate = inspecteDate;
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

    public Date getResponsibleAnalyzeDate() {
        return responsibleAnalyzeDate;
    }

    public void setResponsibleAnalyzeDate(Date responsibleAnalyzeDate) {
        this.responsibleAnalyzeDate = responsibleAnalyzeDate;
    }

    public String getTechnicalDepartmentOpinion() {
        return technicalDepartmentOpinion;
    }

    public void setTechnicalDepartmentOpinion(String technicalDepartmentOpinion) {
        this.technicalDepartmentOpinion = technicalDepartmentOpinion == null ? null : technicalDepartmentOpinion.trim();
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}