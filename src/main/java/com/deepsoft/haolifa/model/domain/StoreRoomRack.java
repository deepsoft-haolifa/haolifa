package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class StoreRoomRack {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String roomNo;

    private String rackNo;

    private Byte status;

    private String remark;

    private Byte isDelete;

    private String rackName;

    public StoreRoomRack(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, String roomNo, String rackNo, Byte status, String remark, Byte isDelete, String rackName) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.roomNo = roomNo;
        this.rackNo = rackNo;
        this.status = status;
        this.remark = remark;
        this.isDelete = isDelete;
        this.rackName = rackName;
    }

    public StoreRoomRack() {
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

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo == null ? null : rackNo.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRackName() {
        return rackName;
    }

    public void setRackName(String rackName) {
        this.rackName = rackName == null ? null : rackName.trim();
    }
}