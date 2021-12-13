package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "生产能力DTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class PayProductCapacityVO {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "班组ID")
    private Integer teamId;
    @ApiModelProperty(value = "班组名称")
    private String teamName;
    @ApiModelProperty(value = "部门ID")
    private Integer departId;
    @ApiModelProperty(value = "部门名称")
    private String departName;
    @ApiModelProperty(value = "能力代码")
    private String capacityCode;

}
