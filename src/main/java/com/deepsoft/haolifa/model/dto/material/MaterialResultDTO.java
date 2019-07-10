package com.deepsoft.haolifa.model.dto.material;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialResultDTO {

    @ApiModelProperty(value = "图号")
    private String graphNo;
    @ApiModelProperty(value = "零件名称")
    private String materialName;
    @ApiModelProperty(value = "配套数量")
    private Integer supportQuantity;
    @ApiModelProperty(value = "当前库存量")
    private Integer currentQuantity;

}
