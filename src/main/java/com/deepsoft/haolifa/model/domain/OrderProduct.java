package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderProduct {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String orderNo;

    private Byte orderStatus;

    private String demandName;

    private String demandAgentName;

    private String demandTelphone;

    private String demandFax;

    private String demandAddress;

    private String supplyName;

    private String supplyAgentName;

    private String supplyTelphone;

    private String supplyFax;

    private String supplyAddress;

    private String contractNumber;

    private String contractSignDate;

    private String productNo;

    private String productName;

    private String productModel;

    private String lable;

    private String specifications;

    private String productColor;

    private Integer productNumber;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private BigDecimal discountTotalPrice;

    private String materialDescription;

    private String productRemark;

    private String purchaseFeedbackTime;

    private String productionFeedbackTime;

    private String specialRequire;

    private String cargoInformation;

    private String signBoard;

    private String acceptanceCriteria;

    private String warrantyPeriod;

    private String packagingspecification;

    private String transportType;

    private String deliveryTime;

    private String receiptInfo;

    private String paymentMethod;

    private String freight;

    public OrderProduct(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String orderNo, Byte orderStatus, String demandName, String demandAgentName, String demandTelphone, String demandFax, String demandAddress, String supplyName, String supplyAgentName, String supplyTelphone, String supplyFax, String supplyAddress, String contractNumber, String contractSignDate, String productNo, String productName, String productModel, String lable, String specifications, String productColor, Integer productNumber, BigDecimal price, BigDecimal totalPrice, BigDecimal discountTotalPrice, String materialDescription, String productRemark, String purchaseFeedbackTime, String productionFeedbackTime, String specialRequire, String cargoInformation, String signBoard, String acceptanceCriteria, String warrantyPeriod, String packagingspecification, String transportType, String deliveryTime, String receiptInfo, String paymentMethod, String freight) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.orderNo = orderNo;
        this.orderStatus = orderStatus;
        this.demandName = demandName;
        this.demandAgentName = demandAgentName;
        this.demandTelphone = demandTelphone;
        this.demandFax = demandFax;
        this.demandAddress = demandAddress;
        this.supplyName = supplyName;
        this.supplyAgentName = supplyAgentName;
        this.supplyTelphone = supplyTelphone;
        this.supplyFax = supplyFax;
        this.supplyAddress = supplyAddress;
        this.contractNumber = contractNumber;
        this.contractSignDate = contractSignDate;
        this.productNo = productNo;
        this.productName = productName;
        this.productModel = productModel;
        this.lable = lable;
        this.specifications = specifications;
        this.productColor = productColor;
        this.productNumber = productNumber;
        this.price = price;
        this.totalPrice = totalPrice;
        this.discountTotalPrice = discountTotalPrice;
        this.materialDescription = materialDescription;
        this.productRemark = productRemark;
        this.purchaseFeedbackTime = purchaseFeedbackTime;
        this.productionFeedbackTime = productionFeedbackTime;
        this.specialRequire = specialRequire;
        this.cargoInformation = cargoInformation;
        this.signBoard = signBoard;
        this.acceptanceCriteria = acceptanceCriteria;
        this.warrantyPeriod = warrantyPeriod;
        this.packagingspecification = packagingspecification;
        this.transportType = transportType;
        this.deliveryTime = deliveryTime;
        this.receiptInfo = receiptInfo;
        this.paymentMethod = paymentMethod;
        this.freight = freight;
    }

    public OrderProduct() {
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

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName == null ? null : demandName.trim();
    }

    public String getDemandAgentName() {
        return demandAgentName;
    }

    public void setDemandAgentName(String demandAgentName) {
        this.demandAgentName = demandAgentName == null ? null : demandAgentName.trim();
    }

    public String getDemandTelphone() {
        return demandTelphone;
    }

    public void setDemandTelphone(String demandTelphone) {
        this.demandTelphone = demandTelphone == null ? null : demandTelphone.trim();
    }

    public String getDemandFax() {
        return demandFax;
    }

    public void setDemandFax(String demandFax) {
        this.demandFax = demandFax == null ? null : demandFax.trim();
    }

    public String getDemandAddress() {
        return demandAddress;
    }

    public void setDemandAddress(String demandAddress) {
        this.demandAddress = demandAddress == null ? null : demandAddress.trim();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName == null ? null : supplyName.trim();
    }

    public String getSupplyAgentName() {
        return supplyAgentName;
    }

    public void setSupplyAgentName(String supplyAgentName) {
        this.supplyAgentName = supplyAgentName == null ? null : supplyAgentName.trim();
    }

    public String getSupplyTelphone() {
        return supplyTelphone;
    }

    public void setSupplyTelphone(String supplyTelphone) {
        this.supplyTelphone = supplyTelphone == null ? null : supplyTelphone.trim();
    }

    public String getSupplyFax() {
        return supplyFax;
    }

    public void setSupplyFax(String supplyFax) {
        this.supplyFax = supplyFax == null ? null : supplyFax.trim();
    }

    public String getSupplyAddress() {
        return supplyAddress;
    }

    public void setSupplyAddress(String supplyAddress) {
        this.supplyAddress = supplyAddress == null ? null : supplyAddress.trim();
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

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription == null ? null : materialDescription.trim();
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
    }

    public String getPurchaseFeedbackTime() {
        return purchaseFeedbackTime;
    }

    public void setPurchaseFeedbackTime(String purchaseFeedbackTime) {
        this.purchaseFeedbackTime = purchaseFeedbackTime == null ? null : purchaseFeedbackTime.trim();
    }

    public String getProductionFeedbackTime() {
        return productionFeedbackTime;
    }

    public void setProductionFeedbackTime(String productionFeedbackTime) {
        this.productionFeedbackTime = productionFeedbackTime == null ? null : productionFeedbackTime.trim();
    }

    public String getSpecialRequire() {
        return specialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        this.specialRequire = specialRequire == null ? null : specialRequire.trim();
    }

    public String getCargoInformation() {
        return cargoInformation;
    }

    public void setCargoInformation(String cargoInformation) {
        this.cargoInformation = cargoInformation == null ? null : cargoInformation.trim();
    }

    public String getSignBoard() {
        return signBoard;
    }

    public void setSignBoard(String signBoard) {
        this.signBoard = signBoard == null ? null : signBoard.trim();
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria == null ? null : acceptanceCriteria.trim();
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod == null ? null : warrantyPeriod.trim();
    }

    public String getPackagingspecification() {
        return packagingspecification;
    }

    public void setPackagingspecification(String packagingspecification) {
        this.packagingspecification = packagingspecification == null ? null : packagingspecification.trim();
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType == null ? null : transportType.trim();
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight == null ? null : freight.trim();
    }
}