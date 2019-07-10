package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class EntryOutStoreRecord {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String recordId;

    private String rackNo;

    private String orderNo;

    private String productNo;

    private String productModel;

    private String productSpecifications;

    private String materialBatchNo;

    private String materialGraphNo;

    private Byte operationType;

    private Byte type;

    private Integer quantity;

    private BigDecimal amount;

    private String productDepartment;

    private String customerNo;

    private String customerName;

    private String supplier;

    private String receiveDepartment;

    private BigDecimal price;

    private Byte status;

    private String remark;

    public EntryOutStoreRecord(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String recordId, String rackNo, String orderNo, String productNo, String productModel, String productSpecifications, String materialBatchNo, String materialGraphNo, Byte operationType, Byte type, Integer quantity, BigDecimal amount, String productDepartment, String customerNo, String customerName, String supplier, String receiveDepartment, BigDecimal price, Byte status, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.recordId = recordId;
        this.rackNo = rackNo;
        this.orderNo = orderNo;
        this.productNo = productNo;
        this.productModel = productModel;
        this.productSpecifications = productSpecifications;
        this.materialBatchNo = materialBatchNo;
        this.materialGraphNo = materialGraphNo;
        this.operationType = operationType;
        this.type = type;
        this.quantity = quantity;
        this.amount = amount;
        this.productDepartment = productDepartment;
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.supplier = supplier;
        this.receiveDepartment = receiveDepartment;
        this.price = price;
        this.status = status;
        this.remark = remark;
    }

    public EntryOutStoreRecord() {
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

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo == null ? null : rackNo.trim();
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

    public String getProductDepartment() {
        return productDepartment;
    }

    public void setProductDepartment(String productDepartment) {
        this.productDepartment = productDepartment == null ? null : productDepartment.trim();
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getReceiveDepartment() {
        return receiveDepartment;
    }

    public void setReceiveDepartment(String receiveDepartment) {
        this.receiveDepartment = receiveDepartment == null ? null : receiveDepartment.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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