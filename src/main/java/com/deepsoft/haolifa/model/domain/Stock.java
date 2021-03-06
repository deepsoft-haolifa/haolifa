package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Stock {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String roomNo;

    private String rackNo;

    private String productNo;

    private String productModel;

    private String productSpecifications;

    private String materialBatchNo;

    private String materialGraphNo;

    private Byte type;

    private Integer quantity;

    private Integer version;

    private Byte isDelete;

    private String remark;

    public Stock(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String roomNo, String rackNo, String productNo, String productModel, String productSpecifications, String materialBatchNo, String materialGraphNo, Byte type, Integer quantity, Integer version, Byte isDelete, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.roomNo = roomNo;
        this.rackNo = rackNo;
        this.productNo = productNo;
        this.productModel = productModel;
        this.productSpecifications = productSpecifications;
        this.materialBatchNo = materialBatchNo;
        this.materialGraphNo = materialGraphNo;
        this.type = type;
        this.quantity = quantity;
        this.version = version;
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

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo == null ? null : rackNo.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(String productSpecifications) {
        this.productSpecifications = productSpecifications == null ? null : productSpecifications.trim();
    }

    public String getMaterialBatchNo() {
        return materialBatchNo;
    }

    public void setMaterialBatchNo(String materialBatchNo) {
        this.materialBatchNo = materialBatchNo == null ? null : materialBatchNo.trim();
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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