package com.deepsoft.haolifa.model.dto.finance.assets;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetsUpDTO {

    @ApiModelProperty(value = "ID")
    private Long assetsId;


    @ApiModelProperty(value = "设备名称")
    private  String name;

    @ApiModelProperty(value = "设备编号")
    private  String bh;

    @ApiModelProperty(value = "类别名称 数据字典 ??")
    private  String type;

    @ApiModelProperty(value = "规格型号")
    private  String specifications;

    @ApiModelProperty(value = "设备数量")
    private  String num;

    @ApiModelProperty(value = "部门")
    private  String deptId;

    @ApiModelProperty(value = "领用人")
    private  String userName;

    @ApiModelProperty(value = "增加方式 数据字典 ？？")
    private  String addType;

    @ApiModelProperty(value = "存放地点")
    private  String location;

    @ApiModelProperty(value = "设备状态 数据字典 ？？")
    private  String equipmentState;

    @ApiModelProperty(value = "生产厂家")
    private  String manufacturer;

    @ApiModelProperty(value = "采购时间")
    private  Date purchasingTime;

    @ApiModelProperty(value = "采购金额")
    private  BigDecimal price;

    @ApiModelProperty(value = "使用年限")
    private  String useYear;

    @ApiModelProperty(value = "折旧方法")
    private  String depreciationMethod;

    @ApiModelProperty(value = "开始使用日期")
    private  Date startTime;

    @ApiModelProperty(value = "已计提月份")
    private  String accruedMonth;

    @ApiModelProperty(value = "净产值率")
    private  String outputRate;

    @ApiModelProperty(value = "净残值")
    private  String salvageValue;

    @ApiModelProperty(value = "累计折旧")
    private  String accumulatedDepreciation;

    @ApiModelProperty(value = "月折旧率")
    private  String monthRate;

    @ApiModelProperty(value = "月折旧额")
    private  String monthDepreciation;

    @ApiModelProperty(value = "净值")
    private  String netWorth;


    @ApiModelProperty(value = "备注")
    private  String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private  String status;



}
