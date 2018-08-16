package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FinanceDTO {

    private Integer id;

    @ApiModelProperty(required = true,value = "合同编号")
    private String orderNo;
    @ApiModelProperty(required = true,value = "合同类型：0  订单合同编号 1 采购编号", allowableValues = "0,1")
    private Integer type;
    @ApiModelProperty(required = true,value = "合同金额")
    private Integer totalAmount;
    @ApiModelProperty(value = "合同状态:0 未收款 1 未打款 2 打款中 3 收款中 4 处理完成",allowableValues = "0,1,2,3,4")
    private Integer status;

}
