package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysDepartment {
    private Integer id;

    private String deptName;

    private String description;

    private Integer pid;

    private Byte isDelete;

    private Date createTime;

    private Date updateTime;

    public SysDepartment(Integer id, String deptName, String description, Integer pid, Byte isDelete, Date createTime, Date updateTime) {
        this.id = id;
        this.deptName = deptName;
        this.description = description;
        this.pid = pid;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysDepartment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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