package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderReview {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String orderNo;

    private Date deliveryTime;

    private String reviewForm;

    private Integer techUser;

    private String techRemark;

    private Date techTime;

    private Integer storeUser;

    private String storeRemark;

    private Date storeReviewTime;

    private Integer purchaseUser;

    private String purchaseRemark;

    private Date purchaseTime;

    private Integer qualityUser;

    private String qualityRemark;

    private Date qualityTime;

    private Integer produceUser;

    private String produceRemark;

    private Date produceTime;

    private Integer manager;

    private String managerRemark;

    private Date managerTime;

    public OrderReview(Integer id, Date createTime, Date updateTime, String orderNo, Date deliveryTime, String reviewForm, Integer techUser, String techRemark, Date techTime, Integer storeUser, String storeRemark, Date storeReviewTime, Integer purchaseUser, String purchaseRemark, Date purchaseTime, Integer qualityUser, String qualityRemark, Date qualityTime, Integer produceUser, String produceRemark, Date produceTime, Integer manager, String managerRemark, Date managerTime) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.orderNo = orderNo;
        this.deliveryTime = deliveryTime;
        this.reviewForm = reviewForm;
        this.techUser = techUser;
        this.techRemark = techRemark;
        this.techTime = techTime;
        this.storeUser = storeUser;
        this.storeRemark = storeRemark;
        this.storeReviewTime = storeReviewTime;
        this.purchaseUser = purchaseUser;
        this.purchaseRemark = purchaseRemark;
        this.purchaseTime = purchaseTime;
        this.qualityUser = qualityUser;
        this.qualityRemark = qualityRemark;
        this.qualityTime = qualityTime;
        this.produceUser = produceUser;
        this.produceRemark = produceRemark;
        this.produceTime = produceTime;
        this.manager = manager;
        this.managerRemark = managerRemark;
        this.managerTime = managerTime;
    }

    public OrderReview() {
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getReviewForm() {
        return reviewForm;
    }

    public void setReviewForm(String reviewForm) {
        this.reviewForm = reviewForm == null ? null : reviewForm.trim();
    }

    public Integer getTechUser() {
        return techUser;
    }

    public void setTechUser(Integer techUser) {
        this.techUser = techUser;
    }

    public String getTechRemark() {
        return techRemark;
    }

    public void setTechRemark(String techRemark) {
        this.techRemark = techRemark == null ? null : techRemark.trim();
    }

    public Date getTechTime() {
        return techTime;
    }

    public void setTechTime(Date techTime) {
        this.techTime = techTime;
    }

    public Integer getStoreUser() {
        return storeUser;
    }

    public void setStoreUser(Integer storeUser) {
        this.storeUser = storeUser;
    }

    public String getStoreRemark() {
        return storeRemark;
    }

    public void setStoreRemark(String storeRemark) {
        this.storeRemark = storeRemark == null ? null : storeRemark.trim();
    }

    public Date getStoreReviewTime() {
        return storeReviewTime;
    }

    public void setStoreReviewTime(Date storeReviewTime) {
        this.storeReviewTime = storeReviewTime;
    }

    public Integer getPurchaseUser() {
        return purchaseUser;
    }

    public void setPurchaseUser(Integer purchaseUser) {
        this.purchaseUser = purchaseUser;
    }

    public String getPurchaseRemark() {
        return purchaseRemark;
    }

    public void setPurchaseRemark(String purchaseRemark) {
        this.purchaseRemark = purchaseRemark == null ? null : purchaseRemark.trim();
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getQualityUser() {
        return qualityUser;
    }

    public void setQualityUser(Integer qualityUser) {
        this.qualityUser = qualityUser;
    }

    public String getQualityRemark() {
        return qualityRemark;
    }

    public void setQualityRemark(String qualityRemark) {
        this.qualityRemark = qualityRemark == null ? null : qualityRemark.trim();
    }

    public Date getQualityTime() {
        return qualityTime;
    }

    public void setQualityTime(Date qualityTime) {
        this.qualityTime = qualityTime;
    }

    public Integer getProduceUser() {
        return produceUser;
    }

    public void setProduceUser(Integer produceUser) {
        this.produceUser = produceUser;
    }

    public String getProduceRemark() {
        return produceRemark;
    }

    public void setProduceRemark(String produceRemark) {
        this.produceRemark = produceRemark == null ? null : produceRemark.trim();
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public String getManagerRemark() {
        return managerRemark;
    }

    public void setManagerRemark(String managerRemark) {
        this.managerRemark = managerRemark == null ? null : managerRemark.trim();
    }

    public Date getManagerTime() {
        return managerTime;
    }

    public void setManagerTime(Date managerTime) {
        this.managerTime = managerTime;
    }
}