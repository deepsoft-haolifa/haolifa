package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizPayApply {
    private Integer id;

    private String status;

    private BigDecimal totalPrice;

    private String applyPayCompany;

    private Date applyTime;

    private Integer deptId;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizPayApply(Integer id, String status, BigDecimal totalPrice, String applyPayCompany, Date applyTime, Integer deptId, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
        this.applyPayCompany = applyPayCompany;
        this.applyTime = applyTime;
        this.deptId = deptId;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizPayApply() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getApplyPayCompany() {
        return applyPayCompany;
    }

    public void setApplyPayCompany(String applyPayCompany) {
        this.applyPayCompany = applyPayCompany == null ? null : applyPayCompany.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
