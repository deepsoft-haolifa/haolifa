package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SupplierEquipmentInfo {
    private Integer id;

    private String name;

    private Integer number;

    private Byte type;

    private String specification;

    private String supplierNo;

    private String productFactory;

    private Integer servicedYears;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    public SupplierEquipmentInfo(Integer id, String name, Integer number, Byte type, String specification, String supplierNo, String productFactory, Integer servicedYears, Date createTime, Date updateTime, Byte isDelete, Integer createUserId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.type = type;
        this.specification = specification;
        this.supplierNo = supplierNo;
        this.productFactory = productFactory;
        this.servicedYears = servicedYears;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.createUserId = createUserId;
    }

    public SupplierEquipmentInfo() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public String getProductFactory() {
        return productFactory;
    }

    public void setProductFactory(String productFactory) {
        this.productFactory = productFactory == null ? null : productFactory.trim();
    }

    public Integer getServicedYears() {
        return servicedYears;
    }

    public void setServicedYears(Integer servicedYears) {
        this.servicedYears = servicedYears;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}