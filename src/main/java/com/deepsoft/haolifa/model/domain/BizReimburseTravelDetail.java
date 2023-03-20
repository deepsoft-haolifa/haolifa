package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizReimburseTravelDetail {
    private Integer id;

    private Integer reimburseId;

    private String serialNo;

    private Date depTime;

    private String depAddress;

    private Date arrTime;

    private String arrAddress;

    private Integer vehicle;

    private Integer vehicleDocNum;

    private BigDecimal vehicleAmount;

    private Double travelDays;

    private BigDecimal travelSubsidyAmount;

    private Integer projectType;

    private Integer projectDocNum;

    private BigDecimal projectAmount;

    private String type;

    private String payStatus;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizReimburseTravelDetail(Integer id, Integer reimburseId, String serialNo, Date depTime, String depAddress, Date arrTime, String arrAddress, Integer vehicle, Integer vehicleDocNum, BigDecimal vehicleAmount, Double travelDays, BigDecimal travelSubsidyAmount, Integer projectType, Integer projectDocNum, BigDecimal projectAmount, String type, String payStatus, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.reimburseId = reimburseId;
        this.serialNo = serialNo;
        this.depTime = depTime;
        this.depAddress = depAddress;
        this.arrTime = arrTime;
        this.arrAddress = arrAddress;
        this.vehicle = vehicle;
        this.vehicleDocNum = vehicleDocNum;
        this.vehicleAmount = vehicleAmount;
        this.travelDays = travelDays;
        this.travelSubsidyAmount = travelSubsidyAmount;
        this.projectType = projectType;
        this.projectDocNum = projectDocNum;
        this.projectAmount = projectAmount;
        this.type = type;
        this.payStatus = payStatus;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizReimburseTravelDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReimburseId() {
        return reimburseId;
    }

    public void setReimburseId(Integer reimburseId) {
        this.reimburseId = reimburseId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    public String getDepAddress() {
        return depAddress;
    }

    public void setDepAddress(String depAddress) {
        this.depAddress = depAddress == null ? null : depAddress.trim();
    }

    public Date getArrTime() {
        return arrTime;
    }

    public void setArrTime(Date arrTime) {
        this.arrTime = arrTime;
    }

    public String getArrAddress() {
        return arrAddress;
    }

    public void setArrAddress(String arrAddress) {
        this.arrAddress = arrAddress == null ? null : arrAddress.trim();
    }

    public Integer getVehicle() {
        return vehicle;
    }

    public void setVehicle(Integer vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getVehicleDocNum() {
        return vehicleDocNum;
    }

    public void setVehicleDocNum(Integer vehicleDocNum) {
        this.vehicleDocNum = vehicleDocNum;
    }

    public BigDecimal getVehicleAmount() {
        return vehicleAmount;
    }

    public void setVehicleAmount(BigDecimal vehicleAmount) {
        this.vehicleAmount = vehicleAmount;
    }

    public Double getTravelDays() {
        return travelDays;
    }

    public void setTravelDays(Double travelDays) {
        this.travelDays = travelDays;
    }

    public BigDecimal getTravelSubsidyAmount() {
        return travelSubsidyAmount;
    }

    public void setTravelSubsidyAmount(BigDecimal travelSubsidyAmount) {
        this.travelSubsidyAmount = travelSubsidyAmount;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getProjectDocNum() {
        return projectDocNum;
    }

    public void setProjectDocNum(Integer projectDocNum) {
        this.projectDocNum = projectDocNum;
    }

    public BigDecimal getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(BigDecimal projectAmount) {
        this.projectAmount = projectAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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