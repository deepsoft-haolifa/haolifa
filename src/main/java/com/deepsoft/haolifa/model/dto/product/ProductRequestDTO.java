package com.deepsoft.haolifa.model.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 成品配置请求实体
 */
@Data
@ApiModel(value = "成品配置对象", description = "新增，更新成品实体")
public class ProductRequestDTO {

    @ApiModelProperty(value = "主键Id", required = true)
    private Integer id;
    @ApiModelProperty(value = "成品名称", required = true)
    private String name;
    @ApiModelProperty(value = "成品号", required = true)
    private String productNo;
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "成品规格（如：DN65，DN80）")
    private String specifications;
    @ApiModelProperty(value = "数量")
    private Integer qty;
    @ApiModelProperty(value = "备注")
    private String remark;
}
