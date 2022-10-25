package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel("customer_info")
public class CustomerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;


    @ApiModelProperty("客户名称")
    private String name;


    @ApiModelProperty("地址")
    private String address;


    @ApiModelProperty("联系人")
    private String contractPerson;


    @ApiModelProperty("电话")
    private String phone;


    @ApiModelProperty("传真")
    private String fax;


    @ApiModelProperty("开户行")
    private String openBank;


    @ApiModelProperty("帐号")
    private String bankAccount;


    @ApiModelProperty("付款方式")
    private String paymentMethod;


    @ApiModelProperty("备注")
    private String remark;


    @ApiModelProperty("创建时间")
    private Date createTime;


    @ApiModelProperty("更新时间")
    private Date updateTime;


    public CustomerInfo(Integer id, String name, String address, String contractPerson, String phone, String fax, String openBank, String bankAccount, String paymentMethod, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contractPerson = contractPerson;
        this.phone = phone;
        this.fax = fax;
        this.openBank = openBank;
        this.bankAccount = bankAccount;
        this.paymentMethod = paymentMethod;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CustomerInfo() {
        super();
    }
}
