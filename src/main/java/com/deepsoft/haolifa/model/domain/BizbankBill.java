package com.deepsoft.haolifa.model.domain;

import java.util.Date;


/**
 * 银行日记账
 */
public class BizbankBill {

    private Integer id;
    private String company;

    private String account;

    private String serial_no;


    private Date operateDate;

    private String certificateNumber;

    private String payWay;

    private String payAccount;

    private String payCompany;

    private String payCompanyId;
//  收款单位
    private String collectCompany;

    private Double preMonthMoney;
//收款
    private Double collectionMoney;
    private Double payment;
//余额
    private Double balance;

    private String collectionType;
    private String paymentType;
    private String type;

    private Integer deptId;

    private String delFlag;

    private String contractStatus;

    private String remark;

    private Integer createUser;
    private Integer updateUser;
    private Date createTime;
    private Date updateTime;

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
        this.company = company;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
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
        this.certificateNumber = certificateNumber;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayCompany() {
        return payCompany;
    }

    public void setPayCompany(String payCompany) {
        this.payCompany = payCompany;
    }

    public String getPayCompanyId() {
        return payCompanyId;
    }

    public void setPayCompanyId(String payCompanyId) {
        this.payCompanyId = payCompanyId;
    }

    public String getCollectCompany() {
        return collectCompany;
    }

    public void setCollectCompany(String collectCompany) {
        this.collectCompany = collectCompany;
    }

    public Double getPreMonthMoney() {
        return preMonthMoney;
    }

    public void setPreMonthMoney(Double preMonthMoney) {
        this.preMonthMoney = preMonthMoney;
    }

    public Double getCollectionMoney() {
        return collectionMoney;
    }

    public void setCollectionMoney(Double collectionMoney) {
        this.collectionMoney = collectionMoney;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
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

    public BizbankBill(Integer id, String company, String account, String serial_no, Date operateDate, String certificateNumber, String payWay, String payAccount, String payCompany, String payCompanyId, String collectCompany, Double preMonthMoney, Double collectionMoney, Double payment, Double balance, String collectionType, String paymentType, String type, Integer deptId, String delFlag, String contractStatus, String remark, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.company = company;
        this.account = account;
        this.serial_no = serial_no;
        this.operateDate = operateDate;
        this.certificateNumber = certificateNumber;
        this.payWay = payWay;
        this.payAccount = payAccount;
        this.payCompany = payCompany;
        this.payCompanyId = payCompanyId;
        this.collectCompany = collectCompany;
        this.preMonthMoney = preMonthMoney;
        this.collectionMoney = collectionMoney;
        this.payment = payment;
        this.balance = balance;
        this.collectionType = collectionType;
        this.paymentType = paymentType;
        this.type = type;
        this.deptId = deptId;
        this.delFlag = delFlag;
        this.contractStatus = contractStatus;
        this.remark = remark;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BizbankBill() {
    }
}
