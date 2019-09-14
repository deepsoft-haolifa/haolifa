package com.deepsoft.haolifa.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ExpensesReport {
    private BigDecimal totalAmount;

    private String secondClassify;

    private String expensesClassify;

    @DateTimeFormat(pattern = "yyyy-MM")
    private String createTime;


    private String department;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSecondClassify() {
        return secondClassify;
    }

    public void setSecondClassify(String secondClassify) {
        this.secondClassify = secondClassify;
    }

    public String getExpensesClassify() {
        return expensesClassify;
    }

    public void setExpensesClassify(String expensesClassify) {
        this.expensesClassify = expensesClassify;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ExpensesReport(BigDecimal totalAmount, String secondClassify, String expensesClassify, String createTime, String department) {
        this.totalAmount = totalAmount;
        this.secondClassify = secondClassify;
        this.expensesClassify = expensesClassify;
        this.createTime = createTime;
        this.department = department;
    }
}