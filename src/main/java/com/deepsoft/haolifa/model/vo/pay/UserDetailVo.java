package com.deepsoft.haolifa.model.vo.pay;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName UserDetailVo
 * @Author liuyaofei
 * @Date 2022/10/27
 * @Description TODO
 **/
@Data
public class UserDetailVo {

    private Integer id;

    private String userName;

    private String userNo;

    private String parentId;

    private String onceUserName;

    private Byte sex;

    private Date birthday;

    private String nation;

    private String nativePlace;

    private String politicalOutlook;

    private String bloodType;

    private String health;

    private Byte marryStatus;

    private String idCard;

    private String registered;

    private String universityFrom;

    private String major;

    private Byte education;

    private Date graduationTime;

    private Date workingTime;

    private String address;

    private BigDecimal insuranceBase;

    private String phone;

    private String mail;

    private Integer teamId;

    private BigDecimal basePay;

    private BigDecimal meritPay;

    private String postId;

    private Integer departId;

    private String departName;

    private String userType;

    private String superiorName;

    private String cardNumber;

    private String bankOfDeposit;

    private String superiorId;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;
}
