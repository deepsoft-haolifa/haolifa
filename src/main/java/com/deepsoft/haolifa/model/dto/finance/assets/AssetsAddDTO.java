package com.deepsoft.haolifa.model.dto.finance.assets;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetsAddDTO {

    @ApiModelProperty(value = "资产名称(手动录入)")
    private String name;

    @ApiModelProperty(value = "资产编号(手动录入)")
    private String bh;

    @ApiModelProperty(value = "规格型号(手动录入)")
    private String specifications;

    @ApiModelProperty(value = "资产类别 数据字典 ASSETS_TYPE")
    private String type;

    @ApiModelProperty(value = "生产厂家(手动录入)")
    private String manufacturer;

    @ApiModelProperty(value = "增加方式 数据字典 ASSETS_ADD_TYPE")
    private String addType;


    @ApiModelProperty(value = "使用部门 (关联部门列表供选择)")
    private Integer deptId;


    @ApiModelProperty(value = "领用人 (关联上面选择部门归属下的人员列表)")
    private String userName;

    @ApiModelProperty(value = "存放地点 (手动录入)")
    private String location;


    @ApiModelProperty(value = "数量 (手动录入)")
    private Integer num;

    /**
     * 资产单位 个 条 把 台
     */
    @ApiModelProperty(value = "单位 (手动录入)(个 条 把 台)")
    private String unit;

    @ApiModelProperty(value = "采购单价 (手动录入)")
    private BigDecimal price;

    /**
     * 采购总金额
     */
    @ApiModelProperty(value = "采购金额 (自动计算（=数量*采购单价）)")
    private BigDecimal totalPrice;


    @ApiModelProperty(value = "采购时间 (手动录入，时间框选择)")
    private Date purchasingTime;


    @ApiModelProperty(value = "开始使用日期 (手动录入，时间框选择)")
    private Date startTime;


    @ApiModelProperty(value = "净残值率 (手动录入（百分比数据）)")
    private BigDecimal outputRate;


//    @ApiModelProperty(value = "净残值 (自动计算（=采购金额*净残值率）)")
//    private BigDecimal salvageValue;


    @ApiModelProperty(value = "使用年限/年 (手动录入)")
    private Integer useYear;


    /***
     * 平均年限法
     * 工作量法
     * 双倍余额递减法
     * 年数总和折旧法
     * （把前面四种方法做成数据字典供选择），需要做一个数据字典，系统现在没有
     */
    @ApiModelProperty(value = "折旧方法 () 数据字典 DEPRECIATION_METHOD")
    private String depreciationMethod;


    /***
     * "自动计算
     * 如果选择平均年限法，对应的计算公式是：
     * 月折旧额=采购金额*（1－净残值率）/使用年限/12*100%
     *
     * 如果选择双倍余额递减法，对应的计算公式是：
     * 月折旧额=净值*2/使用年限*100%/12"
     *
     * 现在只做这两种折旧公式即可，其它的那两种后续再说
     */
//    @ApiModelProperty(value = "月折旧额 (自动计算)")
//    private BigDecimal monthDepreciation;


// 这三个字段的值每月更新一次，列表右上角做一个更新按钮，每月26日执行一下自动更新任务，当净值小于或等于净残值时，不计提折旧，或者是做成系统自动更新功能

//    @ApiModelProperty(value = "已计提月份 (自动计算（数据更新系统时间-开始使用时间）)")
//    private Integer accruedMonth;
//
//    @ApiModelProperty(value = "累计折旧 (自动计算（已计提月份*月折旧额）)")
//    private BigDecimal accumulatedDepreciation;
//
//
//    @ApiModelProperty(value = "净值 (自动计算（=采购金额-累计折旧额）)")
//    private BigDecimal netWorth;


    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;


    @ApiModelProperty(value = "备注 ()")
    private String remark;


}
