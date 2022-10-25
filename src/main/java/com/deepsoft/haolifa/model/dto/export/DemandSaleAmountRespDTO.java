package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 销售报表-按照需方统计
 *
 * @author murphy.he
 **/
@Data
public class DemandSaleAmountRespDTO {

    @ApiModelProperty(value = "客户名称")
    private String demandName;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "订货金额")
    private BigDecimal saleAmount;
    @ApiModelProperty(value = "发货金额")
    private BigDecimal deliveryAmount;
    @ApiModelProperty(value = "开票金额")
    private BigDecimal invoiceAmount;
    @ApiModelProperty(value = "回款金额")
    private BigDecimal collectAmount;
    @ApiModelProperty(value = "欠款金额")
    private BigDecimal oweMoneyAmount;
    @ApiModelProperty(value = "欠票金额")
    private BigDecimal oweTicketAmount;
}
