package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProductMaterial {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String productNo;

    private Integer materialId;

    private String materialGraphNo;

    private Byte status;

    private String remark;

    public ProductMaterial(Integer id, Date createTime, Date updateTime, String productNo, Integer materialId, String materialGraphNo, Byte status, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.productNo = productNo;
        this.materialId = materialId;
        this.materialGraphNo = materialGraphNo;
        this.status = status;
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

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
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