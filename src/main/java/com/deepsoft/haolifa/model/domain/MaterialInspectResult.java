package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class MaterialInspectResult {
    private Integer id;

    private Integer flowId;

    private String inspectNo;

    private String materialGraphNo;

    private String materialName;

    private Integer inspectNumber;

    private Integer unqualifiedNumber;

    private String handlingResult;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public MaterialInspectResult(Integer id, Integer flowId, String inspectNo, String materialGraphNo, String materialName, Integer inspectNumber, Integer unqualifiedNumber, String handlingResult, Byte isDelete, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.flowId = flowId;
        this.inspectNo = inspectNo;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.inspectNumber = inspectNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.handlingResult = handlingResult;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public MaterialInspectResult() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getInspectNo() {
        return inspectNo;
    }

    public void setInspectNo(String inspectNo) {
        this.inspectNo = inspectNo == null ? null : inspectNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public Integer getInspectNumber() {
        return inspectNumber;
    }

    public void setInspectNumber(Integer inspectNumber) {
        this.inspectNumber = inspectNumber;
    }

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public String getHandlingResult() {
        return handlingResult;
    }

    public void setHandlingResult(String handlingResult) {
        this.handlingResult = handlingResult == null ? null : handlingResult.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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