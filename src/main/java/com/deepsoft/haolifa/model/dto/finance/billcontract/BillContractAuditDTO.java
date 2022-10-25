package com.deepsoft.haolifa.model.dto.finance.billcontract;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 合同分解-分解審核
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BillContractAuditDTO {

    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "审批状态（0未审批；1.通过；2.不通过）")
    private Byte auditStatus;
    @ApiModelProperty(value = "备注")
    private String remark;
}
