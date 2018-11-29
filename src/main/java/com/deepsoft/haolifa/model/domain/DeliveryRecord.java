package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class DeliveryRecord {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Byte deliveryClassify;

    private String deliveryNoticeNo;

    private String contractOrderNo;

    private Date deliveryTime;

    private String operationNo;

    private String customerNo;

    private Integer productCount;

    private String packingMode;

    private Integer pieceCount;

    private String transportCompany;

    private String courierNo;

    private String collectProvice;

    private String collectAddress;

    private String collectName;

    private String collectPhone;

    private BigDecimal weightPiece;

    private BigDecimal pricePiece;

    private BigDecimal deliveryFee;

    private BigDecimal totalFee;

    private String settlementWay;

    private String remark;

    public DeliveryRecord(Integer id, Date createTime, Date updateTime, Integer createUserId, Byte deliveryClassify, String deliveryNoticeNo, String contractOrderNo, Date deliveryTime, String operationNo, String customerNo, Integer productCount, String packingMode, Integer pieceCount, String transportCompany, String courierNo, String collectProvice, String collectAddress, String collectName, String collectPhone, BigDecimal weightPiece, BigDecimal pricePiece, BigDecimal deliveryFee, BigDecimal totalFee, String settlementWay, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.deliveryClassify = deliveryClassify;
        this.deliveryNoticeNo = deliveryNoticeNo;
        this.contractOrderNo = contractOrderNo;
        this.deliveryTime = deliveryTime;
        this.operationNo = operationNo;
        this.customerNo = customerNo;
        this.productCount = productCount;
        this.packingMode = packingMode;
        this.pieceCount = pieceCount;
        this.transportCompany = transportCompany;
        this.courierNo = courierNo;
        this.collectProvice = collectProvice;
        this.collectAddress = collectAddress;
        this.collectName = collectName;
        this.collectPhone = collectPhone;
        this.weightPiece = weightPiece;
        this.pricePiece = pricePiece;
        this.deliveryFee = deliveryFee;
        this.totalFee = totalFee;
        this.settlementWay = settlementWay;
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

    public Byte getDeliveryClassify() {
        return deliveryClassify;
    }

    public void setDeliveryClassify(Byte deliveryClassify) {
        this.deliveryClassify = deliveryClassify;
    }

    public String getDeliveryNoticeNo() {
        return deliveryNoticeNo;
    }

    public void setDeliveryNoticeNo(String deliveryNoticeNo) {
        this.deliveryNoticeNo = deliveryNoticeNo == null ? null : deliveryNoticeNo.trim();
    }

    public String getContractOrderNo() {
        return contractOrderNo;
    }

    public void setContractOrderNo(String contractOrderNo) {
        this.contractOrderNo = contractOrderNo == null ? null : contractOrderNo.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo == null ? null : operationNo.trim();
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getPackingMode() {
        return packingMode;
    }

    public void setPackingMode(String packingMode) {
        this.packingMode = packingMode == null ? null : packingMode.trim();
    }

    public Integer getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(Integer pieceCount) {
        this.pieceCount = pieceCount;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany == null ? null : transportCompany.trim();
    }

    public String getCourierNo() {
        return courierNo;
    }

    public void setCourierNo(String courierNo) {
        this.courierNo = courierNo == null ? null : courierNo.trim();
    }

    public String getCollectProvice() {
        return collectProvice;
    }

    public void setCollectProvice(String collectProvice) {
        this.collectProvice = collectProvice == null ? null : collectProvice.trim();
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

    public BigDecimal getWeightPiece() {
        return weightPiece;
    }

    public void setWeightPiece(BigDecimal weightPiece) {
        this.weightPiece = weightPiece;
    }

    public BigDecimal getPricePiece() {
        return pricePiece;
    }

    public void setPricePiece(BigDecimal pricePiece) {
        this.pricePiece = pricePiece;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getSettlementWay() {
        return settlementWay;
    }

    public void setSettlementWay(String settlementWay) {
        this.settlementWay = settlementWay == null ? null : settlementWay.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}