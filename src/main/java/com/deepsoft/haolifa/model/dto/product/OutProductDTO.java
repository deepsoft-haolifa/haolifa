package com.deepsoft.haolifa.model.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 成品配置请求实体
 */
@Data
@ApiModel(value = "成品出库")
public class OutProductDTO {

    @ApiModelProperty(value = "主键Id", required = true)
    private Integer id;
    @ApiModelProperty(value = "出库数量")
    private Integer qty;
}
