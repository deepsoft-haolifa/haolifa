package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowHistory {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer flowId;

    private Integer stepId;

    private Integer nextStepId;

    private Integer auditUserId;

    private String auditInfo;

    private Date auditTime;

    private String buyNo;

    private String orderNo;

    public FlowHistory(Integer id, Date createTime, Date updateTime, Integer createUser, Integer flowId, Integer stepId, Integer nextStepId, Integer auditUserId, String auditInfo, Date auditTime, String buyNo, String orderNo) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.flowId = flowId;
        this.stepId = stepId;
        this.nextStepId = nextStepId;
        this.auditUserId = auditUserId;
        this.auditInfo = auditInfo;
        this.auditTime = auditTime;
        this.buyNo = buyNo;
        this.orderNo = orderNo;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
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

    public String getBuyNo() {
        return buyNo;
    }

    public void setBuyNo(String buyNo) {
        this.buyNo = buyNo == null ? null : buyNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }
}