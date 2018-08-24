package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DepartmentDTO {

    @ApiModelProperty(value="部门名称",required=true)
    private String deptName;
    @ApiModelProperty(value="部门描述",required=true)
    private String description;
    @ApiModelProperty(value="部门父id，默认为0",required=false)
    private Integer pid;

}
