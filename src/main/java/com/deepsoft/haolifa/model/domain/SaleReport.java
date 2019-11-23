package com.deepsoft.haolifa.model.domain;

public class SaleReport {
    private int totalNum;
    private String productNo;
    private String productModel;
    private double totalPrice;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public SaleReport(int totalNum, String productNo, String productModel, double totalPrice) {
        this.totalNum = totalNum;
        this.productNo = productNo;
        this.productModel = productModel;
        this.totalPrice = totalPrice;
    }

    public SaleReport() {
    }
}
