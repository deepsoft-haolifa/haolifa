package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizSubjectsBalanceFlow {
    private Integer id;

    private String name;

    private Integer deptId;

    private String subjectsTypeCode;

    private Integer subjectsId;

    private Double costRatio;

    private BigDecimal amount;

    private BigDecimal balanceAmount;

    private String type;

    private String status;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizSubjectsBalanceFlow(Integer id, String name, Integer deptId, String subjectsTypeCode, Integer subjectsId, Double costRatio, BigDecimal amount, BigDecimal balanceAmount, String type, String status, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.subjectsTypeCode = subjectsTypeCode;
        this.subjectsId = subjectsId;
        this.costRatio = costRatio;
        this.amount = amount;
        this.balanceAmount = balanceAmount;
        this.type = type;
        this.status = status;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizSubjectsBalanceFlow() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getSubjectsTypeCode() {
        return subjectsTypeCode;
    }

    public void setSubjectsTypeCode(String subjectsTypeCode) {
        this.subjectsTypeCode = subjectsTypeCode == null ? null : subjectsTypeCode.trim();
    }

    public Integer getSubjectsId() {
        return subjectsId;
    }

    public void setSubjectsId(Integer subjectsId) {
        this.subjectsId = subjectsId;
    }

    public Double getCostRatio() {
        return costRatio;
    }

    public void setCostRatio(Double costRatio) {
        this.costRatio = costRatio;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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