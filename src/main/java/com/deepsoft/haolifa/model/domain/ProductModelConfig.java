package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class ProductModelConfig {
    private Integer id;

    private Date createTime;

    private String indexRule;

    private String materialGraphNoStr;

    private String materialGraphNoIndexof;

    private String materialType;

    private String productType;

    private String remark;

    public ProductModelConfig(Integer id, Date createTime, String indexRule, String materialGraphNoStr, String materialGraphNoIndexof, String materialType, String productType, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.indexRule = indexRule;
        this.materialGraphNoStr = materialGraphNoStr;
        this.materialGraphNoIndexof = materialGraphNoIndexof;
        this.materialType = materialType;
        this.productType = productType;
        this.remark = remark;
    }

    public ProductModelConfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIndexRule() {
        return indexRule;
    }

    public void setIndexRule(String indexRule) {
        this.indexRule = indexRule == null ? null : indexRule.trim();
    }

    public String getMaterialGraphNoStr() {
        return materialGraphNoStr;
    }

    public void setMaterialGraphNoStr(String materialGraphNoStr) {
        this.materialGraphNoStr = materialGraphNoStr == null ? null : materialGraphNoStr.trim();
    }

    public String getMaterialGraphNoIndexof() {
        return materialGraphNoIndexof;
    }

    public void setMaterialGraphNoIndexof(String materialGraphNoIndexof) {
        this.materialGraphNoIndexof = materialGraphNoIndexof == null ? null : materialGraphNoIndexof.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}