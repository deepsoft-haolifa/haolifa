package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SysDict {
    private Integer id;

    private String typeCode;

    private String typeName;

    private String code;

    private String name;

    private Byte sortNo;

    private Byte status;

    private String dictDesc;

    private Date createTime;

    public SysDict(Integer id, String typeCode, String typeName, String code, String name, Byte sortNo, Byte status, String dictDesc, Date createTime) {
        this.id = id;
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.code = code;
        this.name = name;
        this.sortNo = sortNo;
        this.status = status;
        this.dictDesc = dictDesc;
        this.createTime = createTime;
    }

    public SysDict() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSortNo() {
        return sortNo;
    }

    public void setSortNo(Byte sortNo) {
        this.sortNo = sortNo;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc == null ? null : dictDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}