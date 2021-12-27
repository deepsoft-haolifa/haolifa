package com.deepsoft.haolifa.model.domain;

import com.deepsoft.haolifa.annotation.ExcelHandle;

import java.math.BigDecimal;
import java.util.Date;

public class PayHourQuota {
    private Integer id;

    private Integer serial;
    @ExcelHandle(name = "车间")
    private String workshopName;
    @ExcelHandle(name = "过程产品名称")
    private String productName;
    @ExcelHandle(name = "适用订单ID类别或委托单产品类别")
    private String idCategory;
    @ExcelHandle(name = "适用型号")
    private String appModel;
    @ExcelHandle(name = "适用规格")
    private String appSpecifications;
    @ExcelHandle(name = "工种类别")
    private String workType;
    @ExcelHandle(name = "工序名称")
    private String procedureName;
    @ExcelHandle(name = "岗位代码")
    private String postCode;
    @ExcelHandle(name = "工时定额（元）")
    private BigDecimal hourQuotaPrice;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public PayHourQuota(Integer id, Integer serial, String workshopName, String productName, String idCategory, String appModel, String appSpecifications, String workType, String procedureName, String postCode, BigDecimal hourQuotaPrice, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.serial = serial;
        this.workshopName = workshopName;
        this.productName = productName;
        this.idCategory = idCategory;
        this.appModel = appModel;
        this.appSpecifications = appSpecifications;
        this.workType = workType;
        this.procedureName = procedureName;
        this.postCode = postCode;
        this.hourQuotaPrice = hourQuotaPrice;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PayHourQuota() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName == null ? null : workshopName.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory == null ? null : idCategory.trim();
    }

    public String getAppModel() {
        return appModel;
    }

    public void setAppModel(String appModel) {
        this.appModel = appModel == null ? null : appModel.trim();
    }

    public String getAppSpecifications() {
        return appSpecifications;
    }

    public void setAppSpecifications(String appSpecifications) {
        this.appSpecifications = appSpecifications == null ? null : appSpecifications.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName == null ? null : procedureName.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public BigDecimal getHourQuotaPrice() {
        return hourQuotaPrice;
    }

    public void setHourQuotaPrice(BigDecimal hourQuotaPrice) {
        this.hourQuotaPrice = hourQuotaPrice;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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
}
