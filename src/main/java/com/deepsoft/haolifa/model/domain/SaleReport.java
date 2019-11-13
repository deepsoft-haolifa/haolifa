package com.deepsoft.haolifa.model.domain;

public class SaleReport {
    private int tatalNum;
    private String productNo;
    private String productModel;
    private double totalPrice;

    public int getTatalNum() {
        return tatalNum;
    }

    public void setTatalNum(int tatalNum) {
        this.tatalNum = tatalNum;
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

    public SaleReport(int tatalNum, String productNo, String productModel, double totalPrice) {
        this.tatalNum = tatalNum;
        this.productNo = productNo;
        this.productModel = productModel;
        this.totalPrice = totalPrice;
    }

    public SaleReport() {
    }
}
