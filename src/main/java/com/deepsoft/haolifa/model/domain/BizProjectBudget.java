package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizProjectBudget {
    private Long id;

    private String code;

    private String name;

    private Integer deptId;

    private String year;

    private String month;

    private BigDecimal totalQuota;

    private BigDecimal balanceQuota;

    private String status;

    private String remark;

    private String delFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public BizProjectBudget(Long id, String code, String name, Integer deptId, String year, String month, BigDecimal totalQuota, BigDecimal balanceQuota, String status, String remark, String delFlag, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.deptId = deptId;
        this.year = year;
        this.month = month;
        this.totalQuota = totalQuota;
        this.balanceQuota = balanceQuota;
        this.status = status;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public BizProjectBudget() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public BigDecimal getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(BigDecimal totalQuota) {
        this.totalQuota = totalQuota;
    }

    public BigDecimal getBalanceQuota() {
        return balanceQuota;
    }

    public void setBalanceQuota(BigDecimal balanceQuota) {
        this.balanceQuota = balanceQuota;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}