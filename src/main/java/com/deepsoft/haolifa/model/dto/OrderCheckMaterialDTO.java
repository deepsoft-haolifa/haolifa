package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * @className: CheckMaterialDTO
 * @description: 核料实体
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-19 21:20
 **/
@Data
@ApiModel
public class OrderCheckMaterialDTO {

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "零件号")
    private String materialGraphNo;

    @ApiModelProperty(value = "替换前零件号")
    private String replaceMaterialGraphNo;

    @ApiModelProperty(value = "是否是替换零件（0：否，1：是）")
    private Byte isReplace;

    @ApiModelProperty(value = "需要的零件数量(产品数量*1)")
    private Integer materialCount;

    @ApiModelProperty(value = "缺少的零件数量")
    private Integer lackMaterialCount;

    @ApiModelProperty(value = "核料状态（1.成功；2.需要采购；3.可替换）")
    private Byte checkStatus;
    @ApiModelProperty(value = "核料结果说明")
    private String checkResultMsg;

    @ApiModelProperty(value = "可替换料的列表")
    private List<String> replaceGraphNoList;
}
