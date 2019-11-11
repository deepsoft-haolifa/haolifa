package com.deepsoft.haolifa.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseReport {
    private String total;

    private String supplierName;

    private String payTotal;

    private String unpay;

    @DateTimeFormat(pattern = "yyyy-MM")
    private String createTime;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(String payTotal) {
        this.payTotal = payTotal;
    }

    public String getUnpay() {
        return unpay;
    }

    public void setUnpay(String unpay) {
        this.unpay = unpay;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public PurchaseReport(String total, String supplierName, String payTotal, String unpay, String createTime) {
        this.total = total;
        this.supplierName = supplierName;
        this.payTotal = payTotal;
        this.unpay = unpay;
        this.createTime = createTime;
    }

    public PurchaseReport() {
    }
}