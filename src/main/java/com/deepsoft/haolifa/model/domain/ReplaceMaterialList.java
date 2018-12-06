package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ReplaceMaterialList {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String orderNo;

    private String materialGraphNo;

    private String materialName;

    private String materialUnit;

    private Integer materialCount;

    private String replaceReason;

    private String responsiblePerson;

    private Integer auditUserId;

    private String auditInfo;

    private Date auditTime;

    private Byte auditResult;

    private String remark;

    public ReplaceMaterialList(Integer id, Date createTime, Date updateTime, String orderNo, String materialGraphNo, String materialName, String materialUnit, Integer materialCount, String replaceReason, String responsiblePerson, Integer auditUserId, String auditInfo, Date auditTime, Byte auditResult, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.orderNo = orderNo;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.materialUnit = materialUnit;
        this.materialCount = materialCount;
        this.replaceReason = replaceReason;
        this.responsiblePerson = responsiblePerson;
        this.auditUserId = auditUserId;
        this.auditInfo = auditInfo;
        this.auditTime = auditTime;
        this.auditResult = auditResult;
        this.remark = remark;
    }

    public ReplaceMaterialList() {
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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit == null ? null : materialUnit.trim();
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }

    public String getReplaceReason() {
        return replaceReason;
    }

    public void setReplaceReason(String replaceReason) {
        this.replaceReason = replaceReason == null ? null : replaceReason.trim();
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson == null ? null : responsiblePerson.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}