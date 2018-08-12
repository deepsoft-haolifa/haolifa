package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 成品配置请求实体
 */
@Data
@ApiModel(value = "成品配置对象", description = "新增，更新成品实体")
public class ProductRequestDTO {

    @ApiModelProperty(value = "主键Id", name = "Id", required = true)
    private Integer id;

    @ApiModelProperty(value = "成品名称", name = "name", required = true)
    private String name;
    @ApiModelProperty(value = "成品编号（全局唯一）", name = "productNo", required = true)
    private String productNo;
    @ApiModelProperty(value = "适配组件", name = "fitComponent")
    private String fitComponent;
    @ApiModelProperty(value = "成品规格（如：DN65，DN80）", name = "specifications")
    private String specifications;
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;
}
