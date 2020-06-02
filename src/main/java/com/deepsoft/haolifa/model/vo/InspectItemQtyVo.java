package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class InspectItemQtyVo {

    @ApiModelProperty("零件图号")
    private String materialGraphNo;

    @ApiModelProperty("零件名称")
    private String materialName;

    @ApiModelProperty("采购数")
    private Integer purchaseNumber;

    @ApiModelProperty("报检数")
    private Integer deliveryNumber;

    @ApiModelProperty("合格数")
    private Integer qualifiedNumber;

    @ApiModelProperty("不合格数")
    private Integer unqualifiedNumber;
}
