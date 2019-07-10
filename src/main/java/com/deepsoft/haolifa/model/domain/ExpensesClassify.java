package com.deepsoft.haolifa.model.domain;

public class ExpensesClassify {
    private Integer id;

    private String classifyName;

    private Integer classifyPid;

    public ExpensesClassify(Integer id, String classifyName, Integer classifyPid) {
        this.id = id;
        this.classifyName = classifyName;
        this.classifyPid = classifyPid;
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

    public Integer getClassifyPid() {
        return classifyPid;
    }

    public void setClassifyPid(Integer classifyPid) {
        this.classifyPid = classifyPid;
    }
}