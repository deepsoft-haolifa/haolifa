package com.deepsoft.haolifa.model.dto.finance.receivable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class ReceivableOrderRSDTO {




    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "rs-合同编号")
    private String orderContractNo;

    @ApiModelProperty(value = "rs-需求方名称 客户名称")
    private String demandName;
    @ApiModelProperty(value = "rs-合同签订日期")
    private String contractSignDate;
    @ApiModelProperty(value = "s-数量合计")
    private Integer totalCount;
    @ApiModelProperty(value = "s-已发货数量")
    private Integer deliveredNumber;
    @ApiModelProperty(value = "s-总价 合同额")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "s-发货金额（发货数量*销售单价）")
    private BigDecimal deliveryAmount;
    @ApiModelProperty(value = "s-已收款金额")
    private BigDecimal receivedAccount;
    @ApiModelProperty(value = "s-已开票金额")
    private BigDecimal invoicedAmount;
    @ApiModelProperty(value = "s-应收款金额")
    private BigDecimal receivableAmount;

}


