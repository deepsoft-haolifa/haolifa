package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EntrustDTO {

    @ApiModelProperty(required = true,value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "物料名称")
    private String materialGraphName;
    @ApiModelProperty(required = true, value = "加工后图号")
    private String processedGraphNo;
    @ApiModelProperty(required = true,value = "委托数量")
    private Integer number;
    @ApiModelProperty(required = true,value = "采购合同号")
    private String purchaseNo;
//    @ApiModelProperty(required = true,value = "加工批次号")
//    private String batchNumber;
    @ApiModelProperty(required = true,value = "执行操作：1 保存 2 保存并发起",allowableValues = "1,2")
    private Integer actionType;


}
