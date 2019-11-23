package com.deepsoft.haolifa.model.domain;

/**
 * 质量报表
 */
public class QualityAuditReport {
    private Integer totalNum;
    private String  materialName;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    public QualityAuditReport() {
    }

    public QualityAuditReport(Integer totalNum, String materialName) {
        this.totalNum = totalNum;
        this.materialName = materialName;
    }
}
