package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SupplierProduct {
    private Integer id;

    private String supplierNo;

    private Byte materialType;

    private String materialGraphNo;

    private String materialName;

    private Integer annualProduction;

    private String mainCustomer;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public SupplierProduct(Integer id, String supplierNo, Byte materialType, String materialGraphNo, String materialName, Integer annualProduction, String mainCustomer, Byte isDelete, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.supplierNo = supplierNo;
        this.materialType = materialType;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.annualProduction = annualProduction;
        this.mainCustomer = mainCustomer;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public SupplierProduct() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public Byte getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Byte materialType) {
        this.materialType = materialType;
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public Integer getAnnualProduction() {
        return annualProduction;
    }

    public void setAnnualProduction(Integer annualProduction) {
        this.annualProduction = annualProduction;
    }

    public String getMainCustomer() {
        return mainCustomer;
    }

    public void setMainCustomer(String mainCustomer) {
        this.mainCustomer = mainCustomer == null ? null : mainCustomer.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}