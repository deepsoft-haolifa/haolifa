package com.deepsoft.haolifa.model.domain;

/**
 * 质量报表
 */
public class QualityPressureReport {
    private Integer totalNum;
    private Integer qualifiedNumber;
    private Integer unqualifiedNumber;
    private String reason;

    public QualityPressureReport(Integer totalNum, Integer qualifiedNumber, Integer unqualifiedNumber, String reason) {
        this.totalNum = totalNum;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.reason = reason;
    }

    public String getReason() {

        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public QualityPressureReport() {
    }

    public QualityPressureReport(Integer totalNum, Integer qualifiedNumber, Integer unqualifiedNumber) {
        this.totalNum = totalNum;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
    }
}
