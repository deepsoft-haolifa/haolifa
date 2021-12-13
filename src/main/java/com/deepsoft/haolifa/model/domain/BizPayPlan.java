package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizPayPlan {
    private Integer id;

    private Long payDataId;

    private String applyNo;

    private Date applyDate;

    private String contractId;

    private String contractNo;

    private String contractPayWay;

    private String applyPayCompany;

    private String applyCollectionCompany;

    private BigDecimal applyAmount;

    private String payCompany;

    private String payAccount;

    private String payWay;

    private String paymentType;

    // `applyStatus`  DEFAULT '1' COMMENT '审核状态：1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成',
    private String applyStatus;

    //付款状态：0.未付；1.已付
    private String status;

    private Date payDate;

    private String bookingType;

    private String dataStatus;

    private String remark;

    private String delFlag;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

    public BizPayPlan(Integer id, Long payDataId, String applyNo, Date applyDate, String contractId, String contractNo, String contractPayWay, String applyPayCompany, String applyCollectionCompany, BigDecimal applyAmount, String payCompany, String payAccount, String payWay, String paymentType, String status, Date payDate, String bookingType, String dataStatus, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.payDataId = payDataId;
        this.applyNo = applyNo;
        this.applyDate = applyDate;
        this.contractId = contractId;
        this.contractNo = contractNo;
        this.contractPayWay = contractPayWay;
        this.applyPayCompany = applyPayCompany;
        this.applyCollectionCompany = applyCollectionCompany;
        this.applyAmount = applyAmount;
        this.payCompany = payCompany;
        this.payAccount = payAccount;
        this.payWay = payWay;
        this.paymentType = paymentType;
        this.status = status;
        this.payDate = payDate;
        this.bookingType = bookingType;
        this.dataStatus = dataStatus;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public BizPayPlan(Integer id, Long payDataId, String applyNo, Date applyDate, String contractId, String contractNo, String contractPayWay, String applyPayCompany, String applyCollectionCompany, BigDecimal applyAmount, String payCompany, String payAccount, String payWay, String paymentType, String applyStatus, String status, Date payDate, String bookingType, String dataStatus, String remark, String delFlag, Integer createUser, Date createTime, Integer updateUser, Date updateTime) {
        this.id = id;
        this.payDataId = payDataId;
        this.applyNo = applyNo;
        this.applyDate = applyDate;
        this.contractId = contractId;
        this.contractNo = contractNo;
        this.contractPayWay = contractPayWay;
        this.applyPayCompany = applyPayCompany;
        this.applyCollectionCompany = applyCollectionCompany;
        this.applyAmount = applyAmount;
        this.payCompany = payCompany;
        this.payAccount = payAccount;
        this.payWay = payWay;
        this.paymentType = paymentType;
        this.applyStatus = applyStatus;
        this.status = status;
        this.payDate = payDate;
        this.bookingType = bookingType;
        this.dataStatus = dataStatus;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public BizPayPlan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPayDataId() {
        return payDataId;
    }

    public void setPayDataId(Long payDataId) {
        this.payDataId = payDataId;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getContractPayWay() {
        return contractPayWay;
    }

    public void setContractPayWay(String contractPayWay) {
        this.contractPayWay = contractPayWay == null ? null : contractPayWay.trim();
    }

    public String getApplyPayCompany() {
        return applyPayCompany;
    }

    public void setApplyPayCompany(String applyPayCompany) {
        this.applyPayCompany = applyPayCompany == null ? null : applyPayCompany.trim();
    }

    public String getApplyCollectionCompany() {
        return applyCollectionCompany;
    }

    public void setApplyCollectionCompany(String applyCollectionCompany) {
        this.applyCollectionCompany = applyCollectionCompany == null ? null : applyCollectionCompany.trim();
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getPayCompany() {
        return payCompany;
    }

    public void setPayCompany(String payCompany) {
        this.payCompany = payCompany == null ? null : payCompany.trim();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType == null ? null : bookingType.trim();
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
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
