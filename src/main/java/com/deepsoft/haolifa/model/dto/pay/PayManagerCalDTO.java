package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(description = "管理计提工时定额表")
public class PayManagerCalDTO {
    private Integer id;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "部门名称")
    private String dept;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "项目名称")
    private String project;
    @ApiModelProperty(value = "适用ID类别（图号类别）")
    private String idCategory;
    @ApiModelProperty(value = "适用型号")
    private String appModel;
    @ApiModelProperty(value = "适用规格")
    private String appSpecifications;
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ApiModelProperty(value = "工时定额")
    private BigDecimal price;
}
