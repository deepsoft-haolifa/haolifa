package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class FileRecord {
    private Integer id;

    private String fileName;

    private String fileUrl;

    private Byte type;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String fileNo;

    public FileRecord(Integer id, String fileName, String fileUrl, Byte type, String remark, Date createTime, Date updateTime, String fileNo) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.type = type;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fileNo = fileNo;
    }

    public FileRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo == null ? null : fileNo.trim();
    }
}