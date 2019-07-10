package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class PriceMaterial {
    private Integer id;
    @ApiModelProperty(value = "零件分类名称")
    private String materialClassifyName;
    @ApiModelProperty(value = "零件名称")
    private String name;
    @ApiModelProperty(value = "图号")
    private String graphNo;
    @ApiModelProperty(value = "型号")
    private String model;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "材料")
    private String material;
    @ApiModelProperty(value = "单位")
    private String unit;
    @ApiModelProperty(value = "单重")
    private String actualWeight;
    @ApiModelProperty(value = "吨价(元)")
    private String tonPrice;
    @ApiModelProperty(value = "毛坯费（元）")
    private String blankCost;
    @ApiModelProperty(value = "加工费（元）")
    private String processCost;
    @ApiModelProperty(value = "成品价（元）")
    private String productPrice;
    private Date createTime;
    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    public PriceMaterial(Integer id, String materialClassifyName, String name, String graphNo, String model, String specifications, String material, String unit, String actualWeight, String tonPrice, String blankCost, String processCost, String productPrice, Date createTime, Date updateTime, Integer createUser, Integer updateUser) {
        this.id = id;
        this.materialClassifyName = materialClassifyName;
        this.name = name;
        this.graphNo = graphNo;
        this.model = model;
        this.specifications = specifications;
        this.material = material;
        this.unit = unit;
        this.actualWeight = actualWeight;
        this.tonPrice = tonPrice;
        this.blankCost = blankCost;
        this.processCost = processCost;
        this.productPrice = productPrice;
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

    public String getTonPrice() {
        return tonPrice;
    }

    public void setTonPrice(String tonPrice) {
        this.tonPrice = tonPrice == null ? null : tonPrice.trim();
    }

    public String getBlankCost() {
        return blankCost;
    }

    public void setBlankCost(String blankCost) {
        this.blankCost = blankCost == null ? null : blankCost.trim();
    }

    public String getProcessCost() {
        return processCost;
    }

    public void setProcessCost(String processCost) {
        this.processCost = processCost == null ? null : processCost.trim();
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice == null ? null : productPrice.trim();
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