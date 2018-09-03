package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Stock {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String stockId;

    private Integer storeRoomId;

    private Integer storeRoomRackId;

    private String storeRoomRackNo;

    private String productNo;

    private String materialGraphNo;

    private Byte type;

    private Integer quantity;

    private Integer lockQuantity;

    private Byte isDelete;

    private String remark;

    public Stock(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String stockId, Integer storeRoomId, Integer storeRoomRackId, String storeRoomRackNo, String productNo, String materialGraphNo, Byte type, Integer quantity, Integer lockQuantity, Byte isDelete, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.stockId = stockId;
        this.storeRoomId = storeRoomId;
        this.storeRoomRackId = storeRoomRackId;
        this.storeRoomRackNo = storeRoomRackNo;
        this.productNo = productNo;
        this.materialGraphNo = materialGraphNo;
        this.type = type;
        this.quantity = quantity;
        this.lockQuantity = lockQuantity;
        this.isDelete = isDelete;
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

    public Integer getStoreRoomId() {
        return storeRoomId;
    }

    public void setStoreRoomId(Integer storeRoomId) {
        this.storeRoomId = storeRoomId;
    }

    public Integer getStoreRoomRackId() {
        return storeRoomRackId;
    }

    public void setStoreRoomRackId(Integer storeRoomRackId) {
        this.storeRoomRackId = storeRoomRackId;
    }

    public String getStoreRoomRackNo() {
        return storeRoomRackNo;
    }

    public void setStoreRoomRackNo(String storeRoomRackNo) {
        this.storeRoomRackNo = storeRoomRackNo == null ? null : storeRoomRackNo.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLockQuantity() {
        return lockQuantity;
    }

    public void setLockQuantity(Integer lockQuantity) {
        this.lockQuantity = lockQuantity;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}