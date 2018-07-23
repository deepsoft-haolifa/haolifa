package com.deepsoft.haolifa.model.domain;

public class PurchaseOrderItemInfo {
    private Integer id;

    private String orderNo;

    private Long productId;

    private String productName;

    private String materialGraphNo;

    private String specification;

    private String material;

    private String unit;

    private Integer number;

    private Integer unitWeight;

    private Integer unitPrice;

    private String remark;

    public PurchaseOrderItemInfo(Integer id, String orderNo, Long productId, String productName, String materialGraphNo, String specification, String material, String unit, Integer number, Integer unitWeight, Integer unitPrice, String remark) {
        this.id = id;
        this.orderNo = orderNo;
        this.productId = productId;
        this.productName = productName;
        this.materialGraphNo = materialGraphNo;
        this.specification = specification;
        this.material = material;
        this.unit = unit;
        this.number = number;
        this.unitWeight = unitWeight;
        this.unitPrice = unitPrice;
        this.remark = remark;
    }

    public PurchaseOrderItemInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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

    public Integer getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Integer unitWeight) {
        this.unitWeight = unitWeight;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}