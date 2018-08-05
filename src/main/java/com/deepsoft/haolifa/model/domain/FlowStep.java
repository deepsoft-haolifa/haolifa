package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowStep {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private Integer flowId;

    private Integer stepId;

    private Integer nextStepId;

    private Integer preStepId;

    private Integer gotoStepId;

    private Integer stepOrder;

    public FlowStep(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, Integer flowId, Integer stepId, Integer nextStepId, Integer preStepId, Integer gotoStepId, Integer stepOrder) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.flowId = flowId;
        this.stepId = stepId;
        this.nextStepId = nextStepId;
        this.preStepId = preStepId;
        this.gotoStepId = gotoStepId;
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

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Integer getNextStepId() {
        return nextStepId;
    }

    public void setNextStepId(Integer nextStepId) {
        this.nextStepId = nextStepId;
    }

    public Integer getPreStepId() {
        return preStepId;
    }

    public void setPreStepId(Integer preStepId) {
        this.preStepId = preStepId;
    }

    public Integer getGotoStepId() {
        return gotoStepId;
    }

    public void setGotoStepId(Integer gotoStepId) {
        this.gotoStepId = gotoStepId;
    }

    public Integer getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(Integer stepOrder) {
        this.stepOrder = stepOrder;
    }
}