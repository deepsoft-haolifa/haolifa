package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowInstance {
    private Integer id;

    private String summary;

    private String formNo;

    private Integer formId;

    private Integer flowId;

    private Integer currentStepId;

    private String userId;

    private Integer roleId;

    private Byte isOver;

    private Byte isBack;

    private Integer createUserId;

    private Date createTime;

    private Date updateTime;

    public FlowInstance(Integer id, String summary, String formNo, Integer formId, Integer flowId, Integer currentStepId, String userId, Integer roleId, Byte isOver, Byte isBack, Integer createUserId, Date createTime, Date updateTime) {
        this.id = id;
        this.summary = summary;
        this.formNo = formNo;
        this.formId = formId;
        this.flowId = flowId;
        this.currentStepId = currentStepId;
        this.userId = userId;
        this.roleId = roleId;
        this.isOver = isOver;
        this.isBack = isBack;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public FlowInstance() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo == null ? null : formNo.trim();
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getCurrentStepId() {
        return currentStepId;
    }

    public void setCurrentStepId(Integer currentStepId) {
        this.currentStepId = currentStepId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Byte getIsOver() {
        return isOver;
    }

    public void setIsOver(Byte isOver) {
        this.isOver = isOver;
    }

    public Byte getIsBack() {
        return isBack;
    }

    public void setIsBack(Byte isBack) {
        this.isBack = isBack;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
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