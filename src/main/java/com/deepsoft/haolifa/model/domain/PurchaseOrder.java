package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseOrder {
    private Integer id;

    private String purchaseOrderNo;

    private String supplierNo;

    private String supplierName;

    private String demander;

    private String supplierLinkman;

    private String demanderLinkman;

    private String supplierAddr;

    private String demanderAddr;

    private String suppilerPhone;

    private String demanderPhone;

    private Date deliveryTime;

    private String operatorUserName;

    private Date operateTime;

    private String supplierConfirmer;

    private Date confirmTime;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    private BigDecimal wreckAmount;

    private String wreckReason;

    private Byte status;

    private Byte payStatus;

    private String payType;

    private Byte orderType;

    private String fileUrl;

    private Integer totalCount;


    private Integer acceptCount;

    private Integer backCount;

    private Integer processCount;

    private BigDecimal processCharges;

    private Integer qualifiedNumber;


    private BigDecimal totalPrice;

    private BigDecimal paidAccount;

    public PurchaseOrder(Integer id, String purchaseOrderNo, String supplierNo, String supplierName, String demander, String supplierLinkman, String demanderLinkman, String supplierAddr, String demanderAddr, String suppilerPhone, String demanderPhone, Date deliveryTime, String operatorUserName, Date operateTime, String supplierConfirmer, Date confirmTime, Date createTime, Date updateTime, Byte isDelete, Integer createUserId, BigDecimal wreckAmount, String wreckReason, Byte status, String payType, Byte orderType, String fileUrl, Integer totalCount, Integer acceptCount, Integer backCount, Integer processCount, BigDecimal processCharges, Integer qualifiedNumber, BigDecimal totalPrice, BigDecimal paidAccount) {
        this.id = id;
        this.purchaseOrderNo = purchaseOrderNo;
        this.supplierNo = supplierNo;
        this.supplierName = supplierName;
        this.demander = demander;
        this.supplierLinkman = supplierLinkman;
        this.demanderLinkman = demanderLinkman;
        this.supplierAddr = supplierAddr;
        this.demanderAddr = demanderAddr;
        this.suppilerPhone = suppilerPhone;
        this.demanderPhone = demanderPhone;
        this.deliveryTime = deliveryTime;
        this.operatorUserName = operatorUserName;
        this.operateTime = operateTime;
        this.supplierConfirmer = supplierConfirmer;
        this.confirmTime = confirmTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
        this.wreckAmount = wreckAmount;
        this.wreckReason = wreckReason;
        this.status = status;
        this.payType = payType;
        this.orderType = orderType;
        this.fileUrl = fileUrl;
        this.totalCount = totalCount;
        this.acceptCount = acceptCount;
        this.backCount = backCount;
        this.processCount = processCount;
        this.processCharges = processCharges;
        this.qualifiedNumber = qualifiedNumber;
        this.totalPrice = totalPrice;
        this.paidAccount = paidAccount;
    }

    public PurchaseOrder() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getDemander() {
        return demander;
    }

    public void setDemander(String demander) {
        this.demander = demander == null ? null : demander.trim();
    }

    public String getSupplierLinkman() {
        return supplierLinkman;
    }

    public void setSupplierLinkman(String supplierLinkman) {
        this.supplierLinkman = supplierLinkman == null ? null : supplierLinkman.trim();
    }

    public String getDemanderLinkman() {
        return demanderLinkman;
    }

    public void setDemanderLinkman(String demanderLinkman) {
        this.demanderLinkman = demanderLinkman == null ? null : demanderLinkman.trim();
    }

    public String getSupplierAddr() {
        return supplierAddr;
    }

    public void setSupplierAddr(String supplierAddr) {
        this.supplierAddr = supplierAddr == null ? null : supplierAddr.trim();
    }

    public String getDemanderAddr() {
        return demanderAddr;
    }

    public void setDemanderAddr(String demanderAddr) {
        this.demanderAddr = demanderAddr == null ? null : demanderAddr.trim();
    }

    public String getSuppilerPhone() {
        return suppilerPhone;
    }

    public void setSuppilerPhone(String suppilerPhone) {
        this.suppilerPhone = suppilerPhone == null ? null : suppilerPhone.trim();
    }

    public String getDemanderPhone() {
        return demanderPhone;
    }

    public void setDemanderPhone(String demanderPhone) {
        this.demanderPhone = demanderPhone == null ? null : demanderPhone.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getOperatorUserName() {
        return operatorUserName;
    }

    public void setOperatorUserName(String operatorUserName) {
        this.operatorUserName = operatorUserName == null ? null : operatorUserName.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getSupplierConfirmer() {
        return supplierConfirmer;
    }

    public void setSupplierConfirmer(String supplierConfirmer) {
        this.supplierConfirmer = supplierConfirmer == null ? null : supplierConfirmer.trim();
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public BigDecimal getWreckAmount() {
        return wreckAmount;
    }

    public void setWreckAmount(BigDecimal wreckAmount) {
        this.wreckAmount = wreckAmount;
    }

    public String getWreckReason() {
        return wreckReason;
    }

    public void setWreckReason(String wreckReason) {
        this.wreckReason = wreckReason == null ? null : wreckReason.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPaidAccount() {
        return paidAccount;
    }

    public void setPaidAccount(BigDecimal paidAccount) {
        this.paidAccount = paidAccount;
    }

    public Integer getAcceptCount() {
        return acceptCount;
    }

    public void setAcceptCount(Integer acceptCount) {
        this.acceptCount = acceptCount;
    }

    public Integer getBackCount() {
        return backCount;
    }

    public void setBackCount(Integer backCount) {
        this.backCount = backCount;
    }

    public Integer getProcessCount() {
        return processCount;
    }

    public void setProcessCount(Integer processCount) {
        this.processCount = processCount;
    }

    public BigDecimal getProcessCharges() {
        return processCharges;
    }

    public void setProcessCharges(BigDecimal processCharges) {
        this.processCharges = processCharges;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }
}
