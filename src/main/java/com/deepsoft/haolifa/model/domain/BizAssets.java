package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BizAssets {
    /**
     *  ID
     */
    private Long id;
    /**
     *  资产名称
     */
    private String name;
    /**
     *  资产编号
     */
    private String bh;
    /**
     *  类别名称 数据字典ASSETS_TYPE
     */
    private String type;
    /**
     *  规格型号
     */
    private String specifications;
    /**
     *  资产数量
     */
    private Integer num;
    /**
     *  资产单位 个 条 把 台
     */
    private String unit;
    /**
     *  部门
     */
    private Integer deptId;
    /**
     *  领用人
     */
    private String userName;
    /**
     *  增加方式 数据字典ASSETS_ADD_TYPE
     */
    private String addType;
    /**
     *  存放地点
     */
    private String location;
    /**
     *  资产状态 数据字典
     */
    private String equipmentState;
    /**
     *  生产厂家
     */
    private String manufacturer;
    /**
     *  采购时间
     */
    private Date purchasingTime;
    /**
     *  采购金额
     */
    private BigDecimal price;
    /**
     *  采购总金额
     */
    private BigDecimal totalPrice;
    /**
     *  使用年限/年
     */
    private Integer useYear;
    /**
     *  折旧方法 数据字典DEPRECIATION_METHOD
     */
    private String depreciationMethod;
    /**
     *  开始使用日期
     */
    private Date startTime;
    /**
     *  已计提月份
     */
    private Integer accruedMonth;
    /**
     *  净产值率
     */
    private BigDecimal outputRate;
    /**
     *  净残值
     */
    private BigDecimal salvageValue;
    /**
     *  累计折旧
     */
    private BigDecimal accumulatedDepreciation;
    /**
     *  月折旧率
     */
    private BigDecimal monthRate;
    /**
     *  月折旧额
     */
    private BigDecimal monthDepreciation;
    /**
     *  净值
     */
    private BigDecimal netWorth;
    /**
     *  备用1
     */
    private String string1;
    /**
     *  备用2
     */
    private String string2;
    /**
     *  备用3
     */
    private String string3;
    /**
     *  备用4
     */
    private String string4;
    /**
     *  备用5
     */
    private String string5;
    /**
     *  备用6
     */
    private String string6;
    /**
     *  备用7
     */
    private String string7;
    /**
     *  备用8
     */
    private String string8;
    /**
     *  备用9
     */
    private String string9;
    /**
     *  备用10
     */
    private String string10;
    /**
     *  备注
     */
    private String remark;
    /**
     *  状态（0正常 1停用）
     */
    private String status;
    /**
     *  删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
    /**
     *  创建者
     */
    private String createBy;
    /**
     *  创建时间
     */
    private Date createTime;
    /**
     *  更新者
     */
    private String updateBy;
    /**
     *  更新时间
     */
    private Date updateTime;

    public BizAssets(Long id, String name, String bh, String type, String specifications, Integer num, String unit, Integer deptId, String userName, String addType, String location, String equipmentState, String manufacturer, Date purchasingTime, BigDecimal price, BigDecimal totalPrice, Integer useYear, String depreciationMethod, Date startTime, Integer accruedMonth, BigDecimal outputRate, BigDecimal salvageValue, BigDecimal accumulatedDepreciation, BigDecimal monthRate, BigDecimal monthDepreciation, BigDecimal netWorth, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String remark, String status, String delFlag, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.id = id;
        this.name = name;
        this.bh = bh;
        this.type = type;
        this.specifications = specifications;
        this.num = num;
        this.unit = unit;
        this.deptId = deptId;
        this.userName = userName;
        this.addType = addType;
        this.location = location;
        this.equipmentState = equipmentState;
        this.manufacturer = manufacturer;
        this.purchasingTime = purchasingTime;
        this.price = price;
        this.totalPrice = totalPrice;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getAccruedMonth() {
        return accruedMonth;
    }

    public void setAccruedMonth(Integer accruedMonth) {
        this.accruedMonth = accruedMonth;
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

    public BigDecimal getAccumulatedDepreciation() {
        return accumulatedDepreciation;
    }

    public void setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
        this.accumulatedDepreciation = accumulatedDepreciation;
    }

    public BigDecimal getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(BigDecimal monthRate) {
        this.monthRate = monthRate;
    }

    public BigDecimal getMonthDepreciation() {
        return monthDepreciation;
    }

    public void setMonthDepreciation(BigDecimal monthDepreciation) {
        this.monthDepreciation = monthDepreciation;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
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
