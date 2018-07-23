package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SupplierProductInfo {
    private Integer id;

    private String suppilerNo;

    private String materialGraphNo;

    private String materialName;

    private Integer annualProduction;

    private String mainCustomer;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public SupplierProductInfo(Integer id, String suppilerNo, String materialGraphNo, String materialName, Integer annualProduction, String mainCustomer, Byte isDelete, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.suppilerNo = suppilerNo;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.annualProduction = annualProduction;
        this.mainCustomer = mainCustomer;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public SupplierProductInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuppilerNo() {
        return suppilerNo;
    }

    public void setSuppilerNo(String suppilerNo) {
        this.suppilerNo = suppilerNo == null ? null : suppilerNo.trim();
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