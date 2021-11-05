package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class BizSubjects {
    private Integer id;
    private String name;
    private String type;
    private Integer parentId;
    private Integer level;
    private String code;
    private String remark;
    private String status;
    private String delFlag;
    private Double percent;
    private Integer createUser;
    private Integer updateUser;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Integer getCreateUser() {

        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
    public BizSubjects(Integer id, String name, String type, Integer parentId, Integer level, String code, String remark, String status, String delFlag, Double percent, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parentId = parentId;
        this.level = level;
        this.code = code;
        this.remark = remark;
        this.status = status;
        this.delFlag = delFlag;
        this.percent = percent;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {

        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
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

    public BizSubjects() {
        super();
    }
}
