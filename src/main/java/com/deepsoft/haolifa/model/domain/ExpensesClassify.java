package com.deepsoft.haolifa.model.domain;

public class ExpensesClassify {
    private Integer id;

    private String classifyName;

    public ExpensesClassify(Integer id, String classifyName) {
        this.id = id;
        this.classifyName = classifyName;
    }

    public ExpensesClassify() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }
}