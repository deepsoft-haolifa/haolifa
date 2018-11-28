package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
public class DeliveryRecordConditionDTO {

    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 0;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "合同/订单号")
    private String contractOrderNo;
    @ApiModelProperty(value = "承运单位")
    private String transportCompany;
    @ApiModelProperty(value = "运单号")
    private String courierNo;
    @ApiModelProperty(value = "客户代号")
    private String customerNo;
    @ApiModelProperty(value = "发货分类")
    private Byte deliveryClassify = 0;
    @ApiModelProperty(value = "开始日期")
    private Date startDeliveryTime;
    @ApiModelProperty(value = "结束日期")
    private Date endDeliveryTime;
}
