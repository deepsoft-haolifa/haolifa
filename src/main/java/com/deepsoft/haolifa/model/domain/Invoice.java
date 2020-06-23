package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private Integer id;

    private String orderNo;

    private String invoiceNo;

    private String invoiceCompany;

    private BigDecimal totalAmount;

    private BigDecimal orderAmount;

    private String remark;

    private Byte type;

    private Byte status;

    private Date invoiceDate;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private String invoiceIssuing;

    private String constractParty;

    public Invoice(Integer id, String orderNo, String invoiceNo, String invoiceCompany, BigDecimal totalAmount, BigDecimal orderAmount, String remark, Byte type, Byte status, Date invoiceDate, Byte isDelete, Date createTime, Date updateTime, Integer createUserId, String invoiceIssuing, String constractParty) {
        this.id = id;
        this.orderNo = orderNo;
        this.invoiceNo = invoiceNo;
        this.invoiceCompany = invoiceCompany;
        this.totalAmount = totalAmount;
        this.orderAmount = orderAmount;
        this.remark = remark;
        this.type = type;
        this.status = status;
        this.invoiceDate = invoiceDate;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.invoiceIssuing = invoiceIssuing;
        this.constractParty = constractParty;
    }

    public Invoice() {
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

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany == null ? null : invoiceCompany.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getInvoiceIssuing() {
        return invoiceIssuing;
    }

    public void setInvoiceIssuing(String invoiceIssuing) {
        this.invoiceIssuing = invoiceIssuing == null ? null : invoiceIssuing.trim();
    }

    public String getConstractParty() {
        return constractParty;
    }

    public void setConstractParty(String constractParty) {
        this.constractParty = constractParty == null ? null : constractParty.trim();
    }
}