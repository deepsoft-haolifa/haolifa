package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import lombok.EqualsAndHashCode;

/**
 * 入库零件实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EntryMaterialStorageDTO extends BaseStorageDTO {

    @ApiModelProperty(value = "零件号", required = true)
    private String materialGraphNo;

    @ApiModelProperty(value = "入库数量（正数）", required = true)
    private Integer quantity;

    @ApiModelProperty(value = "零件购买单价")
    private BigDecimal price;

    @ApiModelProperty(value = "供应商")
    private String supplier;

    @ApiModelProperty(value = "零件批次号")
    private String materialBatchNo;

    @ApiModelProperty(value = "类别（1订单需求;2生产库存）")
    private Integer busType;

    @ApiModelProperty(value = "委托单号(包括机加工或者喷涂)")
    private String busNo;
}
