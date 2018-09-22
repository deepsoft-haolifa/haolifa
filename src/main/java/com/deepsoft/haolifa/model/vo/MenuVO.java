package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MenuVO {

    private Integer id;

    @ApiModelProperty(required = true,value = "描述")
    private String description;

    @ApiModelProperty(required = true,value = "代号")
    private String code;

    @ApiModelProperty(required = true,value = "父id")
    private Integer pid;

}
