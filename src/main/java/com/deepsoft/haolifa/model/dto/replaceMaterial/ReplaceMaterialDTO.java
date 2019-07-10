package com.deepsoft.haolifa.model.dto.replaceMaterial;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReplaceMaterialDTO {


    @ApiModelProperty(value = "主键id（更新的时候用）")
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;


    @ApiModelProperty(value = "零件号")
    private String materialGraphNo;

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "零件单位(如：根，个)")
    private String materialUnit;
    @ApiModelProperty(value = "零件数量")
    private Integer materialCount;

    @ApiModelProperty(value = "更换原因")
    private String replaceReason;
    @ApiModelProperty(value = "责任人")
    private String responsiblePerson;
}
