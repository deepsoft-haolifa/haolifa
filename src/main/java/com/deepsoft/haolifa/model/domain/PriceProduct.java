package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PriceProduct {
    private Integer id;

    private String productNo;

    private String productModel;

    private BigDecimal exFactoryPrice;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    public PriceProduct(Integer id, String productNo, String productModel, BigDecimal exFactoryPrice, Date createTime, Date updateTime, Integer createUser, Integer updateUser) {
        this.id = id;
        this.productNo = productNo;
        this.productModel = productModel;
        this.exFactoryPrice = exFactoryPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

    public PriceProduct() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public BigDecimal getExFactoryPrice() {
        return exFactoryPrice;
    }

    public void setExFactoryPrice(BigDecimal exFactoryPrice) {
        this.exFactoryPrice = exFactoryPrice;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}