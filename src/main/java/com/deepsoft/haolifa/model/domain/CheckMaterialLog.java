package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class CheckMaterialLog {
    private Integer id;

    private Date createTime;

    private Integer checkUserId;

    private String orderNo;

    private String materialGraphNo;

    private Integer currentMaterialCount;

    private Integer needMaterialCount;

    private String checkState;

    private String checkResult;

    public CheckMaterialLog(Integer id, Date createTime, Integer checkUserId, String orderNo, String materialGraphNo, Integer currentMaterialCount, Integer needMaterialCount, String checkState, String checkResult) {
        this.id = id;
        this.createTime = createTime;
        this.checkUserId = checkUserId;
        this.orderNo = orderNo;
        this.materialGraphNo = materialGraphNo;
        this.currentMaterialCount = currentMaterialCount;
        this.needMaterialCount = needMaterialCount;
        this.checkState = checkState;
        this.checkResult = checkResult;
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

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Integer getCurrentMaterialCount() {
        return currentMaterialCount;
    }

    public void setCurrentMaterialCount(Integer currentMaterialCount) {
        this.currentMaterialCount = currentMaterialCount;
    }

    public Integer getNeedMaterialCount() {
        return needMaterialCount;
    }

    public void setNeedMaterialCount(Integer needMaterialCount) {
        this.needMaterialCount = needMaterialCount;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }
}