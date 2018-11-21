package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProductMaterial {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String productNo;

    private String productModel;

    private String specification;

    private String materialGraphNo;

    private Integer materialCount;

    private String replaceMaterialGraphNos;

    private Byte status;

    private Byte isDelete;

    private String remark;

    public ProductMaterial(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String productNo, String productModel, String specification, String materialGraphNo, Integer materialCount, String replaceMaterialGraphNos, Byte status, Byte isDelete, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.productNo = productNo;
        this.productModel = productModel;
        this.specification = specification;
        this.materialGraphNo = materialGraphNo;
        this.materialCount = materialCount;
        this.replaceMaterialGraphNos = replaceMaterialGraphNos;
        this.status = status;
        this.isDelete = isDelete;
        this.remark = remark;
    }

    public ProductMaterial() {
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }

    public String getReplaceMaterialGraphNos() {
        return replaceMaterialGraphNos;
    }

    public void setReplaceMaterialGraphNos(String replaceMaterialGraphNos) {
        this.replaceMaterialGraphNos = replaceMaterialGraphNos == null ? null : replaceMaterialGraphNos.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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