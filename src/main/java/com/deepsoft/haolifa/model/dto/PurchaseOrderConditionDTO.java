package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 采购订单查询条件
 *
 * @author murphy.he
 **/
@Data
public class PurchaseOrderConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty("采购订单号")
    private String orderNo;
    @ApiModelProperty("采购订单状态")
    private Integer status;
    @ApiModelProperty("供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "开始时间")
    private Date startDate;
    @ApiModelProperty(value = "结束时间")
    private Date endDate;
    @ApiModelProperty(value = "当前用户Id")
    private int createUserId;
    @ApiModelProperty(value = "年")
    private String year;
}
