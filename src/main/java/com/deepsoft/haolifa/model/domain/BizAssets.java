package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizAssets {
    private Long id;

    private String name;

    private String bh;

    private String specifications;

    private String type;

    private String manufacturer;

    private String addType;

    private Integer deptId;

    private String userName;

    private String location;

    private Integer num;

    private String unit;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private Date purchasingTime;

    private Date startTime;

    private BigDecimal outputRate;

    private BigDecimal salvageValue;

    private Integer useYear;

    private String depreciationMethod;

    private BigDecimal monthDepreciation;

    private Integer accruedMonth;

    private BigDecimal accumulatedDepreciation;

    private BigDecimal netWorth;

    private String status;

    private String remark;

    private String delFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public BizAssets(Long id, String name, String bh, String specifications, String type, String manufacturer, String addType, Integer deptId, String userName, String location, Integer num, String unit, BigDecimal price, BigDecimal totalPrice, Date purchasingTime, Date startTime, BigDecimal outputRate, BigDecimal salvageValue, Integer useYear, String depreciationMethod, BigDecimal monthDepreciation, Integer accruedMonth, BigDecimal accumulatedDepreciation, BigDecimal netWorth, String status, String remark, String delFlag, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.id = id;
        this.name = name;
        this.bh = bh;
        this.specifications = specifications;
        this.type = type;
        this.manufacturer = manufacturer;
        this.addType = addType;
        this.deptId = deptId;
        this.userName = userName;
        this.location = location;
        this.num = num;
        this.unit = unit;
        this.price = price;
        this.totalPrice = totalPrice;
        this.purchasingTime = purchasingTime;
        this.startTime = startTime;
        this.outputRate = outputRate;
        this.salvageValue = salvageValue;
        this.useYear = useYear;
        this.depreciationMethod = depreciationMethod;
        this.monthDepreciation = monthDepreciation;
        this.accruedMonth = accruedMonth;
        this.accumulatedDepreciation = accumulatedDepreciation;
        this.netWorth = netWorth;
        this.status = status;
        this.remark = remark;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public BizAssets() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType == null ? null : addType.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPurchasingTime() {
        return purchasingTime;
    }

    public void setPurchasingTime(Date purchasingTime) {
        this.purchasingTime = purchasingTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getOutputRate() {
        return outputRate;
    }

    public void setOutputRate(BigDecimal outputRate) {
        this.outputRate = outputRate;
    }

    public BigDecimal getSalvageValue() {
        return salvageValue;
    }

    public void setSalvageValue(BigDecimal salvageValue) {
        this.salvageValue = salvageValue;
    }

    public Integer getUseYear() {
        return useYear;
    }

    public void setUseYear(Integer useYear) {
        this.useYear = useYear;
    }

    public String getDepreciationMethod() {
        return depreciationMethod;
    }

    public void setDepreciationMethod(String depreciationMethod) {
        this.depreciationMethod = depreciationMethod == null ? null : depreciationMethod.trim();
    }

    public BigDecimal getMonthDepreciation() {
        return monthDepreciation;
    }

    public void setMonthDepreciation(BigDecimal monthDepreciation) {
        this.monthDepreciation = monthDepreciation;
    }

    public Integer getAccruedMonth() {
        return accruedMonth;
    }

    public void setAccruedMonth(Integer accruedMonth) {
        this.accruedMonth = accruedMonth;
    }

    public BigDecimal getAccumulatedDepreciation() {
        return accumulatedDepreciation;
    }

    public void setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
        this.accumulatedDepreciation = accumulatedDepreciation;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}