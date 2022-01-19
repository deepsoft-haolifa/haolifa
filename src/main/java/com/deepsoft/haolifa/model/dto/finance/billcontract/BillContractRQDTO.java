package com.deepsoft.haolifa.model.dto.finance.billcontract;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 合同收款表(合同分解)
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BillContractRQDTO  extends PageParam {

    @ApiModelProperty(value = "记账id")
    private Long billId;
    @ApiModelProperty(value = "记账类型 1 银行日记账 2 其他货币日记账")
    private Byte billType;
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNo;

}
