package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderMaterial {
    private Integer id;

    private Date createTime;

    private String orderNo;

    private String materialGraphNo;

    private Byte isReplace;

    private Integer materialCount;

    private Integer lackMaterialCount;

    private Integer status;

    public OrderMaterial(Integer id, Date createTime, String orderNo, String materialGraphNo, Byte isReplace, Integer materialCount, Integer lackMaterialCount, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.orderNo = orderNo;
        this.materialGraphNo = materialGraphNo;
        this.isReplace = isReplace;
        this.materialCount = materialCount;
        this.lackMaterialCount = lackMaterialCount;
        this.status = status;
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

    public Byte getIsReplace() {
        return isReplace;
    }

    public void setIsReplace(Byte isReplace) {
        this.isReplace = isReplace;
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }

    public Integer getLackMaterialCount() {
        return lackMaterialCount;
    }

    public void setLackMaterialCount(Integer lackMaterialCount) {
        this.lackMaterialCount = lackMaterialCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}