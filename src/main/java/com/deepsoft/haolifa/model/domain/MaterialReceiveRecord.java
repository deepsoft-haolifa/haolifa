package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class MaterialReceiveRecord {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String receiveNo;

    private String orderNo;

    private String receiveDepartment;

    private String receiveUserId;

    private Integer materialId;

    private String materialGraphNo;

    private BigDecimal materialPrice;

    private String startMaterialCount;

    private BigDecimal startMaterialAmount;

    private String actualMaterialCount;

    private BigDecimal actualMaterialAmount;

    private String endMaterialCount;

    private BigDecimal endMaterialAmount;

    public MaterialReceiveRecord(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String receiveNo, String orderNo, String receiveDepartment, String receiveUserId, Integer materialId, String materialGraphNo, BigDecimal materialPrice, String startMaterialCount, BigDecimal startMaterialAmount, String actualMaterialCount, BigDecimal actualMaterialAmount, String endMaterialCount, BigDecimal endMaterialAmount) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.receiveNo = receiveNo;
        this.orderNo = orderNo;
        this.receiveDepartment = receiveDepartment;
        this.receiveUserId = receiveUserId;
        this.materialId = materialId;
        this.materialGraphNo = materialGraphNo;
        this.materialPrice = materialPrice;
        this.startMaterialCount = startMaterialCount;
        this.startMaterialAmount = startMaterialAmount;
        this.actualMaterialCount = actualMaterialCount;
        this.actualMaterialAmount = actualMaterialAmount;
        this.endMaterialCount = endMaterialCount;
        this.endMaterialAmount = endMaterialAmount;
    }

    public MaterialReceiveRecord() {
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

    public String getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo == null ? null : receiveNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getReceiveDepartment() {
        return receiveDepartment;
    }

    public void setReceiveDepartment(String receiveDepartment) {
        this.receiveDepartment = receiveDepartment == null ? null : receiveDepartment.trim();
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId == null ? null : receiveUserId.trim();
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

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public String getStartMaterialCount() {
        return startMaterialCount;
    }

    public void setStartMaterialCount(String startMaterialCount) {
        this.startMaterialCount = startMaterialCount == null ? null : startMaterialCount.trim();
    }

    public BigDecimal getStartMaterialAmount() {
        return startMaterialAmount;
    }

    public void setStartMaterialAmount(BigDecimal startMaterialAmount) {
        this.startMaterialAmount = startMaterialAmount;
    }

    public String getActualMaterialCount() {
        return actualMaterialCount;
    }

    public void setActualMaterialCount(String actualMaterialCount) {
        this.actualMaterialCount = actualMaterialCount == null ? null : actualMaterialCount.trim();
    }

    public BigDecimal getActualMaterialAmount() {
        return actualMaterialAmount;
    }

    public void setActualMaterialAmount(BigDecimal actualMaterialAmount) {
        this.actualMaterialAmount = actualMaterialAmount;
    }

    public String getEndMaterialCount() {
        return endMaterialCount;
    }

    public void setEndMaterialCount(String endMaterialCount) {
        this.endMaterialCount = endMaterialCount == null ? null : endMaterialCount.trim();
    }

    public BigDecimal getEndMaterialAmount() {
        return endMaterialAmount;
    }

    public void setEndMaterialAmount(BigDecimal endMaterialAmount) {
        this.endMaterialAmount = endMaterialAmount;
    }
}