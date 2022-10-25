package com.deepsoft.haolifa.model.dto.finance.company;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyRSDTO {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "单位code")
    private String code;

    @ApiModelProperty(value = "单位名称")
    private String name;

    @ApiModelProperty(value = "所属省")
    private String provinceName;

    @ApiModelProperty(value = "所属市")
    private String cityName;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "单位账号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "状态（1正常 2停用）")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

}
