package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Expenses {
    private Integer id;

    private BigDecimal totalAmount;

    private String expensesClassify;

    private Integer createUserId;

    private String commitUser;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    private String secondClassify;

    private String department;

    private String summary;

    private String remark;

    private String voucherNo;

    private String dataYear;

    private String dataMonth;

    public Expenses(Integer id, BigDecimal totalAmount, String expensesClassify, Integer createUserId, String commitUser, Byte isDelete, Date createTime, Date updateTime, String secondClassify, String department, String summary, String remark, String voucherNo, String dataYear, String dataMonth) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.expensesClassify = expensesClassify;
        this.createUserId = createUserId;
        this.commitUser = commitUser;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.secondClassify = secondClassify;
        this.department = department;
        this.summary = summary;
        this.remark = remark;
        this.voucherNo = voucherNo;
        this.dataYear = dataYear;
        this.dataMonth = dataMonth;
    }

    public Expenses() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getExpensesClassify() {
        return expensesClassify;
    }

    public void setExpensesClassify(String expensesClassify) {
        this.expensesClassify = expensesClassify == null ? null : expensesClassify.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser == null ? null : commitUser.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getSecondClassify() {
        return secondClassify;
    }

    public void setSecondClassify(String secondClassify) {
        this.secondClassify = secondClassify == null ? null : secondClassify.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo == null ? null : voucherNo.trim();
    }

    public String getDataYear() {
        return dataYear;
    }

    public void setDataYear(String dataYear) {
        this.dataYear = dataYear == null ? null : dataYear.trim();
    }

    public String getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(String dataMonth) {
        this.dataMonth = dataMonth == null ? null : dataMonth.trim();
    }
}