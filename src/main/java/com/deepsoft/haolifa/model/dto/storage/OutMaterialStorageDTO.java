package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 出库零件实体
 */
@Data
public class OutMaterialStorageDTO extends BaseStorageDTO{

    @ApiModelProperty(value = "零件号",required = true)
    private String materialGraphNo;

    @ApiModelProperty(value = "出库数量（负数）",required = true)
    private Integer quantity;

    @ApiModelProperty(value = "零件购买单价")
    private BigDecimal price;

    @ApiModelProperty(value = "领料部门")
    private String receiveDepartment;

    @ApiModelProperty(value = "零件批次号,如果选择多个批次号，以逗号分隔")
    private String materialBatchNo;
}
