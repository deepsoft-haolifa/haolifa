package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowStep {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private Integer flowId;

    private Integer forkFlow;

    private String forkCondition;

    private Integer stepId;

    private Integer orderStep;

    public FlowStep(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, Integer flowId, Integer forkFlow, String forkCondition, Integer stepId, Integer orderStep) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.flowId = flowId;
        this.forkFlow = forkFlow;
        this.forkCondition = forkCondition;
        this.stepId = stepId;
        this.orderStep = orderStep;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getForkFlow() {
        return forkFlow;
    }

    public void setForkFlow(Integer forkFlow) {
        this.forkFlow = forkFlow;
    }

    public String getForkCondition() {
        return forkCondition;
    }

    public void setForkCondition(String forkCondition) {
        this.forkCondition = forkCondition == null ? null : forkCondition.trim();
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }
}