package com.deepsoft.haolifa.model.domain;

public class ProductPurchaseRecord {
    private Integer id;

    private String purchasePlanNo;

    private String productOrderNo;

    private String materialGraphNo;

    private String applyBuyNo;

    private String purchaseOrderNo;

    private Byte stockStatus;

    private Byte purchaseOrderStatus;

    public ProductPurchaseRecord(Integer id, String purchasePlanNo, String productOrderNo, String materialGraphNo, String applyBuyNo, String purchaseOrderNo, Byte stockStatus, Byte purchaseOrderStatus) {
        this.id = id;
        this.purchasePlanNo = purchasePlanNo;
        this.productOrderNo = productOrderNo;
        this.materialGraphNo = materialGraphNo;
        this.applyBuyNo = applyBuyNo;
        this.purchaseOrderNo = purchaseOrderNo;
        this.stockStatus = stockStatus;
        this.purchaseOrderStatus = purchaseOrderStatus;
    }

    public ProductPurchaseRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchasePlanNo() {
        return purchasePlanNo;
    }

    public void setPurchasePlanNo(String purchasePlanNo) {
        this.purchasePlanNo = purchasePlanNo == null ? null : purchasePlanNo.trim();
    }

    public String getProductOrderNo() {
        return productOrderNo;
    }

    public void setProductOrderNo(String productOrderNo) {
        this.productOrderNo = productOrderNo == null ? null : productOrderNo.trim();
    }

    public String getMaterialGraphNo() {
        return materialGraphNo;
    }

    public void setMaterialGraphNo(String materialGraphNo) {
        this.materialGraphNo = materialGraphNo == null ? null : materialGraphNo.trim();
    }

    public String getApplyBuyNo() {
        return applyBuyNo;
    }

    public void setApplyBuyNo(String applyBuyNo) {
        this.applyBuyNo = applyBuyNo == null ? null : applyBuyNo.trim();
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public Byte getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Byte stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Byte getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(Byte purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
    }
}