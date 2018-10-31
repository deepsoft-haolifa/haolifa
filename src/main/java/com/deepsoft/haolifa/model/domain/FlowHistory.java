package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowHistory {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer instanceId;

    private Integer stepId;

    private Integer auditUserId;

    private String auditInfo;

    private Date auditTime;

    private Byte auditResult;

    private Byte formType;

    private Integer formId;

    private String formNo;

    public FlowHistory(Integer id, Date createTime, Date updateTime, Integer instanceId, Integer stepId, Integer auditUserId, String auditInfo, Date auditTime, Byte auditResult, Byte formType, Integer formId, String formNo) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.instanceId = instanceId;
        this.stepId = stepId;
        this.auditUserId = auditUserId;
        this.auditInfo = auditInfo;
        this.auditTime = auditTime;
        this.auditResult = auditResult;
        this.formType = formType;
        this.formId = formId;
        this.formNo = formNo;
    }

    public FlowHistory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo == null ? null : auditInfo.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Byte getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Byte auditResult) {
        this.auditResult = auditResult;
    }

    public Byte getFormType() {
        return formType;
    }

    public void setFormType(Byte formType) {
        this.formType = formType;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo == null ? null : formNo.trim();
    }
}