package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class EntrustInfo {
    private Integer id;

    private String purchaseOrderNo;

    private String entrustNo;

    private String materialGraphNo;

    private Integer number;

    private Byte state;

    private String entrustPerson;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public EntrustInfo(Integer id, String purchaseOrderNo, String entrustNo, String materialGraphNo, Integer number, Byte state, String entrustPerson, Byte isDelete, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.purchaseOrderNo = purchaseOrderNo;
        this.entrustNo = entrustNo;
        this.materialGraphNo = materialGraphNo;
        this.number = number;
        this.state = state;
        this.entrustPerson = entrustPerson;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public EntrustInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public String getEntrustNo() {
        return entrustNo;
    }

    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo == null ? null : entrustNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getEntrustPerson() {
        return entrustPerson;
    }

    public void setEntrustPerson(String entrustPerson) {
        this.entrustPerson = entrustPerson == null ? null : entrustPerson.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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