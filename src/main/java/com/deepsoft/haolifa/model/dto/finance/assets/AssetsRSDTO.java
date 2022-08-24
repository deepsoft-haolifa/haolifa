package com.deepsoft.haolifa.model.dto.finance.assets;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetsRSDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "资产名称")
    private  String name;

    @ApiModelProperty(value = "资产编号")
    private  String bh;

    @ApiModelProperty(value = "类别名称 数据字典 ASSETS_TYPE")
    private  String type;

    @ApiModelProperty(value = "类别名称中文 数据字典 ASSETS_TYPE")
    private  String typeCN;

    @ApiModelProperty(value = "规格型号")
    private  String specifications;

    @ApiModelProperty(value = "资产数量")
    private  Integer num;
    /**
     *  资产单位 个 条 把 台
     */
    @ApiModelProperty(value = "资产单位 个 条 把 台")
    private String unit;

    @ApiModelProperty(value = "部门")
    private  Integer deptId;

    @ApiModelProperty(value = "部门名称")
    private  String deptName;

    @ApiModelProperty(value = "领用人")
    private  String userName;

    @ApiModelProperty(value = "增加方式 数据字典 ASSETS_ADD_TYPE")
    private  String addType;

    @ApiModelProperty(value = "增加方式中文 数据字典 ASSETS_ADD_TYPE")
    private  String addTypeCN;

    @ApiModelProperty(value = "存放地点")
    private  String location;

    @ApiModelProperty(value = "资产状态 数据字典 ？？")
    private  String equipmentState;

    @ApiModelProperty(value = "资产状态中文 数据字典 ？？")
    private  String equipmentStateCN;

    @ApiModelProperty(value = "生产厂家")
    private  String manufacturer;

    @ApiModelProperty(value = "采购时间")
    private  Date purchasingTime;

    @ApiModelProperty(value = "采购金额 （单价）")
    private  BigDecimal price;
    /**
     *  采购总金额
     */
    @ApiModelProperty(value = "采购总金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "使用年限")
    private  Integer useYear;

    @ApiModelProperty(value = "折旧方法 数据字典 DEPRECIATION_METHOD")
    private  String depreciationMethod;

    @ApiModelProperty(value = "折旧方法 数据字典 DEPRECIATION_METHOD")
    private  String depreciationMethodCN;

    @ApiModelProperty(value = "开始使用日期")
    private  Date startTime;

    @ApiModelProperty(value = "已计提月份")
    private  Integer accruedMonth;

    @ApiModelProperty(value = "净产值率")
    private  BigDecimal outputRate;

    @ApiModelProperty(value = "净残值")
    private  BigDecimal salvageValue;

    @ApiModelProperty(value = "累计折旧")
    private  BigDecimal accumulatedDepreciation;

    @ApiModelProperty(value = "月折旧率")
    private  BigDecimal monthRate;

    @ApiModelProperty(value = "月折旧额")
    private  BigDecimal monthDepreciation;

    @ApiModelProperty(value = "净值")
    private  BigDecimal netWorth;


    @ApiModelProperty(value = "备注")
    private  String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private  String status;

    @ApiModelProperty(value = "状态中文（0正常 1停用）")
    private  String statusCN;

    @ApiModelProperty(value = "")
    private  String createBy;

    @ApiModelProperty(value = "")
    private  Date createTime;

    @ApiModelProperty(value = "")
    private  String updateBy;

    @ApiModelProperty(value = "")
    private  Date updateTime;
}
