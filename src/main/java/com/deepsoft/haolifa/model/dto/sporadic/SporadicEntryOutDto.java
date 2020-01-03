package com.deepsoft.haolifa.model.dto.sporadic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 零星物料出，入库实体
 *
 * @author murphy.he
 **/
@Data
public class SporadicEntryOutDto {

    @ApiModelProperty(value = "零星物料Id", required = true)
    private Integer sporadicId;

    @ApiModelProperty(value = "零星物料图号", required = true)
    private String graphNo;

    @ApiModelProperty(value = "数量(入库是正数；出库是负数)", required = true)
    private Integer quantity;

    @ApiModelProperty(value = "1出库；2入库", allowableValues = "1,2")
    private Byte type;


}
