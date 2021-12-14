package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayProductionCapacity {
    private Integer id;

    private Integer userId;

    private String capacityCode;

    private Integer teamId;

    private Integer departId;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayProductionCapacity(Integer id, Integer userId, String capacityCode, Integer teamId, Integer departId, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.capacityCode = capacityCode;
        this.teamId = teamId;
        this.departId = departId;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayProductionCapacity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCapacityCode() {
        return capacityCode;
    }

    public void setCapacityCode(String capacityCode) {
        this.capacityCode = capacityCode == null ? null : capacityCode.trim();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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
}
