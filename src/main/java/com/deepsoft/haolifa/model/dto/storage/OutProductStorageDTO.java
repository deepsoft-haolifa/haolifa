package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;

/**
 * 出库成品实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OutProductStorageDTO extends BaseStorageDTO {
    @ApiModelProperty(value = "成品号", required = true)
    private String productNo;
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "规格")
    private String productSpecifications;
    @ApiModelProperty(value = "出库数量（负数）", required = true)
    private Integer quantity;

    @ApiModelProperty(value = "出库单价（销售单价）")
    private BigDecimal price;

    @ApiModelProperty(value = "客户代号")
    private String customerNo;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

}
