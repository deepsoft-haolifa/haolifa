package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String orderNo;

    private String productNo;

    private Byte orderStatus;

    private String productName;

    private String productModel;

    private String lable;

    private String specifications;

    private String color;

    private String number;

    private String materialDescription;

    private String remark;

    private Byte repaymentType;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private BigDecimal discountTotalPrice;

    private String demandSide;

    private String supplySide;

    private String contractNumber;

    private String contractSignDate;

    private String specialRequire;

    private String warrantyPeriod;

    private String deliveryTime;

    private String receiptInfo;

    private String transportType;

    public Order(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String orderNo, String productNo, Byte orderStatus, String productName, String productModel, String lable, String specifications, String color, String number, String materialDescription, String remark, Byte repaymentType, BigDecimal price, BigDecimal totalPrice, BigDecimal discountTotalPrice, String demandSide, String supplySide, String contractNumber, String contractSignDate, String specialRequire, String warrantyPeriod, String deliveryTime, String receiptInfo, String transportType) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.orderNo = orderNo;
        this.productNo = productNo;
        this.orderStatus = orderStatus;
        this.productName = productName;
        this.productModel = productModel;
        this.lable = lable;
        this.specifications = specifications;
        this.color = color;
        this.number = number;
        this.materialDescription = materialDescription;
        this.remark = remark;
        this.repaymentType = repaymentType;
        this.price = price;
        this.totalPrice = totalPrice;
        this.discountTotalPrice = discountTotalPrice;
        this.demandSide = demandSide;
        this.supplySide = supplySide;
        this.contractNumber = contractNumber;
        this.contractSignDate = contractSignDate;
        this.specialRequire = specialRequire;
        this.warrantyPeriod = warrantyPeriod;
        this.deliveryTime = deliveryTime;
        this.receiptInfo = receiptInfo;
        this.transportType = transportType;
    }

    public Order() {
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

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription == null ? null : materialDescription.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(Byte repaymentType) {
        this.repaymentType = repaymentType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDiscountTotalPrice() {
        return discountTotalPrice;
    }

    public void setDiscountTotalPrice(BigDecimal discountTotalPrice) {
        this.discountTotalPrice = discountTotalPrice;
    }

    public String getDemandSide() {
        return demandSide;
    }

    public void setDemandSide(String demandSide) {
        this.demandSide = demandSide == null ? null : demandSide.trim();
    }

    public String getSupplySide() {
        return supplySide;
    }

    public void setSupplySide(String supplySide) {
        this.supplySide = supplySide == null ? null : supplySide.trim();
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate == null ? null : contractSignDate.trim();
    }

    public String getSpecialRequire() {
        return specialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        this.specialRequire = specialRequire == null ? null : specialRequire.trim();
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod == null ? null : warrantyPeriod.trim();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public String getReceiptInfo() {
        return receiptInfo;
    }

    public void setReceiptInfo(String receiptInfo) {
        this.receiptInfo = receiptInfo == null ? null : receiptInfo.trim();
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType == null ? null : transportType.trim();
    }
}