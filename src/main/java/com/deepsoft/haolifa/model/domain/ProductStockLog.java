package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProductStockLog {
    private Integer id;

    private String orderNo;

    private Integer entryOutRecordId;

    private String productNo;

    private String productModel;

    private String name;

    private String specifications;

    private Integer qty;

    private String remark;

    private Date createTime;

    private Integer createUser;

    public ProductStockLog(Integer id, String orderNo, Integer entryOutRecordId, String productNo, String productModel, String name, String specifications, Integer qty, String remark, Date createTime, Integer createUser) {
        this.id = id;
        this.orderNo = orderNo;
        this.entryOutRecordId = entryOutRecordId;
        this.productNo = productNo;
        this.productModel = productModel;
        this.name = name;
        this.specifications = specifications;
        this.qty = qty;
        this.remark = remark;
        this.createTime = createTime;
        this.createUser = createUser;
    }

    public ProductStockLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getEntryOutRecordId() {
        return entryOutRecordId;
    }

    public void setEntryOutRecordId(Integer entryOutRecordId) {
        this.entryOutRecordId = entryOutRecordId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
}