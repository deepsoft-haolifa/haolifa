package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class CustomerModelRelation {
    private Integer id;

    private String customerNo;

    private String customerModelNo;

    private String haoliModelNo;

    private Date createTime;

    private Date updateTime;

    public CustomerModelRelation(Integer id, String customerNo, String customerModelNo, String haoliModelNo, Date createTime, Date updateTime) {
        this.id = id;
        this.customerNo = customerNo;
        this.customerModelNo = customerModelNo;
        this.haoliModelNo = haoliModelNo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CustomerModelRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public String getCustomerModelNo() {
        return customerModelNo;
    }

    public void setCustomerModelNo(String customerModelNo) {
        this.customerModelNo = customerModelNo == null ? null : customerModelNo.trim();
    }

    public String getHaoliModelNo() {
        return haoliModelNo;
    }

    public void setHaoliModelNo(String haoliModelNo) {
        this.haoliModelNo = haoliModelNo == null ? null : haoliModelNo.trim();
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