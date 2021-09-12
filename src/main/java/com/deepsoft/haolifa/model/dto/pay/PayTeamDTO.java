package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel("班组DTO")
public class PayTeamDTO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "车间id")
    private Integer workshopId;
    @ApiModelProperty(value = "车间名称")
    private String workshopName;
    @ApiModelProperty(value = "班组名称")
    private String teamName;
}
