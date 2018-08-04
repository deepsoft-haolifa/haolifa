package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class EquipmentMaintainRecordInfo {
    private Integer id;

    private String equipmentNo;

    private Integer maintainUserId;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public EquipmentMaintainRecordInfo(Integer id, String equipmentNo, Integer maintainUserId, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.equipmentNo = equipmentNo;
        this.maintainUserId = maintainUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public EquipmentMaintainRecordInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public Integer getMaintainUserId() {
        return maintainUserId;
    }

    public void setMaintainUserId(Integer maintainUserId) {
        this.maintainUserId = maintainUserId;
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