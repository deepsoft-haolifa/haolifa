package com.deepsoft.haolifa.model.dto.export;

import com.deepsoft.haolifa.constant.Constant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售报表-按照需方统计
 *
 * @author murphy.he
 **/
@Data
public class SaleOutputRespDTO {
    @ApiModelProperty(value = "接单日期")
    private Date createTime;

    @ApiModelProperty(value = "客户名称")
    private String demandName;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = Constant.ORDER_STATUS_DESC, name = "订单状态")
    private Byte orderStatus;

    @ApiModelProperty(value = "产品Id")
    private String productNo;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "系列")
    private String productModel;

    @ApiModelProperty(value = "规格")
    private String productSpecifications;

    @ApiModelProperty(value = "数量")
    private Integer quantity;
    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "金额")
    private BigDecimal totalPrice;
}
