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

    private String orderContractNo;

    private Byte orderStatus;

    private String orderContractUrl;

    private String orderContractExtendUrl;

    private String technicalRequire;

    private String finishFeedbackTime;

    private String feedbackTimeConfirmUser;

    private String purchaseFeedbackTime;

    private String productionFeedbackTime;

    private String assemblyShop;

    private String assemblyGroup;

    private String demandName;

    private String demandAgentName;

    private String demandPhone;

    private String demandFax;

    private String demandBankName;

    private String demandBankCardNo;

    private String supplyName;

    private String supplyAgentName;

    private String supplyPhone;

    private String supplyFax;

    private String supplyBankName;

    private String contractBankCardNo;

    private String deliveryPlace;

    private String deliveryDate;

    private String contractSignDate;

    private Integer totalCount;

    private BigDecimal discountTotalPrice;

    private BigDecimal totalPrice;

    private String specialRequire;

    private String cargoInformation;

    private String signBoard;

    private String acceptanceCriteria;

    private String warrantyPeriod;

    private String packagingSpecification;

    private String remark;

    private Byte deliverStatus;

    private String accessory;

    public OrderProduct(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String orderNo, String orderContractNo, Byte orderStatus, String orderContractUrl, String orderContractExtendUrl, String technicalRequire, String finishFeedbackTime, String feedbackTimeConfirmUser, String purchaseFeedbackTime, String productionFeedbackTime, String assemblyShop, String assemblyGroup, String demandName, String demandAgentName, String demandPhone, String demandFax, String demandBankName, String demandBankCardNo, String supplyName, String supplyAgentName, String supplyPhone, String supplyFax, String supplyBankName, String contractBankCardNo, String deliveryPlace, String deliveryDate, String contractSignDate, Integer totalCount, BigDecimal discountTotalPrice, BigDecimal totalPrice, String specialRequire, String cargoInformation, String signBoard, String acceptanceCriteria, String warrantyPeriod, String packagingSpecification, String remark, Byte deliverStatus, String accessory) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.orderNo = orderNo;
        this.orderContractNo = orderContractNo;
        this.orderStatus = orderStatus;
        this.orderContractUrl = orderContractUrl;
        this.orderContractExtendUrl = orderContractExtendUrl;
        this.technicalRequire = technicalRequire;
        this.finishFeedbackTime = finishFeedbackTime;
        this.feedbackTimeConfirmUser = feedbackTimeConfirmUser;
        this.purchaseFeedbackTime = purchaseFeedbackTime;
        this.productionFeedbackTime = productionFeedbackTime;
        this.assemblyShop = assemblyShop;
        this.assemblyGroup = assemblyGroup;
        this.demandName = demandName;
        this.demandAgentName = demandAgentName;
        this.demandPhone = demandPhone;
        this.demandFax = demandFax;
        this.demandBankName = demandBankName;
        this.demandBankCardNo = demandBankCardNo;
        this.supplyName = supplyName;
        this.supplyAgentName = supplyAgentName;
        this.supplyPhone = supplyPhone;
        this.supplyFax = supplyFax;
        this.supplyBankName = supplyBankName;
        this.contractBankCardNo = contractBankCardNo;
        this.deliveryPlace = deliveryPlace;
        this.deliveryDate = deliveryDate;
        this.contractSignDate = contractSignDate;
        this.totalCount = totalCount;
        this.discountTotalPrice = discountTotalPrice;
        this.totalPrice = totalPrice;
        this.specialRequire = specialRequire;
        this.cargoInformation = cargoInformation;
        this.signBoard = signBoard;
        this.acceptanceCriteria = acceptanceCriteria;
        this.warrantyPeriod = warrantyPeriod;
        this.packagingSpecification = packagingSpecification;
        this.remark = remark;
        this.deliverStatus = deliverStatus;
        this.accessory = accessory;
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

    public String getOrderContractNo() {
        return orderContractNo;
    }

    public void setOrderContractNo(String orderContractNo) {
        this.orderContractNo = orderContractNo == null ? null : orderContractNo.trim();
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderContractUrl() {
        return orderContractUrl;
    }

    public void setOrderContractUrl(String orderContractUrl) {
        this.orderContractUrl = orderContractUrl == null ? null : orderContractUrl.trim();
    }

    public String getOrderContractExtendUrl() {
        return orderContractExtendUrl;
    }

    public void setOrderContractExtendUrl(String orderContractExtendUrl) {
        this.orderContractExtendUrl = orderContractExtendUrl == null ? null : orderContractExtendUrl.trim();
    }

    public String getTechnicalRequire() {
        return technicalRequire;
    }

    public void setTechnicalRequire(String technicalRequire) {
        this.technicalRequire = technicalRequire == null ? null : technicalRequire.trim();
    }

    public String getFinishFeedbackTime() {
        return finishFeedbackTime;
    }

    public void setFinishFeedbackTime(String finishFeedbackTime) {
        this.finishFeedbackTime = finishFeedbackTime == null ? null : finishFeedbackTime.trim();
    }

    public String getFeedbackTimeConfirmUser() {
        return feedbackTimeConfirmUser;
    }

    public void setFeedbackTimeConfirmUser(String feedbackTimeConfirmUser) {
        this.feedbackTimeConfirmUser = feedbackTimeConfirmUser == null ? null : feedbackTimeConfirmUser.trim();
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

    public String getAssemblyShop() {
        return assemblyShop;
    }

    public void setAssemblyShop(String assemblyShop) {
        this.assemblyShop = assemblyShop == null ? null : assemblyShop.trim();
    }

    public String getAssemblyGroup() {
        return assemblyGroup;
    }

    public void setAssemblyGroup(String assemblyGroup) {
        this.assemblyGroup = assemblyGroup == null ? null : assemblyGroup.trim();
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

    public String getDemandPhone() {
        return demandPhone;
    }

    public void setDemandPhone(String demandPhone) {
        this.demandPhone = demandPhone == null ? null : demandPhone.trim();
    }

    public String getDemandFax() {
        return demandFax;
    }

    public void setDemandFax(String demandFax) {
        this.demandFax = demandFax == null ? null : demandFax.trim();
    }

    public String getDemandBankName() {
        return demandBankName;
    }

    public void setDemandBankName(String demandBankName) {
        this.demandBankName = demandBankName == null ? null : demandBankName.trim();
    }

    public String getDemandBankCardNo() {
        return demandBankCardNo;
    }

    public void setDemandBankCardNo(String demandBankCardNo) {
        this.demandBankCardNo = demandBankCardNo == null ? null : demandBankCardNo.trim();
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

    public String getSupplyPhone() {
        return supplyPhone;
    }

    public void setSupplyPhone(String supplyPhone) {
        this.supplyPhone = supplyPhone == null ? null : supplyPhone.trim();
    }

    public String getSupplyFax() {
        return supplyFax;
    }

    public void setSupplyFax(String supplyFax) {
        this.supplyFax = supplyFax == null ? null : supplyFax.trim();
    }

    public String getSupplyBankName() {
        return supplyBankName;
    }

    public void setSupplyBankName(String supplyBankName) {
        this.supplyBankName = supplyBankName == null ? null : supplyBankName.trim();
    }

    public String getContractBankCardNo() {
        return contractBankCardNo;
    }

    public void setContractBankCardNo(String contractBankCardNo) {
        this.contractBankCardNo = contractBankCardNo == null ? null : contractBankCardNo.trim();
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace == null ? null : deliveryPlace.trim();
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate == null ? null : deliveryDate.trim();
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate == null ? null : contractSignDate.trim();
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getDiscountTotalPrice() {
        return discountTotalPrice;
    }

    public void setDiscountTotalPrice(BigDecimal discountTotalPrice) {
        this.discountTotalPrice = discountTotalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getPackagingSpecification() {
        return packagingSpecification;
    }

    public void setPackagingSpecification(String packagingSpecification) {
        this.packagingSpecification = packagingSpecification == null ? null : packagingSpecification.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Byte deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory == null ? null : accessory.trim();
    }
}