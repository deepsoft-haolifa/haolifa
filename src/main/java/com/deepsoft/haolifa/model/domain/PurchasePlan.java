package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PurchasePlan {
    private Integer id;

    private String purchasePlanNo;

    private String productOrderNo;

    private String materialGraphNo;

    private Integer number;

    private Date expectedTime;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Byte isDelete;

    public PurchasePlan(Integer id, String purchasePlanNo, String productOrderNo, String materialGraphNo, Integer number, Date expectedTime, Date createTime, Date updateTime, Integer createUserId, Byte isDelete) {
        this.id = id;
        this.purchasePlanNo = purchasePlanNo;
        this.productOrderNo = productOrderNo;
        this.materialGraphNo = materialGraphNo;
        this.number = number;
        this.expectedTime = expectedTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.isDelete = isDelete;
    }

    public PurchasePlan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchasePlanNo() {
        return purchasePlanNo;
    }

    public void setPurchasePlanNo(String purchasePlanNo) {
        this.purchasePlanNo = purchasePlanNo == null ? null : purchasePlanNo.trim();
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

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}