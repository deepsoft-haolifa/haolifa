package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class StoreRoomRack {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private Integer storeRoomId;

    private String rackNo;

    private Byte status;

    private String remark;

    private Byte isDelete;

    public StoreRoomRack(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, Integer storeRoomId, String rackNo, Byte status, String remark, Byte isDelete) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.storeRoomId = storeRoomId;
        this.rackNo = rackNo;
        this.status = status;
        this.remark = remark;
        this.isDelete = isDelete;
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

    public Integer getStoreRoomId() {
        return storeRoomId;
    }

    public void setStoreRoomId(Integer storeRoomId) {
        this.storeRoomId = storeRoomId;
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
}