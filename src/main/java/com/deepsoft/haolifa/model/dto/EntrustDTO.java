package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EntrustDTO {

    @ApiModelProperty(required = true,value = "零件图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "零件名称")
    private String materialGraphName;
    @ApiModelProperty(required = true, value = "加工后图号")
    private String processedGraphNo;
    @ApiModelProperty(required = true,value = "委托数量")
    private Integer number;
    @ApiModelProperty(value = "采购合同号")
    private String purchaseNo;
    @ApiModelProperty(required = true,value = "加工批次号")
    private String batchNumber;
    @ApiModelProperty(required = true,value = "执行操作：1 保存 2 保存并发起",allowableValues = "1,2")
    private Integer actionType;
    @ApiModelProperty(value = "1订单需求;2生产库存",allowableValues = "1,2")
    private Byte busType;

    @ApiModelProperty(value = "零件类型名称")
    private String materialClassifyName;
    @ApiModelProperty(value = "型号")
    private String model;
    @ApiModelProperty(value = "规格")
    private String specifications;

}
