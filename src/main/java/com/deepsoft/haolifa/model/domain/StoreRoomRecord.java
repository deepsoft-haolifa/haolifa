package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class StoreRoomRecord {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String recordId;

    private String orderNo;

    private String productNo;

    private Integer materialId;

    private String materialGraphNo;

    private Byte operationType;

    private Byte type;

    private Integer quantity;

    private BigDecimal amount;

    private Integer storeRoomRackId;

    private String productDepartment;

    private Byte status;

    private String remark;

    public StoreRoomRecord(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String recordId, String orderNo, String productNo, Integer materialId, String materialGraphNo, Byte operationType, Byte type, Integer quantity, BigDecimal amount, Integer storeRoomRackId, String productDepartment, Byte status, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.recordId = recordId;
        this.orderNo = orderNo;
        this.productNo = productNo;
        this.materialId = materialId;
        this.materialGraphNo = materialGraphNo;
        this.operationType = operationType;
        this.type = type;
        this.quantity = quantity;
        this.amount = amount;
        this.storeRoomRackId = storeRoomRackId;
        this.productDepartment = productDepartment;
        this.status = status;
        this.remark = remark;
    }

    public StoreRoomRecord() {
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public Byte getOperationType() {
        return operationType;
    }

    public void setOperationType(Byte operationType) {
        this.operationType = operationType;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStoreRoomRackId() {
        return storeRoomRackId;
    }

    public void setStoreRoomRackId(Integer storeRoomRackId) {
        this.storeRoomRackId = storeRoomRackId;
    }

    public String getProductDepartment() {
        return productDepartment;
    }

    public void setProductDepartment(String productDepartment) {
        this.productDepartment = productDepartment == null ? null : productDepartment.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}