package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderProductAssociate {
    private Integer id;

    private Date createTime;

    private String orderNo;

    private String seqNo;

    private String productNo;

    private String productName;

    private String specifications;

    private String productModel;

    private String lable;

    private String productColor;

    private Integer productNumber;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private String materialDescription;

    private String productRemark;

    public OrderProductAssociate(Integer id, Date createTime, String orderNo, String seqNo, String productNo, String productName, String specifications, String productModel, String lable, String productColor, Integer productNumber, BigDecimal price, BigDecimal totalPrice, String materialDescription, String productRemark) {
        this.id = id;
        this.createTime = createTime;
        this.orderNo = orderNo;
        this.seqNo = seqNo;
        this.productNo = productNo;
        this.productName = productName;
        this.specifications = specifications;
        this.productModel = productModel;
        this.lable = lable;
        this.productColor = productColor;
        this.productNumber = productNumber;
        this.price = price;
        this.totalPrice = totalPrice;
        this.materialDescription = materialDescription;
        this.productRemark = productRemark;
    }

    public OrderProductAssociate() {
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor == null ? null : productColor.trim();
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription == null ? null : materialDescription.trim();
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
    }
}