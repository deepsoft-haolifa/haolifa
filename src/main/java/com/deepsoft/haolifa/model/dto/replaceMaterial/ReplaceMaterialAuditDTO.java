package com.deepsoft.haolifa.model.dto.replaceMaterial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: DeliveryNoticeAuditDTO
 * @description: 审核实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-29 20:49
 **/
@Data
@ApiModel
public class ReplaceMaterialAuditDTO {

    @ApiModelProperty(value = "更换料号")
    private String replaceMaterialNo;

    @ApiModelProperty(value = "审核备注")
    private String auditInfo;

    @ApiModelProperty(value = "审核结果（1审核不通过；2.审核通过）")
    private Byte auditResult;
}
