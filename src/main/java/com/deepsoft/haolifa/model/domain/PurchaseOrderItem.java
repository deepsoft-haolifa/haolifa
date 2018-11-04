package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;

public class PurchaseOrderItem {
    private Integer id;

    private String purchaseOrderNo;

    private String applyNo;

    private String materialName;

    private String materialGraphNo;

    private String specification;

    private String material;

    private String unit;

    private Integer number;

    private BigDecimal unitWeight;

    private BigDecimal unitPrice;

    private String remark;

    private String purpose;

    private Double valuation;

    public PurchaseOrderItem(Integer id, String purchaseOrderNo, String applyNo, String materialName, String materialGraphNo, String specification, String material, String unit, Integer number, BigDecimal unitWeight, BigDecimal unitPrice, String remark, String purpose, Double valuation) {
        this.id = id;
        this.purchaseOrderNo = purchaseOrderNo;
        this.applyNo = applyNo;
        this.materialName = materialName;
        this.materialGraphNo = materialGraphNo;
        this.specification = specification;
        this.material = material;
        this.unit = unit;
        this.number = number;
        this.unitWeight = unitWeight;
        this.unitPrice = unitPrice;
        this.remark = remark;
        this.purpose = purpose;
        this.valuation = valuation;
    }

    public PurchaseOrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(BigDecimal unitWeight) {
        this.unitWeight = unitWeight;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Double getValuation() {
        return valuation;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }
}