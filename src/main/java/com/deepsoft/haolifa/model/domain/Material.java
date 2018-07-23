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

    private Byte status;

    private String remark;

    public Material(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, Integer materialClassifyId, String materialClassifyName, String name, String material, String graphNo, String unit, BigDecimal price, String specifications, String model, Byte status, String remark) {
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
        this.status = status;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}