package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PayManagerCal {
    private Integer id;

    private String userName;

    private Integer departId;

    private String dept;

    private Integer postId;

    private String postName;

    private String project;

    private String idCategory;

    private String appModel;

    private String appSpecifications;

    private String workType;

    private BigDecimal price;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayManagerCal(Integer id, String userName, Integer departId, String dept, Integer postId, String postName, String project, String idCategory, String appModel, String appSpecifications, String workType, BigDecimal price, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.departId = departId;
        this.dept = dept;
        this.postId = postId;
        this.postName = postName;
        this.project = project;
        this.idCategory = idCategory;
        this.appModel = appModel;
        this.appSpecifications = appSpecifications;
        this.workType = workType;
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

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory == null ? null : idCategory.trim();
    }

    public String getAppModel() {
        return appModel;
    }

    public void setAppModel(String appModel) {
        this.appModel = appModel == null ? null : appModel.trim();
    }

    public String getAppSpecifications() {
        return appSpecifications;
    }

    public void setAppSpecifications(String appSpecifications) {
        this.appSpecifications = appSpecifications == null ? null : appSpecifications.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
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