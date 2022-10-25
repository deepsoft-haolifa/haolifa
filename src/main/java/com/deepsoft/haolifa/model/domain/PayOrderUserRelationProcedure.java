package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PayOrderUserRelationProcedure {
    private Integer id;

    private Integer userId;

    private String orderId;

    private Integer procedureId;

    private Integer productId;

    private BigDecimal hourPrice;

    private BigDecimal totalPrice;

    private Integer totalCount;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    private Byte moreUserFlag;

    public PayOrderUserRelationProcedure(Integer id, Integer userId, String orderId, Integer procedureId, Integer productId, BigDecimal hourPrice, BigDecimal totalPrice, Integer totalCount, String createUser, String updateUser, Date createTime, Date updateTime, Byte moreUserFlag) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.procedureId = procedureId;
        this.productId = productId;
        this.hourPrice = hourPrice;
        this.totalPrice = totalPrice;
        this.totalCount = totalCount;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.moreUserFlag = moreUserFlag;
    }

    public PayOrderUserRelationProcedure() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(BigDecimal hourPrice) {
        this.hourPrice = hourPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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

    public Byte getMoreUserFlag() {
        return moreUserFlag;
    }

    public void setMoreUserFlag(Byte moreUserFlag) {
        this.moreUserFlag = moreUserFlag;
    }
}