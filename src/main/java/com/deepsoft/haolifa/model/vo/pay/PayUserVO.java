package com.deepsoft.haolifa.model.vo.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "人员信息表")
public class PayUserVO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "性别默认为0， 1：男， 2：女")
    private Byte sex;
    @ApiModelProperty(value = "班组id")
    private Integer teamId;
    @ApiModelProperty(value = "班组名称")
    private String teamName;
    @ApiModelProperty(value = "岗位id")
    private Integer postId;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "人员类型")
    private String userType;
    @ApiModelProperty(value = "上级ID")
    private Integer superiorId;
    @ApiModelProperty(value = "部门名称")
    private String departName;
}
