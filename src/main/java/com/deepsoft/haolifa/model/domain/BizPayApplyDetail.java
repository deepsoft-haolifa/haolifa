package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizPayApplyDetail {
    private Integer id;

    private Long payApplyId;

    private BigDecimal price;

    private Integer purchaseOrderId;

    private String purchaseOrderNo;

    private String payType;

    private String applyPayCompany;

    private String applyCollectionCompany;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizPayApplyDetail(Integer id, Long payApplyId, BigDecimal price, Integer purchaseOrderId, String purchaseOrderNo, String payType, String applyPayCompany, String applyCollectionCompany, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.payApplyId = payApplyId;
        this.price = price;
        this.purchaseOrderId = purchaseOrderId;
        this.purchaseOrderNo = purchaseOrderNo;
        this.payType = payType;
        this.applyPayCompany = applyPayCompany;
        this.applyCollectionCompany = applyCollectionCompany;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizPayApplyDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPayApplyId() {
        return payApplyId;
    }

    public void setPayApplyId(Long payApplyId) {
        this.payApplyId = payApplyId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getApplyPayCompany() {
        return applyPayCompany;
    }

    public void setApplyPayCompany(String applyPayCompany) {
        this.applyPayCompany = applyPayCompany == null ? null : applyPayCompany.trim();
    }

    public String getApplyCollectionCompany() {
        return applyCollectionCompany;
    }

    public void setApplyCollectionCompany(String applyCollectionCompany) {
        this.applyCollectionCompany = applyCollectionCompany == null ? null : applyCollectionCompany.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}