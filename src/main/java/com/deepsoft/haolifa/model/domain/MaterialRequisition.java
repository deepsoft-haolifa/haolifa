package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class MaterialRequisition {
    private Integer id;

    private String requisitionNo;

    private String orderNo;

    private String dept;

    private String materialName;

    private String graphNo;

    private Integer quantity;

    private String batchNumber;

    private Date createTime;

    private Integer createUser;

    private Integer updateUser;

    private Date updateTime;

    public MaterialRequisition(Integer id, String requisitionNo, String orderNo, String dept, String materialName, String graphNo, Integer quantity, String batchNumber, Date createTime, Integer createUser, Integer updateUser, Date updateTime) {
        this.id = id;
        this.requisitionNo = requisitionNo;
        this.orderNo = orderNo;
        this.dept = dept;
        this.materialName = materialName;
        this.graphNo = graphNo;
        this.quantity = quantity;
        this.batchNumber = batchNumber;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public MaterialRequisition() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequisitionNo() {
        return requisitionNo;
    }

    public void setRequisitionNo(String requisitionNo) {
        this.requisitionNo = requisitionNo == null ? null : requisitionNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getGraphNo() {
        return graphNo;
    }

    public void setGraphNo(String graphNo) {
        this.graphNo = graphNo == null ? null : graphNo.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}