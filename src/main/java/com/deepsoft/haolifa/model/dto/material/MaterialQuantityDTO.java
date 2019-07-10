package com.deepsoft.haolifa.model.dto.material;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialQuantityDTO {

    @ApiModelProperty(value = "图号")
    private String graphNo;
    @ApiModelProperty(value = "核料原料类型：（fati.阀体;fazuo:阀座;faban：阀板;fagan:阀杆;fatiyali.阀体压力;tongyong:通用零件）")
    private String type;
    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "核料需要的零件数量")
    private Integer quantity;

}
