package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizReimburseApply {
    private Integer id;

    private String serialNo;

    private String type;

    private String reimburseType;

    private Date reimburseDate;

    private String accountName;

    private String cardNumber;

    private String bankOfDeposit;

    private Integer deptId;

    private BigDecimal amount;

    private String payType;

    private String payCompany;

    private String payCompanyId;

    private String payAccount;

    private Date payTime;

    private String payStatus;

    private Integer reimburseUser;

    private String reimburseUserNo;

    private String travelUserName;

    private BigDecimal offsetAmount;

    private Integer loanId;

    private String applyStatus;

    private String projectCode;

    private String fileUrl;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizReimburseApply(Integer id, String serialNo, String type, String reimburseType, Date reimburseDate, String accountName, String cardNumber, String bankOfDeposit, Integer deptId, BigDecimal amount, String payType, String payCompany, String payCompanyId, String payAccount, Date payTime, String payStatus, Integer reimburseUser, String reimburseUserNo, String travelUserName, BigDecimal offsetAmount, Integer loanId, String applyStatus, String projectCode, String fileUrl, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.serialNo = serialNo;
        this.type = type;
        this.reimburseType = reimburseType;
        this.reimburseDate = reimburseDate;
        this.accountName = accountName;
        this.cardNumber = cardNumber;
        this.bankOfDeposit = bankOfDeposit;
        this.deptId = deptId;
        this.amount = amount;
        this.payType = payType;
        this.payCompany = payCompany;
        this.payCompanyId = payCompanyId;
        this.payAccount = payAccount;
        this.payTime = payTime;
        this.payStatus = payStatus;
        this.reimburseUser = reimburseUser;
        this.reimburseUserNo = reimburseUserNo;
        this.travelUserName = travelUserName;
        this.offsetAmount = offsetAmount;
        this.loanId = loanId;
        this.applyStatus = applyStatus;
        this.projectCode = projectCode;
        this.fileUrl = fileUrl;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizReimburseApply() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getReimburseType() {
        return reimburseType;
    }

    public void setReimburseType(String reimburseType) {
        this.reimburseType = reimburseType == null ? null : reimburseType.trim();
    }

    public Date getReimburseDate() {
        return reimburseDate;
    }

    public void setReimburseDate(Date reimburseDate) {
        this.reimburseDate = reimburseDate;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
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

    public Integer getReimburseUser() {
        return reimburseUser;
    }

    public void setReimburseUser(Integer reimburseUser) {
        this.reimburseUser = reimburseUser;
    }

    public String getReimburseUserNo() {
        return reimburseUserNo;
    }

    public void setReimburseUserNo(String reimburseUserNo) {
        this.reimburseUserNo = reimburseUserNo == null ? null : reimburseUserNo.trim();
    }

    public String getTravelUserName() {
        return travelUserName;
    }

    public void setTravelUserName(String travelUserName) {
        this.travelUserName = travelUserName == null ? null : travelUserName.trim();
    }

    public BigDecimal getOffsetAmount() {
        return offsetAmount;
    }

    public void setOffsetAmount(BigDecimal offsetAmount) {
        this.offsetAmount = offsetAmount;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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