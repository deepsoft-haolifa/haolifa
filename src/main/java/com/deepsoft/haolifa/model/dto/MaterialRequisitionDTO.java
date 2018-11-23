package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @className: MaterialRequisitionDTO
 * @description: 领料单记录实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-23 20:11
 **/
@Data
@ApiModel
public class MaterialRequisitionDTO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "领料部门")
    private String receiveDepartment;

    @ApiModelProperty(value = "领料员Id")
    private String receiveUserId;

    @ApiModelProperty(value = "领料员名称")
    private String receiveUserName;

    @ApiModelProperty(value = "零件列表")
    private List<OrderMaterialDTO> listOrderMaterial;

}
