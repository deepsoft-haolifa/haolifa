package com.deepsoft.haolifa.model.dto.finance.contract;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContractListRQDTO extends PageParam {

    @ApiModelProperty(value = "记账类型 0||null 全部 2.银行日记账；3.其他货币日记账")
    private String billType;
    @ApiModelProperty(value = "记账表里的ID")
    private Integer id;


    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "rs-合同编号")
    private String orderContractNo;


}
