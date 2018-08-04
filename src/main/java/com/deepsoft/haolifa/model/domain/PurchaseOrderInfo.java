package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PurchaseOrderInfo {
    private Integer id;

    private Integer flowId;

    private String applyNo;

    private String orderNo;

    private Byte orderState;

    private String supplier;

    private String demander;

    private String supplierLinkman;

    private String demanderLinkman;

    private String supplierAddr;

    private String demanderAddr;

    private String suppilerPhone;

    private String demanderPhone;

    private Date deliveryTime;

    private Integer operatorUserId;

    private Date operateTime;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public PurchaseOrderInfo(Integer id, Integer flowId, String applyNo, String orderNo, Byte orderState, String supplier, String demander, String supplierLinkman, String demanderLinkman, String supplierAddr, String demanderAddr, String suppilerPhone, String demanderPhone, Date deliveryTime, Integer operatorUserId, Date operateTime, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.flowId = flowId;
        this.applyNo = applyNo;
        this.orderNo = orderNo;
        this.orderState = orderState;
        this.supplier = supplier;
        this.demander = demander;
        this.supplierLinkman = supplierLinkman;
        this.demanderLinkman = demanderLinkman;
        this.supplierAddr = supplierAddr;
        this.demanderAddr = demanderAddr;
        this.suppilerPhone = suppilerPhone;
        this.demanderPhone = demanderPhone;
        this.deliveryTime = deliveryTime;
        this.operatorUserId = operatorUserId;
        this.operateTime = operateTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public PurchaseOrderInfo() {
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

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Byte getOrderState() {
        return orderState;
    }

    public void setOrderState(Byte orderState) {
        this.orderState = orderState;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
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

    public Integer getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(Integer operatorUserId) {
        this.operatorUserId = operatorUserId;
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