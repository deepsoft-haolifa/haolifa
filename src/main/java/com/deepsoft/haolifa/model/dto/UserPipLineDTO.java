package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.model.domain.SysRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

@Data
public class UserPipLineDTO {

    @ApiModelProperty(value = "系统用户ID")
    private Integer id;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "身份证号")
    private String idCard;
    @ApiModelProperty(value = "联系方式")
    private String phone;

    @ApiModelProperty(value = "系统用户角色")
    private Set<SysRole> roles;

    @ApiModelProperty(value = "父ID")
    private Integer parentId;
    @ApiModelProperty(value = "父用户名称")
    private String parentUserName;

}
