package com.deepsoft.haolifa.model.dto.report;

import com.deepsoft.haolifa.constant.Constant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class ReportOrderConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = Constant.ORDER_STATUS_DESC, name = "订单状态")
    private Byte orderStatus;
    @ApiModelProperty(value = "需求方名称")
    private String demandName;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "年")
    private String year;
    @ApiModelProperty(value = "发货状态:-1 全部 0 待发货（默认） 1 部分发货 2 发货完成")
    private Byte deliverStatus;

    @ApiModelProperty(value = "产品名称")
    private String productName;

}


