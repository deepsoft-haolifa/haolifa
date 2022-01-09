package com.deepsoft.haolifa.model.dto.finance.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContractListRQDTO {

    @ApiModelProperty(value = "记账类型 0||null 全部 1.银行日记账；2.其他货币日记账")
    private String billType;
    @ApiModelProperty(value = "id")
    private Integer id;
}
