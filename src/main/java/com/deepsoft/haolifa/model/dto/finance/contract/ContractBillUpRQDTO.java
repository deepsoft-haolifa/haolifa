package com.deepsoft.haolifa.model.dto.finance.contract;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/***
 * 日记账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContractBillUpRQDTO  {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "经办人")
    private Integer contractUser;

    @ApiModelProperty(value = "记账类型 0||null 全部 2.银行日记账；3.其他货币日记账")
    private String billType;

    @ApiModelProperty(value = "收款合同分解状态；0未完成；1.完成")
    private String contractStatus;

}
