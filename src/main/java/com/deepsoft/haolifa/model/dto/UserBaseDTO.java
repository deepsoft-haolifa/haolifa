package com.deepsoft.haolifa.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @description: 用户信息页面实体
 **/
@Data
public class UserBaseDTO {

    private Integer id;

    private String username;

    private String password;

    private String realName;

    private String userNo;

    private Byte sex;

    private String nativePlace;

    private String phone;

    private String idCard;

    private String photo;

    private Date entryTime;

}

