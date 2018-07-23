package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class InspectInfo {
    private Integer id;

    private String orderNo;

    private Byte type;

    private Byte state;

    private String inspectNo;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    public InspectInfo(Integer id, String orderNo, Byte type, Byte state, String inspectNo, Date createTime, Date updateTime, Integer createUserId) {
        this.id = id;
        this.orderNo = orderNo;
        this.type = type;
        this.state = state;
        this.inspectNo = inspectNo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUserId = createUserId;
    }

    public InspectInfo() {
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getInspectNo() {
        return inspectNo;
    }

    public void setInspectNo(String inspectNo) {
        this.inspectNo = inspectNo == null ? null : inspectNo.trim();
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
}