package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class SupplierEvaluationInfo {
    private Integer id;

    private String supplierNum;

    private String qcWay;

    private String year;

    private Integer qualityScore;

    private String qualityPerson;

    private Date qualityDate;

    private Integer deliverScore;

    private String deliverPerson;

    private Date deliverScoreDate;

    private Integer otherScore;

    private String otherPerson;

    private Long otherScoreDate;

    private Date priceScore;

    private String pricePerson;

    private Date priceScoreDate;

    private Integer totalScore;

    private String totalPerson;

    private Date totalScoreDate;

    private String managerOpinions;

    private String managerPerson;

    private Date managerOpinionsDate;

    private String remark;

    private Byte isDelete;

    private Date createData;

    private Date updateDate;

    public SupplierEvaluationInfo(Integer id, String supplierNum, String qcWay, String year, Integer qualityScore, String qualityPerson, Date qualityDate, Integer deliverScore, String deliverPerson, Date deliverScoreDate, Integer otherScore, String otherPerson, Long otherScoreDate, Date priceScore, String pricePerson, Date priceScoreDate, Integer totalScore, String totalPerson, Date totalScoreDate, String managerOpinions, String managerPerson, Date managerOpinionsDate, String remark, Byte isDelete, Date createData, Date updateDate) {
        this.id = id;
        this.supplierNum = supplierNum;
        this.qcWay = qcWay;
        this.year = year;
        this.qualityScore = qualityScore;
        this.qualityPerson = qualityPerson;
        this.qualityDate = qualityDate;
        this.deliverScore = deliverScore;
        this.deliverPerson = deliverPerson;
        this.deliverScoreDate = deliverScoreDate;
        this.otherScore = otherScore;
        this.otherPerson = otherPerson;
        this.otherScoreDate = otherScoreDate;
        this.priceScore = priceScore;
        this.pricePerson = pricePerson;
        this.priceScoreDate = priceScoreDate;
        this.totalScore = totalScore;
        this.totalPerson = totalPerson;
        this.totalScoreDate = totalScoreDate;
        this.managerOpinions = managerOpinions;
        this.managerPerson = managerPerson;
        this.managerOpinionsDate = managerOpinionsDate;
        this.remark = remark;
        this.isDelete = isDelete;
        this.createData = createData;
        this.updateDate = updateDate;
    }

    public SupplierEvaluationInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(String supplierNum) {
        this.supplierNum = supplierNum == null ? null : supplierNum.trim();
    }

    public String getQcWay() {
        return qcWay;
    }

    public void setQcWay(String qcWay) {
        this.qcWay = qcWay == null ? null : qcWay.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(Integer qualityScore) {
        this.qualityScore = qualityScore;
    }

    public String getQualityPerson() {
        return qualityPerson;
    }

    public void setQualityPerson(String qualityPerson) {
        this.qualityPerson = qualityPerson == null ? null : qualityPerson.trim();
    }

    public Date getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        this.qualityDate = qualityDate;
    }

    public Integer getDeliverScore() {
        return deliverScore;
    }

    public void setDeliverScore(Integer deliverScore) {
        this.deliverScore = deliverScore;
    }

    public String getDeliverPerson() {
        return deliverPerson;
    }

    public void setDeliverPerson(String deliverPerson) {
        this.deliverPerson = deliverPerson == null ? null : deliverPerson.trim();
    }

    public Date getDeliverScoreDate() {
        return deliverScoreDate;
    }

    public void setDeliverScoreDate(Date deliverScoreDate) {
        this.deliverScoreDate = deliverScoreDate;
    }

    public Integer getOtherScore() {
        return otherScore;
    }

    public void setOtherScore(Integer otherScore) {
        this.otherScore = otherScore;
    }

    public String getOtherPerson() {
        return otherPerson;
    }

    public void setOtherPerson(String otherPerson) {
        this.otherPerson = otherPerson == null ? null : otherPerson.trim();
    }

    public Long getOtherScoreDate() {
        return otherScoreDate;
    }

    public void setOtherScoreDate(Long otherScoreDate) {
        this.otherScoreDate = otherScoreDate;
    }

    public Date getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(Date priceScore) {
        this.priceScore = priceScore;
    }

    public String getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(String pricePerson) {
        this.pricePerson = pricePerson == null ? null : pricePerson.trim();
    }

    public Date getPriceScoreDate() {
        return priceScoreDate;
    }

    public void setPriceScoreDate(Date priceScoreDate) {
        this.priceScoreDate = priceScoreDate;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getTotalPerson() {
        return totalPerson;
    }

    public void setTotalPerson(String totalPerson) {
        this.totalPerson = totalPerson == null ? null : totalPerson.trim();
    }

    public Date getTotalScoreDate() {
        return totalScoreDate;
    }

    public void setTotalScoreDate(Date totalScoreDate) {
        this.totalScoreDate = totalScoreDate;
    }

    public String getManagerOpinions() {
        return managerOpinions;
    }

    public void setManagerOpinions(String managerOpinions) {
        this.managerOpinions = managerOpinions == null ? null : managerOpinions.trim();
    }

    public String getManagerPerson() {
        return managerPerson;
    }

    public void setManagerPerson(String managerPerson) {
        this.managerPerson = managerPerson == null ? null : managerPerson.trim();
    }

    public Date getManagerOpinionsDate() {
        return managerOpinionsDate;
    }

    public void setManagerOpinionsDate(Date managerOpinionsDate) {
        this.managerOpinionsDate = managerOpinionsDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}