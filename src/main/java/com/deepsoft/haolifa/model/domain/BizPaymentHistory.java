package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizPaymentHistory {
    private Integer id;

    private Integer loanId;

    private String loanSerialNo;

    private Date loanDate;

    private Date repaymentDate;

    private BigDecimal amount;

    private Integer loanUser;

    private Integer repaymentUser;

    private String amountType;

    private String billNature;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizPaymentHistory(Integer id, Integer loanId, String loanSerialNo, Date loanDate, Date repaymentDate, BigDecimal amount, Integer loanUser, Integer repaymentUser, String amountType, String billNature, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.loanId = loanId;
        this.loanSerialNo = loanSerialNo;
        this.loanDate = loanDate;
        this.repaymentDate = repaymentDate;
        this.amount = amount;
        this.loanUser = loanUser;
        this.repaymentUser = repaymentUser;
        this.amountType = amountType;
        this.billNature = billNature;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizPaymentHistory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getLoanSerialNo() {
        return loanSerialNo;
    }

    public void setLoanSerialNo(String loanSerialNo) {
        this.loanSerialNo = loanSerialNo == null ? null : loanSerialNo.trim();
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(Integer loanUser) {
        this.loanUser = loanUser;
    }

    public Integer getRepaymentUser() {
        return repaymentUser;
    }

    public void setRepaymentUser(Integer repaymentUser) {
        this.repaymentUser = repaymentUser;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType == null ? null : amountType.trim();
    }

    public String getBillNature() {
        return billNature;
    }

    public void setBillNature(String billNature) {
        this.billNature = billNature == null ? null : billNature.trim();
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