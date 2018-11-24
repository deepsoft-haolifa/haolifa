package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderMaterial {
    private Integer id;

    private Date createTime;

    private String orderNo;

    private Integer orderProductAssociateId;

    private String materialGraphNo;

    private String replaceMaterialGraphNo;

    private Integer materialCount;

    public OrderMaterial(Integer id, Date createTime, String orderNo, Integer orderProductAssociateId, String materialGraphNo, String replaceMaterialGraphNo, Integer materialCount) {
        this.id = id;
        this.createTime = createTime;
        this.orderNo = orderNo;
        this.orderProductAssociateId = orderProductAssociateId;
        this.materialGraphNo = materialGraphNo;
        this.replaceMaterialGraphNo = replaceMaterialGraphNo;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderProductAssociateId() {
        return orderProductAssociateId;
    }

    public void setOrderProductAssociateId(Integer orderProductAssociateId) {
        this.orderProductAssociateId = orderProductAssociateId;
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getReplaceMaterialGraphNo() {
        return replaceMaterialGraphNo;
    }

    public void setReplaceMaterialGraphNo(String replaceMaterialGraphNo) {
        this.replaceMaterialGraphNo = replaceMaterialGraphNo == null ? null : replaceMaterialGraphNo.trim();
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }
}