package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PayProductionCapacity {
    private Integer id;

    private String capacityName;

    private String capacityCode;

    private BigDecimal capacityPrice;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayProductionCapacity(Integer id, String capacityName, String capacityCode, BigDecimal capacityPrice, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.capacityName = capacityName;
        this.capacityCode = capacityCode;
        this.capacityPrice = capacityPrice;
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

    public String getCapacityName() {
        return capacityName;
    }

    public void setCapacityName(String capacityName) {
        this.capacityName = capacityName == null ? null : capacityName.trim();
    }

    public String getCapacityCode() {
        return capacityCode;
    }

    public void setCapacityCode(String capacityCode) {
        this.capacityCode = capacityCode == null ? null : capacityCode.trim();
    }

    public BigDecimal getCapacityPrice() {
        return capacityPrice;
    }

    public void setCapacityPrice(BigDecimal capacityPrice) {
        this.capacityPrice = capacityPrice;
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