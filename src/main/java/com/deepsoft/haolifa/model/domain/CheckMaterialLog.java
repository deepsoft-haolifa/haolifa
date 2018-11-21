package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class CheckMaterialLog {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer checkUserId;

    private String orderNo;

    private String checkResult;

    private String checkState;

    public CheckMaterialLog(Integer id, Date createTime, Date updateTime, Integer checkUserId, String orderNo, String checkResult, String checkState) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.checkUserId = checkUserId;
        this.orderNo = orderNo;
        this.checkResult = checkResult;
        this.checkState = checkState;
    }

    public CheckMaterialLog() {
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

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }
}