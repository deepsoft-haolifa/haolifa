package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;

public class InspectItem {
    private Integer id;

    private String purchaseNo;

    private Integer inspectId;

    private String materialGraphNo;

    private String materialName;

    private String specification;

    private Integer purchaseNumber;

    private Integer deliveryNumber;

    private Integer unqualifiedNumber;

    private Integer qualifiedNumber;

    private BigDecimal purchasePrice;

    private String requirements;

    private String unit;

    private String supplierName;

    private String supplierNo;

    private String remark;

    public InspectItem(Integer id, String purchaseNo, Integer inspectId, String materialGraphNo, String materialName, String specification, Integer purchaseNumber, Integer deliveryNumber, Integer unqualifiedNumber, Integer qualifiedNumber, BigDecimal purchasePrice, String requirements, String unit, String supplierName, String supplierNo, String remark) {
        this.id = id;
        this.purchaseNo = purchaseNo;
        this.inspectId = inspectId;
        this.materialGraphNo = materialGraphNo;
        this.materialName = materialName;
        this.specification = specification;
        this.purchaseNumber = purchaseNumber;
        this.deliveryNumber = deliveryNumber;
        this.unqualifiedNumber = unqualifiedNumber;
        this.qualifiedNumber = qualifiedNumber;
        this.purchasePrice = purchasePrice;
        this.requirements = requirements;
        this.unit = unit;
        this.supplierName = supplierName;
        this.supplierNo = supplierNo;
        this.remark = remark;
    }

    public InspectItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }

    public Integer getInspectId() {
        return inspectId;
    }

    public void setInspectId(Integer inspectId) {
        this.inspectId = inspectId;
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Integer getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Integer deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public Integer getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(Integer unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements == null ? null : requirements.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}