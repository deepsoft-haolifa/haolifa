package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class CustomerGraphNo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String customerCode;

    private String customerGraphNo;

    private String haoliGraphNo;

    public CustomerGraphNo(Integer id, Date createTime, Date updateTime, String customerCode, String customerGraphNo, String haoliGraphNo) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.customerCode = customerCode;
        this.customerGraphNo = customerGraphNo;
        this.haoliGraphNo = haoliGraphNo;
    }

    public CustomerGraphNo() {
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerGraphNo() {
        return customerGraphNo;
    }

    public void setCustomerGraphNo(String customerGraphNo) {
        this.customerGraphNo = customerGraphNo == null ? null : customerGraphNo.trim();
    }

    public String getHaoliGraphNo() {
        return haoliGraphNo;
    }

    public void setHaoliGraphNo(String haoliGraphNo) {
        this.haoliGraphNo = haoliGraphNo == null ? null : haoliGraphNo.trim();
    }
}