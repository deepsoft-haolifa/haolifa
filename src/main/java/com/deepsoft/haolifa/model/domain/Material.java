package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Material {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private Integer materialClassifyId;

    private String materialClassifyName;

    private String name;

    private String material;

    private String graphNo;

    private String unit;

    private BigDecimal price;

    private String specifications;

    private String model;

    private String actualWeight;

    private String theoreticalWeight;

    private String taxRate;

    private Byte status;

    private Integer safeQuantity;

    private String safetyFactor;

    private Integer currentQuantity;

    private Integer lockQuantity;

    private Byte isDelete;

    private String remark;

    public Material(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, Integer materialClassifyId, String materialClassifyName, String name, String material, String graphNo, String unit, BigDecimal price, String specifications, String model, String actualWeight, String theoreticalWeight, String taxRate, Byte status, Integer safeQuantity, String safetyFactor, Integer currentQuantity, Integer lockQuantity, Byte isDelete, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.materialClassifyId = materialClassifyId;
        this.materialClassifyName = materialClassifyName;
        this.name = name;
        this.material = material;
        this.graphNo = graphNo;
        this.unit = unit;
        this.price = price;
        this.specifications = specifications;
        this.model = model;
        this.actualWeight = actualWeight;
        this.theoreticalWeight = theoreticalWeight;
        this.taxRate = taxRate;
        this.status = status;
        this.safeQuantity = safeQuantity;
        this.safetyFactor = safetyFactor;
        this.currentQuantity = currentQuantity;
        this.lockQuantity = lockQuantity;
        this.isDelete = isDelete;
        this.remark = remark;
    }

    public Material() {
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getGraphNo() {
        return graphNo;
    }

    public void setGraphNo(String graphNo) {
        this.graphNo = graphNo == null ? null : graphNo.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(String actualWeight) {
        this.actualWeight = actualWeight == null ? null : actualWeight.trim();
    }

    public String getTheoreticalWeight() {
        return theoreticalWeight;
    }

    public void setTheoreticalWeight(String theoreticalWeight) {
        this.theoreticalWeight = theoreticalWeight == null ? null : theoreticalWeight.trim();
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate == null ? null : taxRate.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSafeQuantity() {
        return safeQuantity;
    }

    public void setSafeQuantity(Integer safeQuantity) {
        this.safeQuantity = safeQuantity;
    }

    public String getSafetyFactor() {
        return safetyFactor;
    }

    public void setSafetyFactor(String safetyFactor) {
        this.safetyFactor = safetyFactor == null ? null : safetyFactor.trim();
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public Integer getLockQuantity() {
        return lockQuantity;
    }

    public void setLockQuantity(Integer lockQuantity) {
        this.lockQuantity = lockQuantity;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}