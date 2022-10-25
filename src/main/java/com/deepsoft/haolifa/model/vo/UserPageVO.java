package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class UserPageVO {

    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "真名")
    private String realName;

    @ApiModelProperty(value = "角色部门")
    private List<RoleDTO> roles;

    @ApiModelProperty(value = "是否停用：1-是； 0-否")
    private Byte isDelete;

    @ApiModelProperty(value = "部门名称")
    private String departName;

    @ApiModelProperty(value = "岗位名称")
    private String postName;

}
