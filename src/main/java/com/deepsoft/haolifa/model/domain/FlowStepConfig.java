package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FlowStepConfig {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private Integer stepId;

    private String approvalFieldName;

    private String englishName;

    private String type;

    public FlowStepConfig(Integer id, Date createTime, Date updateTime, Integer createUser, Integer updateUser, Integer stepId, String approvalFieldName, String englishName, String type) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.stepId = stepId;
        this.approvalFieldName = approvalFieldName;
        this.englishName = englishName;
        this.type = type;
    }

    public FlowStepConfig() {
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public String getApprovalFieldName() {
        return approvalFieldName;
    }

    public void setApprovalFieldName(String approvalFieldName) {
        this.approvalFieldName = approvalFieldName == null ? null : approvalFieldName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}