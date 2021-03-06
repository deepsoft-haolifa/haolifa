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
public class ProductUpdateRequestDTO {

    @ApiModelProperty(value = "主键Id",required = true)
    private Integer id;

    @ApiModelProperty(value = "成品名称", required = true)
    private String name;
    @ApiModelProperty(value = "成品号（全局唯一）", required = true)
    private String productNo;
    @ApiModelProperty(value = "适配组件")
    private String fitComponent;
    @ApiModelProperty(value = "成品规格（如：DN65，DN80）")
    private String specifications;
    @ApiModelProperty(value = "备注")
    private String remark;
}
