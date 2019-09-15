package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PriceMaterial {
    private Integer id;

    private Integer materialClassifyId;

    private String materialClassifyName;

    private String name;

    private String graphNo;

    private String model;

    private String specifications;

    private String material;

    private String unit;

    private String actualWeight;

    private String taxRate;

    private BigDecimal tonPrice;

    private BigDecimal blankCost;

    private BigDecimal blankCostTax;

    private BigDecimal processCost;

    private BigDecimal sprayCost;

    private BigDecimal price;

    private BigDecimal priceTax;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    public PriceMaterial(Integer id, Integer materialClassifyId, String materialClassifyName, String name, String graphNo, String model, String specifications, String material, String unit, String actualWeight, String taxRate, BigDecimal tonPrice, BigDecimal blankCost, BigDecimal blankCostTax, BigDecimal processCost, BigDecimal sprayCost, BigDecimal price, BigDecimal priceTax, Date createTime, Date updateTime, Integer createUser, Integer updateUser) {
        this.id = id;
        this.materialClassifyId = materialClassifyId;
        this.materialClassifyName = materialClassifyName;
        this.name = name;
        this.graphNo = graphNo;
        this.model = model;
        this.specifications = specifications;
        this.material = material;
        this.unit = unit;
        this.actualWeight = actualWeight;
        this.taxRate = taxRate;
        this.tonPrice = tonPrice;
        this.blankCost = blankCost;
        this.blankCostTax = blankCostTax;
        this.processCost = processCost;
        this.sprayCost = sprayCost;
        this.price = price;
        this.priceTax = priceTax;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

    public PriceMaterial() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialClassifyId() {
        return materialClassifyId;
    }

    public void setMaterialClassifyId(Integer materialClassifyId) {
        this.materialClassifyId = materialClassifyId;
    }

    public String getMaterialClassifyName() {
        return materialClassifyName;
    }

    public void setMaterialClassifyName(String materialClassifyName) {
        this.materialClassifyName = materialClassifyName == null ? null : materialClassifyName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGraphNo() {
        return graphNo;
    }

    public void setGraphNo(String graphNo) {
        this.graphNo = graphNo == null ? null : graphNo.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(String actualWeight) {
        this.actualWeight = actualWeight == null ? null : actualWeight.trim();
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate == null ? null : taxRate.trim();
    }

    public BigDecimal getTonPrice() {
        return tonPrice;
    }

    public void setTonPrice(BigDecimal tonPrice) {
        this.tonPrice = tonPrice;
    }

    public BigDecimal getBlankCost() {
        return blankCost;
    }

    public void setBlankCost(BigDecimal blankCost) {
        this.blankCost = blankCost;
    }

    public BigDecimal getBlankCostTax() {
        return blankCostTax;
    }

    public void setBlankCostTax(BigDecimal blankCostTax) {
        this.blankCostTax = blankCostTax;
    }

    public BigDecimal getProcessCost() {
        return processCost;
    }

    public void setProcessCost(BigDecimal processCost) {
        this.processCost = processCost;
    }

    public BigDecimal getSprayCost() {
        return sprayCost;
    }

    public void setSprayCost(BigDecimal sprayCost) {
        this.sprayCost = sprayCost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
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