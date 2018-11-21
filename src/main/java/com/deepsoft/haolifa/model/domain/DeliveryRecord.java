package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class DeliveryRecord {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private String deliveryNo;

    private String orderNo;

    private String customerNo;

    private String deliveryTime;

    private String collectAddress;

    private String collectName;

    private String collectPhone;

    private String productNo;

    private String productName;

    private String productModel;

    private String lable;

    private String specifications;

    private String productColor;

    private Integer productNumber;

    private String productRemark;

    private String transportType;

    private String freight;

    private String isDelivery;

    private String remark;

    public DeliveryRecord(Integer id, Date createTime, Date updateTime, Integer createUserId, String deliveryNo, String orderNo, String customerNo, String deliveryTime, String collectAddress, String collectName, String collectPhone, String productNo, String productName, String productModel, String lable, String specifications, String productColor, Integer productNumber, String productRemark, String transportType, String freight, String isDelivery, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.deliveryNo = deliveryNo;
        this.orderNo = orderNo;
        this.customerNo = customerNo;
        this.deliveryTime = deliveryTime;
        this.collectAddress = collectAddress;
        this.collectName = collectName;
        this.collectPhone = collectPhone;
        this.productNo = productNo;
        this.productName = productName;
        this.productModel = productModel;
        this.lable = lable;
        this.specifications = specifications;
        this.productColor = productColor;
        this.productNumber = productNumber;
        this.productRemark = productRemark;
        this.transportType = transportType;
        this.freight = freight;
        this.isDelivery = isDelivery;
        this.remark = remark;
    }

    public DeliveryRecord() {
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo == null ? null : deliveryNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public String getCollectAddress() {
        return collectAddress;
    }

    public void setCollectAddress(String collectAddress) {
        this.collectAddress = collectAddress == null ? null : collectAddress.trim();
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName == null ? null : collectName.trim();
    }

    public String getCollectPhone() {
        return collectPhone;
    }

    public void setCollectPhone(String collectPhone) {
        this.collectPhone = collectPhone == null ? null : collectPhone.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor == null ? null : productColor.trim();
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType == null ? null : transportType.trim();
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight == null ? null : freight.trim();
    }

    public String getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(String isDelivery) {
        this.isDelivery = isDelivery == null ? null : isDelivery.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}