package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Contract {
    private Integer id;

    private String orderNo;

    private String contractName;

    private Byte contractType;

    private String contractDuration;

    private String contractSubject;

    private BigDecimal totalAmount;

    private String contractParty;

    private String address;

    private String linkman;

    private String linkmanPhone;

    private String leader;

    private String leaderPhone;

    private Byte paymentCycle;

    private Byte paymentMode;

    private String contractSummary;

    private String accessory;

    private Integer createUserId;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    public Contract(Integer id, String orderNo, String contractName, Byte contractType, String contractDuration, String contractSubject, BigDecimal totalAmount, String contractParty, String address, String linkman, String linkmanPhone, String leader, String leaderPhone, Byte paymentCycle, Byte paymentMode, String contractSummary, String accessory, Integer createUserId, Byte isDelete, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.contractName = contractName;
        this.contractType = contractType;
        this.contractDuration = contractDuration;
        this.contractSubject = contractSubject;
        this.totalAmount = totalAmount;
        this.contractParty = contractParty;
        this.address = address;
        this.linkman = linkman;
        this.linkmanPhone = linkmanPhone;
        this.leader = leader;
        this.leaderPhone = leaderPhone;
        this.paymentCycle = paymentCycle;
        this.paymentMode = paymentMode;
        this.contractSummary = contractSummary;
        this.accessory = accessory;
        this.createUserId = createUserId;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Contract() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public Byte getContractType() {
        return contractType;
    }

    public void setContractType(Byte contractType) {
        this.contractType = contractType;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration == null ? null : contractDuration.trim();
    }

    public String getContractSubject() {
        return contractSubject;
    }

    public void setContractSubject(String contractSubject) {
        this.contractSubject = contractSubject == null ? null : contractSubject.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getContractParty() {
        return contractParty;
    }

    public void setContractParty(String contractParty) {
        this.contractParty = contractParty == null ? null : contractParty.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone == null ? null : linkmanPhone.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone == null ? null : leaderPhone.trim();
    }

    public Byte getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(Byte paymentCycle) {
        this.paymentCycle = paymentCycle;
    }

    public Byte getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Byte paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getContractSummary() {
        return contractSummary;
    }

    public void setContractSummary(String contractSummary) {
        this.contractSummary = contractSummary == null ? null : contractSummary.trim();
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory == null ? null : accessory.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
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
}