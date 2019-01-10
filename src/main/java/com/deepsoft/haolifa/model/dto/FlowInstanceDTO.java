package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FlowInstanceDTO {

    @ApiModelProperty(required = true, value = "流程id")
    private Integer flowId;
    @ApiModelProperty(required = true, value = "流程概要")
    private String summary;
    @ApiModelProperty(required = true, value = "表单id,流程初始化时填写表单的实例id")
    private Integer formId;
    @ApiModelProperty(required = true, value = "初始化的表单类型：默认0 无 1 生产订单 2 请购单 3 采购单 4 送检单 5 产品质检单 6 零件质检单 7 发票单 8 发货单 9 供应商表单", allowableValues = "0," +
            "1,2,3,4," +
            "5,6,7,8,9")
    private Integer formType;
    @ApiModelProperty(required = true,value = "订单编号（采购、生产、请购等）")
    private String formNo;

}
