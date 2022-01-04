package com.deepsoft.haolifa.model.dto.finance.payplanlog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanPayLogDTO {

    @ApiModelProperty(value = "支付金额")
    private BigDecimal applyAmount;

    @ApiModelProperty(value = "支付方式")
    private String payWay;

    @ApiModelProperty(value = "记账方式")
    private String bookingType;

}
