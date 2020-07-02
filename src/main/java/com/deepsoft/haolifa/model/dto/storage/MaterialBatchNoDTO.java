package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: MaterialBatchNoDTO
 * @description: 零件批次号实体
 * @author: hedong@ibeesaas.com
 * @date: 2019-01-02 18:00
 **/
@Data
public class MaterialBatchNoDTO {

    @ApiModelProperty(value = "批次号")
    private String materialBatchNo;

    @ApiModelProperty(value = "当前数量（正数）")
    private Integer quantity;

    @ApiModelProperty(value = "库房")
    private String roomNo;

    @ApiModelProperty(value = "库位")
    private String rackNo;
}
