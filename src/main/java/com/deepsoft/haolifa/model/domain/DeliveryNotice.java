package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class DeliveryNotice {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private String deliveryUrl;

    private String deliveryNo;

    private Integer auditUserId;

    private String auditInfo;

    private Date auditTime;

    private Byte auditResult;

    public DeliveryNotice(Integer id, Date createTime, Date updateTime, Integer createUserId, String deliveryUrl, String deliveryNo, Integer auditUserId, String auditInfo, Date auditTime, Byte auditResult) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
        this.deliveryUrl = deliveryUrl;
        this.deliveryNo = deliveryNo;
        this.auditUserId = auditUserId;
        this.auditInfo = auditInfo;
        this.auditTime = auditTime;
        this.auditResult = auditResult;
    }

    public DeliveryNotice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getDeliveryUrl() {
        return deliveryUrl;
    }

    public void setDeliveryUrl(String deliveryUrl) {
        this.deliveryUrl = deliveryUrl == null ? null : deliveryUrl.trim();
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo == null ? null : deliveryNo.trim();
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo == null ? null : auditInfo.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Byte getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Byte auditResult) {
        this.auditResult = auditResult;
    }
}