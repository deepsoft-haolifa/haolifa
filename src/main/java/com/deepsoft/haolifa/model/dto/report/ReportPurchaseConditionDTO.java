package com.deepsoft.haolifa.model.dto.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 采购订单查询条件
 *
 * @author murphy.he
 **/
@Data
public class ReportPurchaseConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty("采购订单号")
    private String purchaseOrderNo;
    @ApiModelProperty("采购订单状态")
    private Integer status;
    @ApiModelProperty("供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "年")
    private String year;
}
