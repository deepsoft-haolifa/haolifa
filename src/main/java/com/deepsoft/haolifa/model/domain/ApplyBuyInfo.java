package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ApplyBuyInfo {
    private Integer id;

    private Integer flowId;

    private String productOrderNo;

    private String materialGraphNo;

    private Integer number;

    private String unit;

    private Integer valuation;

    private Byte state;

    private String remark;

    private String purpose;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    public ApplyBuyInfo(Integer id, Integer flowId, String productOrderNo, String materialGraphNo, Integer number, String unit, Integer valuation, Byte state, String remark, String purpose, Byte isDelete, Date createTime, Date updateTime, Long createUserId) {
        this.id = id;
        this.flowId = flowId;
        this.productOrderNo = productOrderNo;
        this.materialGraphNo = materialGraphNo;
        this.number = number;
        this.unit = unit;
        this.valuation = valuation;
        this.state = state;
        this.remark = remark;
        this.purpose = purpose;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public ApplyBuyInfo() {
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

    public String getProductOrderNo() {
        return productOrderNo;
    }

    public void setProductOrderNo(String productOrderNo) {
        this.productOrderNo = productOrderNo == null ? null : productOrderNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getValuation() {
        return valuation;
    }

    public void setValuation(Integer valuation) {
        this.valuation = valuation;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}