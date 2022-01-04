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

    @ApiModelProperty(value = Constant.ORDER_STATUS_DESC, name = "订单状态")
    private Byte orderStatus;

    //`delivery_date` varchar(64) NOT NULL DEFAULT '' COMMENT '交货日期',
    //  `contract_sign_date` varchar(32) NOT NULL DEFAULT '' COMMENT '合同签订日期',
    //
    @ApiModelProperty(value = "签订日期")
    private Date contractSignDate;

//    @ApiModelProperty(value = "归属部门")
//    private String de;

//    @ApiModelProperty(value = "发货时间")
//    private Date startDate;

    // `supply_agent_name` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方代理人',
    @ApiModelProperty(value = "供应方责任人")
    private String supplyAgentName;

//
//    @ApiModelProperty(value = "供应单位")
//    private String startDate;


//    @ApiModelProperty(value = "开始时间")
//    private Date startDate;
//
//    @ApiModelProperty(value = "结束时间")
//    private Date endDate;
 }


