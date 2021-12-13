package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizOtherBill {
    private Integer id;

    private String company;

    private String account;

    private String serialNo;

    private Date operateDate;

    private String certificateNumber;

    private String payWay;

    private String payAccount;

    private String payCompany;

    private String payCompanyId;

    private String collectCompany;

    private BigDecimal preMonthMoney;

    private BigDecimal collectionMoney;

    private String collectionType;

    private BigDecimal payment;

    private String paymentType;

    private BigDecimal balance;

    private String type;

    private Integer deptId;

    private String remark;

    private String delFlag;

    private String contractStatus;

    private Integer contractUser;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizOtherBill(Integer id, String company, String account, String serialNo, Date operateDate, String certificateNumber, String payWay, String payAccount, String payCompany, String payCompanyId, String collectCompany, BigDecimal preMonthMoney, BigDecimal collectionMoney, String collectionType, BigDecimal payment, String paymentType, BigDecimal balance, String type, Integer deptId, String remark, String delFlag, String contractStatus, Integer contractUser, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.company = company;
        this.account = account;
        this.serialNo = serialNo;
        this.operateDate = operateDate;
        this.certificateNumber = certificateNumber;
        this.payWay = payWay;
        this.payAccount = payAccount;
        this.payCompany = payCompany;
        this.payCompanyId = payCompanyId;
        this.collectCompany = collectCompany;
        this.preMonthMoney = preMonthMoney;
        this.collectionMoney = collectionMoney;
        this.collectionType = collectionType;
        this.payment = payment;
        this.paymentType = paymentType;
        this.balance = balance;
        this.type = type;
        this.deptId = deptId;
        this.remark = remark;
        this.delFlag = delFlag;
        this.contractStatus = contractStatus;
        this.contractUser = contractUser;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizOtherBill() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
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

    public String getCollectCompany() {
        return collectCompany;
    }

    public void setCollectCompany(String collectCompany) {
        this.collectCompany = collectCompany == null ? null : collectCompany.trim();
    }

    public BigDecimal getPreMonthMoney() {
        return preMonthMoney;
    }

    public void setPreMonthMoney(BigDecimal preMonthMoney) {
        this.preMonthMoney = preMonthMoney;
    }

    public BigDecimal getCollectionMoney() {
        return collectionMoney;
    }

    public void setCollectionMoney(BigDecimal collectionMoney) {
        this.collectionMoney = collectionMoney;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType == null ? null : collectionType.trim();
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus == null ? null : contractStatus.trim();
    }

    public Integer getContractUser() {
        return contractUser;
    }

    public void setContractUser(Integer contractUser) {
        this.contractUser = contractUser;
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