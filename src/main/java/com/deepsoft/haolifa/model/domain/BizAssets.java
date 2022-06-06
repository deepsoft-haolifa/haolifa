package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizAssets {
    private Long assetsId;

    private String name;

    private String bh;

    private String type;

    private String specifications;

    private String num;

    private String deptId;

    private String userName;

    private String addType;

    private String location;

    private String equipmentState;

    private String manufacturer;

    private Date purchasingTime;

    private BigDecimal price;

    private String useYear;

    private String depreciationMethod;

    private Date startTime;

    private String accruedMonth;

    private String outputRate;

    private String salvageValue;

    private String accumulatedDepreciation;

    private String monthRate;

    private String monthDepreciation;

    private String netWorth;

    private String string1;

    private String string2;

    private String string3;

    private String string4;

    private String string5;

    private String string6;

    private String string7;

    private String string8;

    private String string9;

    private String string10;

    private String remark;

    private String status;

    private String delFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public BizAssets(Long assetsId, String name, String bh, String type, String specifications, String num, String deptId, String userName, String addType, String location, String equipmentState, String manufacturer, Date purchasingTime, BigDecimal price, String useYear, String depreciationMethod, Date startTime, String accruedMonth, String outputRate, String salvageValue, String accumulatedDepreciation, String monthRate, String monthDepreciation, String netWorth, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String remark, String status, String delFlag, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.assetsId = assetsId;
        this.name = name;
        this.bh = bh;
        this.type = type;
        this.specifications = specifications;
        this.num = num;
        this.deptId = deptId;
        this.userName = userName;
        this.addType = addType;
        this.location = location;
        this.equipmentState = equipmentState;
        this.manufacturer = manufacturer;
        this.purchasingTime = purchasingTime;
        this.price = price;
        this.useYear = useYear;
        this.depreciationMethod = depreciationMethod;
        this.startTime = startTime;
        this.accruedMonth = accruedMonth;
        this.outputRate = outputRate;
        this.salvageValue = salvageValue;
        this.accumulatedDepreciation = accumulatedDepreciation;
        this.monthRate = monthRate;
        this.monthDepreciation = monthDepreciation;
        this.netWorth = netWorth;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
        this.string6 = string6;
        this.string7 = string7;
        this.string8 = string8;
        this.string9 = string9;
        this.string10 = string10;
        this.remark = remark;
        this.status = status;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public BizAssets() {
        super();
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType == null ? null : addType.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState == null ? null : equipmentState.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Date getPurchasingTime() {
        return purchasingTime;
    }

    public void setPurchasingTime(Date purchasingTime) {
        this.purchasingTime = purchasingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUseYear() {
        return useYear;
    }

    public void setUseYear(String useYear) {
        this.useYear = useYear == null ? null : useYear.trim();
    }

    public String getDepreciationMethod() {
        return depreciationMethod;
    }

    public void setDepreciationMethod(String depreciationMethod) {
        this.depreciationMethod = depreciationMethod == null ? null : depreciationMethod.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getAccruedMonth() {
        return accruedMonth;
    }

    public void setAccruedMonth(String accruedMonth) {
        this.accruedMonth = accruedMonth == null ? null : accruedMonth.trim();
    }

    public String getOutputRate() {
        return outputRate;
    }

    public void setOutputRate(String outputRate) {
        this.outputRate = outputRate == null ? null : outputRate.trim();
    }

    public String getSalvageValue() {
        return salvageValue;
    }

    public void setSalvageValue(String salvageValue) {
        this.salvageValue = salvageValue == null ? null : salvageValue.trim();
    }

    public String getAccumulatedDepreciation() {
        return accumulatedDepreciation;
    }

    public void setAccumulatedDepreciation(String accumulatedDepreciation) {
        this.accumulatedDepreciation = accumulatedDepreciation == null ? null : accumulatedDepreciation.trim();
    }

    public String getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(String monthRate) {
        this.monthRate = monthRate == null ? null : monthRate.trim();
    }

    public String getMonthDepreciation() {
        return monthDepreciation;
    }

    public void setMonthDepreciation(String monthDepreciation) {
        this.monthDepreciation = monthDepreciation == null ? null : monthDepreciation.trim();
    }

    public String getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth == null ? null : netWorth.trim();
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1 == null ? null : string1.trim();
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2 == null ? null : string2.trim();
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3 == null ? null : string3.trim();
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4 == null ? null : string4.trim();
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5 == null ? null : string5.trim();
    }

    public String getString6() {
        return string6;
    }

    public void setString6(String string6) {
        this.string6 = string6 == null ? null : string6.trim();
    }

    public String getString7() {
        return string7;
    }

    public void setString7(String string7) {
        this.string7 = string7 == null ? null : string7.trim();
    }

    public String getString8() {
        return string8;
    }

    public void setString8(String string8) {
        this.string8 = string8 == null ? null : string8.trim();
    }

    public String getString9() {
        return string9;
    }

    public void setString9(String string9) {
        this.string9 = string9 == null ? null : string9.trim();
    }

    public String getString10() {
        return string10;
    }

    public void setString10(String string10) {
        this.string10 = string10 == null ? null : string10.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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