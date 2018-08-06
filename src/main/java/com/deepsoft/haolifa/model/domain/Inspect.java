package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Inspect {
    private Integer id;

    private String orderNo;

    private Byte type;

    private Byte status;

    private String inspectNo;

    private String materialGraphNo;

    private String productModel;

    private Integer number;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public Inspect(Integer id, String orderNo, Byte type, Byte status, String inspectNo, String materialGraphNo, String productModel, Integer number, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.orderNo = orderNo;
        this.type = type;
        this.status = status;
        this.inspectNo = inspectNo;
        this.materialGraphNo = materialGraphNo;
        this.productModel = productModel;
        this.number = number;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public Inspect() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getInspectNo() {
        return inspectNo;
    }

    public void setInspectNo(String inspectNo) {
        this.inspectNo = inspectNo == null ? null : inspectNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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