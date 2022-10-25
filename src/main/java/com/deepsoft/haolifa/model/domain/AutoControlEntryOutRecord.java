package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class AutoControlEntryOutRecord {
    private Integer id;

    private Integer autoControlId;

    private String graphNo;

    private Byte type;

    private Float quantity;

    private String receiveDepartment;

    private Date createTime;

    private Integer createUser;

    private Integer updateUser;

    private Date updateTime;

    public AutoControlEntryOutRecord(Integer id, Integer autoControlId, String graphNo, Byte type, Float quantity, String receiveDepartment, Date createTime, Integer createUser, Integer updateUser, Date updateTime) {
        this.id = id;
        this.autoControlId = autoControlId;
        this.graphNo = graphNo;
        this.type = type;
        this.quantity = quantity;
        this.receiveDepartment = receiveDepartment;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public AutoControlEntryOutRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAutoControlId() {
        return autoControlId;
    }

    public void setAutoControlId(Integer autoControlId) {
        this.autoControlId = autoControlId;
    }

    public String getGraphNo() {
        return graphNo;
    }

    public void setGraphNo(String graphNo) {
        this.graphNo = graphNo == null ? null : graphNo.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getReceiveDepartment() {
        return receiveDepartment;
    }

    public void setReceiveDepartment(String receiveDepartment) {
        this.receiveDepartment = receiveDepartment == null ? null : receiveDepartment.trim();
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