package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @className: DeliveryNoticeAuditDTO
 * @description: 审核实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-29 20:49
 **/
@Data
@ApiModel
public class DeliveryNoticeAuditDTO {

    @ApiModelProperty(value = "发货通知单号")
    private String deliveryNo;

    @ApiModelProperty(value = "审核备注")
    private String auditInfo;

    @ApiModelProperty(value = "审核结果（1审核不通过；2.审核通过）")
    private Byte auditResult;
}
