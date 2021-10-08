package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class PayAssessmentQuota {
    private Integer id;

    private String projectName;

    private String quotaName;

    private String quotaContent;

    private Integer score;

    private String standard;

    private String remark;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayAssessmentQuota(Integer id, String projectName, String quotaName, String quotaContent, Integer score, String standard, String remark, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.projectName = projectName;
        this.quotaName = quotaName;
        this.quotaContent = quotaContent;
        this.score = score;
        this.standard = standard;
        this.remark = remark;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayAssessmentQuota() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName == null ? null : quotaName.trim();
    }

    public String getQuotaContent() {
        return quotaContent;
    }

    public void setQuotaContent(String quotaContent) {
        this.quotaContent = quotaContent == null ? null : quotaContent.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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