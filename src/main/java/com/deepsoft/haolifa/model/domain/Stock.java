package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Stock {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String stockId;

    private String storeRoomRackId;

    private String storeRoomRackPositionNo;

    private String productNo;

    private Integer materialId;

    private String materialGraphNo;

    private Integer quantity;

    private Integer safeQuantity;

    private String safetyFactor;

    private BigDecimal price;

    private String remark;

    public Stock(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String stockId, String storeRoomRackId, String storeRoomRackPositionNo, String productNo, Integer materialId, String materialGraphNo, Integer quantity, Integer safeQuantity, String safetyFactor, BigDecimal price, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.stockId = stockId;
        this.storeRoomRackId = storeRoomRackId;
        this.storeRoomRackPositionNo = storeRoomRackPositionNo;
        this.productNo = productNo;
        this.materialId = materialId;
        this.materialGraphNo = materialGraphNo;
        this.quantity = quantity;
        this.safeQuantity = safeQuantity;
        this.safetyFactor = safetyFactor;
        this.price = price;
        this.remark = remark;
    }

    public Stock() {
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

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getStoreRoomRackId() {
        return storeRoomRackId;
    }

    public void setStoreRoomRackId(String storeRoomRackId) {
        this.storeRoomRackId = storeRoomRackId == null ? null : storeRoomRackId.trim();
    }

    public String getStoreRoomRackPositionNo() {
        return storeRoomRackPositionNo;
    }

    public void setStoreRoomRackPositionNo(String storeRoomRackPositionNo) {
        this.storeRoomRackPositionNo = storeRoomRackPositionNo == null ? null : storeRoomRackPositionNo.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSafeQuantity() {
        return safeQuantity;
    }

    public void setSafeQuantity(Integer safeQuantity) {
        this.safeQuantity = safeQuantity;
    }

    public String getSafetyFactor() {
        return safetyFactor;
    }

    public void setSafetyFactor(String safetyFactor) {
        this.safetyFactor = safetyFactor == null ? null : safetyFactor.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}