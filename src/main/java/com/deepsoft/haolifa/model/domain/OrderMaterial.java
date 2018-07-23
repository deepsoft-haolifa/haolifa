package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderMaterial {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String orderNo;

    private Integer materialId;

    private String materialGraphNo;

    private String materialCount;

    public OrderMaterial(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String orderNo, Integer materialId, String materialGraphNo, String materialCount) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.orderNo = orderNo;
        this.materialId = materialId;
        this.materialGraphNo = materialGraphNo;
        this.materialCount = materialCount;
    }

    public OrderMaterial() {
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public String getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(String materialCount) {
        this.materialCount = materialCount == null ? null : materialCount.trim();
    }
}