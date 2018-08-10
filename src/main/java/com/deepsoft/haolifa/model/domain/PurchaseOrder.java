package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PurchaseOrder {
    private Integer id;

    private Integer flowId;

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

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public PurchaseOrder(Integer id, Integer flowId, String purchaseOrderNo, String supplierNo, String supplierName, String demander, String supplierLinkman, String demanderLinkman, String supplierAddr, String demanderAddr, String suppilerPhone, String demanderPhone, Date deliveryTime, String operatorUserName, Date operateTime, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.flowId = flowId;
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
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public PurchaseOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
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
}