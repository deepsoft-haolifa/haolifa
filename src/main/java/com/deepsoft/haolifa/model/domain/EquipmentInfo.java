package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class EquipmentInfo {
    private Integer id;

    private String equipmentName;

    private String equipmentNo;

    private Integer equipmentNumber;

    private Byte state;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public EquipmentInfo(Integer id, String equipmentName, String equipmentNo, Integer equipmentNumber, Byte state, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.equipmentName = equipmentName;
        this.equipmentNo = equipmentNo;
        this.equipmentNumber = equipmentNumber;
        this.state = state;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public EquipmentInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public Integer getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(Integer equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}