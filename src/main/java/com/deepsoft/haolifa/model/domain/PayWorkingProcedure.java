package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayWorkingProcedure {
    private Integer id;

    private Integer serial;

    private String workshopName;

    private String workType;

    private String productModel;

    private String postName;

    private String postCapability;

    private String postCode;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayWorkingProcedure(Integer id, Integer serial, String workshopName, String workType, String productModel, String postName, String postCapability, String postCode, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.serial = serial;
        this.workshopName = workshopName;
        this.workType = workType;
        this.productModel = productModel;
        this.postName = postName;
        this.postCapability = postCapability;
        this.postCode = postCode;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayWorkingProcedure() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName == null ? null : workshopName.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getPostCapability() {
        return postCapability;
    }

    public void setPostCapability(String postCapability) {
        this.postCapability = postCapability == null ? null : postCapability.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
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
}