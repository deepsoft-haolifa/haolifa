package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SprayColorRelation {
    private Integer id;

    private Byte type;

    private String color;

    private String relationNo;

    private Date createTime;

    private Date updateTime;

    public SprayColorRelation(Integer id, Byte type, String color, String relationNo, Date createTime, Date updateTime) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.relationNo = relationNo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SprayColorRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getRelationNo() {
        return relationNo;
    }

    public void setRelationNo(String relationNo) {
        this.relationNo = relationNo == null ? null : relationNo.trim();
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