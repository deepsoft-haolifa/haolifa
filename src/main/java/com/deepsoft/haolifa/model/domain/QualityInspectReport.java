package com.deepsoft.haolifa.model.domain;

/**
 * 质量报表
 */
public class QualityInspectReport {
    private int totalNum;
    private int qualifiedNumber;
    private int unqualifiedNumber;
    private String supplierName;

    public QualityInspectReport(int totalNum, int qualifiedNumber, int unqualifiedNumber, String supplierName, String materialGraphName) {
        this.totalNum = totalNum;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.supplierName = supplierName;
        this.materialGraphName = materialGraphName;
    }

    public String getMaterialGraphName() {

        return materialGraphName;
    }

    public void setMaterialGraphName(String materialGraphName) {
        this.materialGraphName = materialGraphName;
    }

    private String materialGraphName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

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

    public QualityInspectReport(int totalNum, int qualifiedNumber, int unqualifiedNumber, String supplierName) {
        this.totalNum = totalNum;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.supplierName = supplierName;
    }

    public QualityInspectReport(int totalNum, int qualifiedNumber, int unqualifiedNumber) {
        this.totalNum = totalNum;
        this.qualifiedNumber = qualifiedNumber;
        this.unqualifiedNumber = unqualifiedNumber;
    }
}
