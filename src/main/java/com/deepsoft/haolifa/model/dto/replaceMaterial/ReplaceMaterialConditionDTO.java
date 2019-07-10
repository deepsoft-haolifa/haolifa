package com.deepsoft.haolifa.model.dto.replaceMaterial;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: ReplaceMaterialConditionDTO
 * @description: 替换料请求实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-29 20:54
 **/
@Data
public class ReplaceMaterialConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "更换料号")
    private String replaceMaterialNo;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "审核状态(-1 全部 0 未审核 1审核不通过 2 审核通过)")
    private byte auditResult;
}
