package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "生产车间DTO")
@Data
@EqualsAndHashCode()
public class PayProductionWorkshopDTO {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "岗位code")
    private String postCode;


}
