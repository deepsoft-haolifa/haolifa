package com.deepsoft.haolifa.model.dto.finance.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContractListRQDTO {

    @ApiModelProperty(value = "记账类型 0||null 全部 2.银行日记账；3.其他货币日记账")
    private String billType;
    @ApiModelProperty(value = "记账表里的ID")
    private Integer id;
}
