package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowStep {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Integer flowId;

    private Integer stepId;

    private String userId;

    private Integer roleId;

    private Integer prevStepId;

    private Integer conditionTrue;

    private Integer conditionFalse;

    private String formShowStepId;

    private Integer stepOrder;

    public FlowStep(Integer id, Date createTime, Date updateTime, Integer createUserId, Integer flowId, Integer stepId, String userId, Integer roleId, Integer prevStepId, Integer conditionTrue, Integer conditionFalse, String formShowStepId, Integer stepOrder) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.flowId = flowId;
        this.stepId = stepId;
        this.userId = userId;
        this.roleId = roleId;
        this.prevStepId = prevStepId;
        this.conditionTrue = conditionTrue;
        this.conditionFalse = conditionFalse;
        this.formShowStepId = formShowStepId;
        this.stepOrder = stepOrder;
    }

    public FlowStep() {
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
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

    public Integer getPrevStepId() {
        return prevStepId;
    }

    public void setPrevStepId(Integer prevStepId) {
        this.prevStepId = prevStepId;
    }

    public Integer getConditionTrue() {
        return conditionTrue;
    }

    public void setConditionTrue(Integer conditionTrue) {
        this.conditionTrue = conditionTrue;
    }

    public Integer getConditionFalse() {
        return conditionFalse;
    }

    public void setConditionFalse(Integer conditionFalse) {
        this.conditionFalse = conditionFalse;
    }

    public String getFormShowStepId() {
        return formShowStepId;
    }

    public void setFormShowStepId(String formShowStepId) {
        this.formShowStepId = formShowStepId == null ? null : formShowStepId.trim();
    }

    public Integer getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(Integer stepOrder) {
        this.stepOrder = stepOrder;
    }
}