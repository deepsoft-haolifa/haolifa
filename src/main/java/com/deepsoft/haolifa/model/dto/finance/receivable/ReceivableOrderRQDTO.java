package com.deepsoft.haolifa.model.dto.finance.receivable;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
public class ReceivableOrderRQDTO  extends PageParam {

    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "需求方名称")
    private String demandName;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
 }


