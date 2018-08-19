package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StoreKeeperApplyBuyDTO {

    @ApiModelProperty(required = true,value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "数量")
    private Integer number;
    @ApiModelProperty(required = true,value = "估价")
    private Double valuation;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "用途")
    private String purpose;
    @ApiModelProperty(required = true,value = "单位")
    private String unit;
}
