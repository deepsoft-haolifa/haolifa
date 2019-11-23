package com.deepsoft.haolifa.model.domain;

/**
 * 质量报表
 */
public class QualityInspectReport {
    private int totalNum;
    private int qualifiedNumber;
    private int unqualifiedNumber;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(int qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public int getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(int unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public QualityInspectReport() {
    }

    public QualityInspectReport(int totalNum, int qualifiedNumber, int unqualifiedNumber) {
        this.totalNum = totalNum;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
    }
}
