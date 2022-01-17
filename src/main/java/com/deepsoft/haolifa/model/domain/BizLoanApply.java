package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizLoanApply {
    private Integer id;

    private String serialNo;

    private Integer deptId;

    private Date loanDate;

    private Date expectRepaymentDate;

    private BigDecimal amount;

    private String purpose;

    private Integer loanUser;

    private String amountType;

    private String billNature;

    private String accountName;

    private String cardNumber;

    private String bankOfDeposit;

    private String applyStatus;

    private String payCompany;

    private String payCompanyId;

    private String payAccount;

    private Date payTime;

    private String payStatus;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizLoanApply(Integer id, String serialNo, Integer deptId, Date loanDate, Date expectRepaymentDate, BigDecimal amount, String purpose, Integer loanUser, String amountType, String billNature, String accountName, String cardNumber, String bankOfDeposit, String applyStatus, String payCompany, String payCompanyId, String payAccount, Date payTime, String payStatus, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.serialNo = serialNo;
        this.deptId = deptId;
        this.loanDate = loanDate;
        this.expectRepaymentDate = expectRepaymentDate;
        this.amount = amount;
        this.purpose = purpose;
        this.loanUser = loanUser;
        this.amountType = amountType;
        this.billNature = billNature;
        this.accountName = accountName;
        this.cardNumber = cardNumber;
        this.bankOfDeposit = bankOfDeposit;
        this.applyStatus = applyStatus;
        this.payCompany = payCompany;
        this.payCompanyId = payCompanyId;
        this.payAccount = payAccount;
        this.payTime = payTime;
        this.payStatus = payStatus;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizLoanApply() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getExpectRepaymentDate() {
        return expectRepaymentDate;
    }

    public void setExpectRepaymentDate(Date expectRepaymentDate) {
        this.expectRepaymentDate = expectRepaymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Integer getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(Integer loanUser) {
        this.loanUser = loanUser;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getPayCompany() {
        return payCompany;
    }

    public void setPayCompany(String payCompany) {
        this.payCompany = payCompany == null ? null : payCompany.trim();
    }

    public String getPayCompanyId() {
        return payCompanyId;
    }

    public void setPayCompanyId(String payCompanyId) {
        this.payCompanyId = payCompanyId == null ? null : payCompanyId.trim();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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