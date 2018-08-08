package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class EquipmentMaintainRecord {
    private Integer id;

    private String maintainReason;

    private String equipmentNo;

    private String maintainer;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public EquipmentMaintainRecord(Integer id, String maintainReason, String equipmentNo, String maintainer, String remark, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.maintainReason = maintainReason;
        this.equipmentNo = equipmentNo;
        this.maintainer = maintainer;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public EquipmentMaintainRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaintainReason() {
        return maintainReason;
    }

    public void setMaintainReason(String maintainReason) {
        this.maintainReason = maintainReason == null ? null : maintainReason.trim();
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer == null ? null : maintainer.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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