package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class Spray {
    private Integer id;

    private String sprayNo;

    private String planner;

    private Integer totalNumber;

    private Integer qualifiedNumber;

    private Byte status;

    private String fileUrl;

    private Date createTime;

    private Date updateTime;

    private Byte inspectStatus;

    private Byte busType;

    private Byte taskStatus;

    public Spray(Integer id, String sprayNo, String planner, Integer totalNumber, Integer qualifiedNumber, Byte status, String fileUrl, Date createTime, Date updateTime, Byte inspectStatus, Byte busType, Byte taskStatus) {
        this.id = id;
        this.sprayNo = sprayNo;
        this.planner = planner;
        this.totalNumber = totalNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.status = status;
        this.fileUrl = fileUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.inspectStatus = inspectStatus;
        this.busType = busType;
        this.taskStatus = taskStatus;
    }

    public Spray() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSprayNo() {
        return sprayNo;
    }

    public void setSprayNo(String sprayNo) {
        this.sprayNo = sprayNo == null ? null : sprayNo.trim();
    }

    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner == null ? null : planner.trim();
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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

    public Byte getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(Byte inspectStatus) {
        this.inspectStatus = inspectStatus;
    }

    public Byte getBusType() {
        return busType;
    }

    public void setBusType(Byte busType) {
        this.busType = busType;
    }

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }
}