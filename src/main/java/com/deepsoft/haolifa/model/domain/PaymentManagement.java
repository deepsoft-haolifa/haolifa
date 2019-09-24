package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentManagement {
    private Integer id;

    private BigDecimal amount;

    private Date payTime;

    private String invoiceNo;

    private String orderNo;

    private Integer createUserId;

    private Date createTime;

    private Date updateTime;

    public PaymentManagement(Integer id, BigDecimal amount, Date payTime, String invoiceNo, String orderNo, Integer createUserId, Date createTime, Date updateTime) {
        this.id = id;
        this.amount = amount;
        this.payTime = payTime;
        this.invoiceNo = invoiceNo;
        this.orderNo = orderNo;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PaymentManagement() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
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
}