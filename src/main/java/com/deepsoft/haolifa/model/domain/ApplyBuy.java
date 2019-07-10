package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ApplyBuy {
    private Integer id;

    private String applyBuyNo;

    private String productOrderNo;

    private Integer purchaseNumber;

    private Date arrivalTime;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private String materialGraphNo;

    private String materialName;

    private Byte status;

    private Integer dealUserId;

    public ApplyBuy(Integer id, String applyBuyNo, String productOrderNo, Integer purchaseNumber, Date arrivalTime, Date createTime, Date updateTime, Integer createUserId, String materialGraphNo, String materialName, Byte status, Integer dealUserId) {
        this.id = id;
        this.applyBuyNo = applyBuyNo;
        this.productOrderNo = productOrderNo;
        this.purchaseNumber = purchaseNumber;
        this.arrivalTime = arrivalTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.status = status;
        this.dealUserId = dealUserId;
    }

    public ApplyBuy() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyBuyNo() {
        return applyBuyNo;
    }

    public void setApplyBuyNo(String applyBuyNo) {
        this.applyBuyNo = applyBuyNo == null ? null : applyBuyNo.trim();
    }

    public String getProductOrderNo() {
        return productOrderNo;
    }

    public void setProductOrderNo(String productOrderNo) {
        this.productOrderNo = productOrderNo == null ? null : productOrderNo.trim();
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }
}