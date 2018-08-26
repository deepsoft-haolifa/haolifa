package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 用户信息页面实体
 **/
@Data
public class UserBaseDTO {

    private Integer id;

    @ApiModelProperty(required = true,value = "用户名")
    private String username;

    @ApiModelProperty(required = true,value = "密码")
    private String password;

    @ApiModelProperty(required = true,value = "真名")
    private String realName;

    @ApiModelProperty(required = true,value = "员工编号")
    private String userNo;

    @ApiModelProperty(required = true,value = "性别")
    private Byte sex;

    @ApiModelProperty(required = true,value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(required = true,value = "手机号")
    private String phone;

    @ApiModelProperty(required = true,value = "身份证")
    private String idCard;

    @ApiModelProperty(required = false,value = "照片")
    private String photo;

    @ApiModelProperty(required = true,value = "入职时间")
    private Date entryTime;

}

