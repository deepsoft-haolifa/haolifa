package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: ReplaceMaterialAuditDTO
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2019-01-16 20:13
 **/
@Data
public class CheckReplaceMaterialAuditDTO {

    @ApiModelProperty(value = "成品号")
    private int orderMaterialId;

    @ApiModelProperty(required = true, value = "1 通过 2 不通过")
    private Byte auditResult;

}
