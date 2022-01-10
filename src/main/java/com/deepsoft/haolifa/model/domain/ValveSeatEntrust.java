package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ValveSeatEntrust {
    private Integer id;

    private String entrustNo;

    private String name;

    private String graphNo;

    private String specifications;

    private String model;

    private Integer qty;

    private Integer qualifiedNumber;

    private Byte status;

    private Byte inspectStatus;

    private Date createTime;

    private Date updateTime;

    public ValveSeatEntrust(Integer id, String entrustNo, String name, String graphNo, String specifications, String model, Integer qty, Integer qualifiedNumber, Byte status, Byte inspectStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.entrustNo = entrustNo;
        this.name = name;
        this.graphNo = graphNo;
        this.specifications = specifications;
        this.model = model;
        this.qty = qty;
        this.qualifiedNumber = qualifiedNumber;
        this.status = status;
        this.inspectStatus = inspectStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ValveSeatEntrust() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntrustNo() {
        return entrustNo;
    }

    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo == null ? null : entrustNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGraphNo() {
        return graphNo;
    }

    public void setGraphNo(String graphNo) {
        this.graphNo = graphNo == null ? null : graphNo.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(Byte inspectStatus) {
        this.inspectStatus = inspectStatus;
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