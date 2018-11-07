package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderMaterial {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String orderNo;

    private String materialGraphNo;

    private Integer materialCount;

    public OrderMaterial(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String orderNo, String materialGraphNo, Integer materialCount) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.orderNo = orderNo;
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
}