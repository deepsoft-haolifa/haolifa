package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PayManagerCal {
    private Integer id;

    private String userName;

    private String dept;

    private String postName;

    private String project;

    private String workType;

    private String idCategory;

    private String appSpecifications;

    private String appModel;

    private BigDecimal price;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayManagerCal(Integer id, String userName, String dept, String postName, String project, String workType, String idCategory, String appSpecifications, String appModel, BigDecimal price, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.dept = dept;
        this.postName = postName;
        this.project = project;
        this.workType = workType;
        this.idCategory = idCategory;
        this.appSpecifications = appSpecifications;
        this.appModel = appModel;
        this.price = price;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayManagerCal() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory == null ? null : idCategory.trim();
    }

    public String getAppSpecifications() {
        return appSpecifications;
    }

    public void setAppSpecifications(String appSpecifications) {
        this.appSpecifications = appSpecifications == null ? null : appSpecifications.trim();
    }

    public String getAppModel() {
        return appModel;
    }

    public void setAppModel(String appModel) {
        this.appModel = appModel == null ? null : appModel.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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