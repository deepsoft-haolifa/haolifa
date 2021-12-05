package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PayManagerCalDTO {
    private Integer id;

    private String userName;
    @ApiModelProperty(value = "部门")
    private String dept;
    @ApiModelProperty(value = "岗位")
    private String postName;
    @ApiModelProperty(value = "项目名称")
    private String project;
    @ApiModelProperty(value = "产品类别")
    private String workType;
    @ApiModelProperty(value = "适用ID类别")
    private String idCategory;
    @ApiModelProperty(value = "适用规格")
    private String appSpecifications;
    @ApiModelProperty(value = "适用型号")
    private String appModel;

}
