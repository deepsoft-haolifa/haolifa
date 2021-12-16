package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 零星物料出，入库实体
 *
 * @author murphy.he
 **/
@Data
public class DemandAmountDto {

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "需方")
    private String demandName;

    @ApiModelProperty(value = "销售总金额")
    private BigDecimal saleAmount;

    @ApiModelProperty(value = "开票总金额")
    private BigDecimal invoiceAmount;

    @ApiModelProperty(value = "发货总金额")
    private BigDecimal deliveryAmount;

    @ApiModelProperty(value = "回款总金额")
    private BigDecimal refundAmount;

}
