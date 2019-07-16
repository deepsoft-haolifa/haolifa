package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class EntrustGraphNoRelation {
    private Integer id;

    private String materialName;

    private String originalGraphNo;

    private String processedGraphNo;

    private Date createTime;

    private Date updateTime;

    public EntrustGraphNoRelation(Integer id, String materialName, String originalGraphNo, String processedGraphNo, Date createTime, Date updateTime) {
        this.id = id;
        this.materialName = materialName;
        this.originalGraphNo = originalGraphNo;
        this.processedGraphNo = processedGraphNo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public EntrustGraphNoRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getOriginalGraphNo() {
        return originalGraphNo;
    }

    public void setOriginalGraphNo(String originalGraphNo) {
        this.originalGraphNo = originalGraphNo == null ? null : originalGraphNo.trim();
    }

    public String getProcessedGraphNo() {
        return processedGraphNo;
    }

    public void setProcessedGraphNo(String processedGraphNo) {
        this.processedGraphNo = processedGraphNo == null ? null : processedGraphNo.trim();
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