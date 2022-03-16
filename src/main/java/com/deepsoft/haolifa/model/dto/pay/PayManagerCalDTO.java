package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.annotation.ExcelHandle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(description = "管理计提工时定额表")
public class PayManagerCalDTO {
    @ExcelHandle(name = "id")
    private Integer id;
    @ExcelHandle(name = "用户名称")
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ExcelHandle(name = "部门名称")
    @ApiModelProperty(value = "部门名称")
    private String dept;
    @ExcelHandle(name = "岗位名称")
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ExcelHandle(name = "项目名称")
    @ApiModelProperty(value = "项目名称")
    private String project;
    @ExcelHandle(name = "适用ID类别（图号类别）")
    @ApiModelProperty(value = "适用ID类别（图号类别）")
    private String idCategory;
    @ExcelHandle(name = "适用型号")
    @ApiModelProperty(value = "适用型号")
    private String appModel;
    @ExcelHandle(name = "适用规格")
    @ApiModelProperty(value = "适用规格")
    private String appSpecifications;
    @ExcelHandle(name = "工种类别")
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ExcelHandle(name = "工时定额")
    @ApiModelProperty(value = "工时定额")
    private BigDecimal price;
}
