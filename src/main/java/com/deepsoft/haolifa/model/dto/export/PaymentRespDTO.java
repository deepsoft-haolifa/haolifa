package com.deepsoft.haolifa.model.dto.export;

import com.deepsoft.haolifa.constant.Constant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售回款返回实体
 *
 * @author murphy.he
 **/
@Data
public class PaymentRespDTO {
    @ApiModelProperty(value = "接单日期")
    private Date createTime;

    @ApiModelProperty(value = "客户名称")
    private String demandName;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = Constant.ORDER_STATUS_DESC, name = "订单状态")
    private Byte orderStatus;

    @ApiModelProperty(value = "发货状态：0 待发货（默认） 1 部分发货 2 发货完成")
    private Byte deliverStatus;

    @ApiModelProperty(value = "金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "交货日期")
    private String deliveryDate;

    @ApiModelProperty(value = "回款金额")
    private BigDecimal collectionAmount;

    @ApiModelProperty(value = "回款日期")
    private String collectionDate;

    @ApiModelProperty(value = "欠款金额")
    private BigDecimal owedAmount;
}
