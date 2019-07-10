package com.deepsoft.haolifa.model.dto.stormRoom;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 库存配置信息修改实体
 */
@Data
public class StockReqDTO {

    @ApiModelProperty(value = "成品号")
    private String productNo;

    @ApiModelProperty(value = "零件号")
    private String materialGraphNo;

    @ApiModelProperty(value = "出入库单价")
    private BigDecimal price;

    @ApiModelProperty(value = "库存类型（1.成品；2.零件）")
    private Integer type;

    @ApiModelProperty(value = "安全库存量")
    private Integer safeQuantity;

    @ApiModelProperty(value = "存库安全系数")
    private String safetyFactor;



}
