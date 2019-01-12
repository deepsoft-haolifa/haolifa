package com.deepsoft.haolifa.model.dto.material;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialQuantityDTO {

    @ApiModelProperty(value = "图号")
    private String graphNo;
    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "核料需要的零件数量")
    private Integer quantity;

}
