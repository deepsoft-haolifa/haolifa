package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class PriceProduct {
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    private String productNo;

    @ApiModelProperty(value = "型号")
    private String model;
    @ApiModelProperty(value = "连接方式")
    private String connectionMode;
    @ApiModelProperty(value = "结构形式")
    private String structuralStyle;
    @ApiModelProperty(value = "公称压力")
    private String nominalPressure;
    @ApiModelProperty(value = "阀体材质")
    private String fatiMaterial;
    @ApiModelProperty(value = "阀板材质")
    private String fabanMaterial;
    @ApiModelProperty(value = "密封形式")
    private String sealForm;
    @ApiModelProperty(value = "阀轴材质")
    private String fazhouMaterial;
    @ApiModelProperty(value = "辅料")
    private String accessories;
    @ApiModelProperty(value = "驱动")
    private String drive;
    @ApiModelProperty(value = "好利型号")
    private String haoliModel;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "成品单价")
    private String productPrice;
    @ApiModelProperty(value = "价格书")
    private String priceBook;
    @ApiModelProperty(value = "阀体单价")
    private String fatiPrice;
    @ApiModelProperty(value = "阀板单价")
    private String fabanPrice;
    @ApiModelProperty(value = "阀座单价")
    private String fazuoPrice;
    @ApiModelProperty(value = "阀轴单价")
    private String fazhouPrice;
    @ApiModelProperty(value = "辅料单价")
    private String accessoriesPrice;
    @ApiModelProperty(value = "驱动单价")
    private String drivePrice;
    @ApiModelProperty(value = "合计单价")
    private String totalPrice;
    @ApiModelProperty(value = "备注")
    private String remark;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    public PriceProduct(Integer id, String productNo, String model, String connectionMode, String structuralStyle, String nominalPressure, String fatiMaterial, String fabanMaterial, String sealForm, String fazhouMaterial, String accessories, String drive, String haoliModel, String specifications, String productPrice, String priceBook, String fatiPrice, String fabanPrice, String fazuoPrice, String fazhouPrice, String accessoriesPrice, String drivePrice, String totalPrice, String remark, Date createTime, Date updateTime, Integer createUser, Integer updateUser) {
        this.id = id;
        this.productNo = productNo;
        this.model = model;
        this.connectionMode = connectionMode;
        this.structuralStyle = structuralStyle;
        this.nominalPressure = nominalPressure;
        this.fatiMaterial = fatiMaterial;
        this.fabanMaterial = fabanMaterial;
        this.sealForm = sealForm;
        this.fazhouMaterial = fazhouMaterial;
        this.accessories = accessories;
        this.drive = drive;
        this.haoliModel = haoliModel;
        this.specifications = specifications;
        this.productPrice = productPrice;
        this.priceBook = priceBook;
        this.fatiPrice = fatiPrice;
        this.fabanPrice = fabanPrice;
        this.fazuoPrice = fazuoPrice;
        this.fazhouPrice = fazhouPrice;
        this.accessoriesPrice = accessoriesPrice;
        this.drivePrice = drivePrice;
        this.totalPrice = totalPrice;
        this.remark = remark;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getConnectionMode() {
        return connectionMode;
    }

    public void setConnectionMode(String connectionMode) {
        this.connectionMode = connectionMode == null ? null : connectionMode.trim();
    }

    public String getStructuralStyle() {
        return structuralStyle;
    }

    public void setStructuralStyle(String structuralStyle) {
        this.structuralStyle = structuralStyle == null ? null : structuralStyle.trim();
    }

    public String getNominalPressure() {
        return nominalPressure;
    }

    public void setNominalPressure(String nominalPressure) {
        this.nominalPressure = nominalPressure == null ? null : nominalPressure.trim();
    }

    public String getFatiMaterial() {
        return fatiMaterial;
    }

    public void setFatiMaterial(String fatiMaterial) {
        this.fatiMaterial = fatiMaterial == null ? null : fatiMaterial.trim();
    }

    public String getFabanMaterial() {
        return fabanMaterial;
    }

    public void setFabanMaterial(String fabanMaterial) {
        this.fabanMaterial = fabanMaterial == null ? null : fabanMaterial.trim();
    }

    public String getSealForm() {
        return sealForm;
    }

    public void setSealForm(String sealForm) {
        this.sealForm = sealForm == null ? null : sealForm.trim();
    }

    public String getFazhouMaterial() {
        return fazhouMaterial;
    }

    public void setFazhouMaterial(String fazhouMaterial) {
        this.fazhouMaterial = fazhouMaterial == null ? null : fazhouMaterial.trim();
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories == null ? null : accessories.trim();
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive == null ? null : drive.trim();
    }

    public String getHaoliModel() {
        return haoliModel;
    }

    public void setHaoliModel(String haoliModel) {
        this.haoliModel = haoliModel == null ? null : haoliModel.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice == null ? null : productPrice.trim();
    }

    public String getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(String priceBook) {
        this.priceBook = priceBook == null ? null : priceBook.trim();
    }

    public String getFatiPrice() {
        return fatiPrice;
    }

    public void setFatiPrice(String fatiPrice) {
        this.fatiPrice = fatiPrice == null ? null : fatiPrice.trim();
    }

    public String getFabanPrice() {
        return fabanPrice;
    }

    public void setFabanPrice(String fabanPrice) {
        this.fabanPrice = fabanPrice == null ? null : fabanPrice.trim();
    }

    public String getFazuoPrice() {
        return fazuoPrice;
    }

    public void setFazuoPrice(String fazuoPrice) {
        this.fazuoPrice = fazuoPrice == null ? null : fazuoPrice.trim();
    }

    public String getFazhouPrice() {
        return fazhouPrice;
    }

    public void setFazhouPrice(String fazhouPrice) {
        this.fazhouPrice = fazhouPrice == null ? null : fazhouPrice.trim();
    }

    public String getAccessoriesPrice() {
        return accessoriesPrice;
    }

    public void setAccessoriesPrice(String accessoriesPrice) {
        this.accessoriesPrice = accessoriesPrice == null ? null : accessoriesPrice.trim();
    }

    public String getDrivePrice() {
        return drivePrice;
    }

    public void setDrivePrice(String drivePrice) {
        this.drivePrice = drivePrice == null ? null : drivePrice.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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