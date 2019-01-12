package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderMaterial {
    private Integer id;

    private Date createTime;

    private String orderNo;

    private String materialGraphNo;

    private String materialName;

    private String replaceMaterialGraphNo;

    private String replaceMaterialName;

    private Byte isReplace;

    private Integer materialCount;

    private Integer lackMaterialCount;

    private Byte checkStatus;

    public OrderMaterial(Integer id, Date createTime, String orderNo, String materialGraphNo, String materialName, String replaceMaterialGraphNo, String replaceMaterialName, Byte isReplace, Integer materialCount, Integer lackMaterialCount, Byte checkStatus) {
        this.id = id;
        this.createTime = createTime;
        this.orderNo = orderNo;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.replaceMaterialGraphNo = replaceMaterialGraphNo;
        this.replaceMaterialName = replaceMaterialName;
        this.isReplace = isReplace;
        this.materialCount = materialCount;
        this.lackMaterialCount = lackMaterialCount;
        this.checkStatus = checkStatus;
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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getReplaceMaterialGraphNo() {
        return replaceMaterialGraphNo;
    }

    public void setReplaceMaterialGraphNo(String replaceMaterialGraphNo) {
        this.replaceMaterialGraphNo = replaceMaterialGraphNo == null ? null : replaceMaterialGraphNo.trim();
    }

    public String getReplaceMaterialName() {
        return replaceMaterialName;
    }

    public void setReplaceMaterialName(String replaceMaterialName) {
        this.replaceMaterialName = replaceMaterialName == null ? null : replaceMaterialName.trim();
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

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }
}