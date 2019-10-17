package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SprayItem {
    private Integer id;

    private String sprayNo;

    private String materialGraphNo;

    private String specifications;

    private String model;

    private String materialClassifyName;

    private String material;

    private String specialRequires;

    private String sprayColor;

    private Integer number;

    private Integer qualifiedNumber;

    private String remark;

    private String completeTime;

    private Date createTime;

    private Date updateTime;

    private String batchNumber;

    public SprayItem(Integer id, String sprayNo, String materialGraphNo, String specifications, String model, String materialClassifyName, String material, String specialRequires, String sprayColor, Integer number, Integer qualifiedNumber, String remark, String completeTime, Date createTime, Date updateTime, String batchNumber) {
        this.id = id;
        this.sprayNo = sprayNo;
        this.materialGraphNo = materialGraphNo;
        this.specifications = specifications;
        this.model = model;
        this.materialClassifyName = materialClassifyName;
        this.material = material;
        this.specialRequires = specialRequires;
        this.sprayColor = sprayColor;
        this.number = number;
        this.qualifiedNumber = qualifiedNumber;
        this.remark = remark;
        this.completeTime = completeTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.batchNumber = batchNumber;
    }

    public SprayItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSprayNo() {
        return sprayNo;
    }

    public void setSprayNo(String sprayNo) {
        this.sprayNo = sprayNo == null ? null : sprayNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
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

    public String getMaterialClassifyName() {
        return materialClassifyName;
    }

    public void setMaterialClassifyName(String materialClassifyName) {
        this.materialClassifyName = materialClassifyName == null ? null : materialClassifyName.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getSpecialRequires() {
        return specialRequires;
    }

    public void setSpecialRequires(String specialRequires) {
        this.specialRequires = specialRequires == null ? null : specialRequires.trim();
    }

    public String getSprayColor() {
        return sprayColor;
    }

    public void setSprayColor(String sprayColor) {
        this.sprayColor = sprayColor == null ? null : sprayColor.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime == null ? null : completeTime.trim();
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }
}