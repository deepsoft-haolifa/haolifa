package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ValveSeatInspectHistory {
    private Integer id;

    private Integer valveSeatId;

    private String no;

    private String materialGraphNo;

    private String materialGraphName;

    private Integer testNumber;

    private Integer qualifiedNumber;

    private Integer unqualifiedNumber;

    private String handlingSuggestion;

    private String remark;

    private Byte status;

    private String reasons;

    private String accessory;

    private Date createTime;

    private Date updateTime;

    public ValveSeatInspectHistory(Integer id, Integer valveSeatId, String no, String materialGraphNo, String materialGraphName, Integer testNumber, Integer qualifiedNumber, Integer unqualifiedNumber, String handlingSuggestion, String remark, Byte status, String reasons, String accessory, Date createTime, Date updateTime) {
        this.id = id;
        this.valveSeatId = valveSeatId;
        this.no = no;
        this.materialGraphNo = materialGraphNo;
        this.materialGraphName = materialGraphName;
        this.testNumber = testNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.handlingSuggestion = handlingSuggestion;
        this.remark = remark;
        this.status = status;
        this.reasons = reasons;
        this.accessory = accessory;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ValveSeatInspectHistory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValveSeatId() {
        return valveSeatId;
    }

    public void setValveSeatId(Integer valveSeatId) {
        this.valveSeatId = valveSeatId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getMaterialGraphName() {
        return materialGraphName;
    }

    public void setMaterialGraphName(String materialGraphName) {
        this.materialGraphName = materialGraphName == null ? null : materialGraphName.trim();
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public String getHandlingSuggestion() {
        return handlingSuggestion;
    }

    public void setHandlingSuggestion(String handlingSuggestion) {
        this.handlingSuggestion = handlingSuggestion == null ? null : handlingSuggestion.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons == null ? null : reasons.trim();
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory == null ? null : accessory.trim();
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