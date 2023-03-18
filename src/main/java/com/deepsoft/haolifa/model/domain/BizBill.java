package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizBill {
    private Integer id;

    private String xh;

    private Date d;

    private String certificateNumber;

    private String settlementType;

    private String clearingBanks;

    private BigDecimal preMonthMoney;

    private BigDecimal collectionMoney;

    private String collectionType;

    private BigDecimal payment;

    private String paymentType;

    private BigDecimal balance;

    private String type;

    private String deptId;

    private String string1;

    private String string2;

    private String string3;

    private String string4;

    private String string5;

    private String string6;

    private String string7;

    private String string8;

    private String string9;

    private String string10;

    private String remark;

    private String projectCode;

    private Integer subject;

    private String status;

    private String delFlag;

    private Integer contractUser;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizBill(Integer id, String xh, Date d, String certificateNumber, String settlementType, String clearingBanks, BigDecimal preMonthMoney, BigDecimal collectionMoney, String collectionType, BigDecimal payment, String paymentType, BigDecimal balance, String type, String deptId, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String remark, String projectCode, Integer subject, String status, String delFlag, Integer contractUser, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.xh = xh;
        this.d = d;
        this.certificateNumber = certificateNumber;
        this.settlementType = settlementType;
        this.clearingBanks = clearingBanks;
        this.preMonthMoney = preMonthMoney;
        this.collectionMoney = collectionMoney;
        this.collectionType = collectionType;
        this.payment = payment;
        this.paymentType = paymentType;
        this.balance = balance;
        this.type = type;
        this.deptId = deptId;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
        this.string6 = string6;
        this.string7 = string7;
        this.string8 = string8;
        this.string9 = string9;
        this.string10 = string10;
        this.remark = remark;
        this.projectCode = projectCode;
        this.subject = subject;
        this.status = status;
        this.delFlag = delFlag;
        this.contractUser = contractUser;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizBill() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
    }

    public String getClearingBanks() {
        return clearingBanks;
    }

    public void setClearingBanks(String clearingBanks) {
        this.clearingBanks = clearingBanks == null ? null : clearingBanks.trim();
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1 == null ? null : string1.trim();
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2 == null ? null : string2.trim();
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3 == null ? null : string3.trim();
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4 == null ? null : string4.trim();
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5 == null ? null : string5.trim();
    }

    public String getString6() {
        return string6;
    }

    public void setString6(String string6) {
        this.string6 = string6 == null ? null : string6.trim();
    }

    public String getString7() {
        return string7;
    }

    public void setString7(String string7) {
        this.string7 = string7 == null ? null : string7.trim();
    }

    public String getString8() {
        return string8;
    }

    public void setString8(String string8) {
        this.string8 = string8 == null ? null : string8.trim();
    }

    public String getString9() {
        return string9;
    }

    public void setString9(String string9) {
        this.string9 = string9 == null ? null : string9.trim();
    }

    public String getString10() {
        return string10;
    }

    public void setString10(String string10) {
        this.string10 = string10 == null ? null : string10.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
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
