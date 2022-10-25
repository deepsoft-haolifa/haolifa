package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("班组VO")
@EqualsAndHashCode(callSuper=true)
public class PayTeamVO extends BaseCondition {
    @ApiModelProperty(value = "车间id")
    private Integer workshopId;
    @ApiModelProperty(value = "班组名称")
    private String teamName;
    @ApiModelProperty(value = "开始创建时间")
    private String startCreateTime;
    @ApiModelProperty(value = "结束创建时间")
    private String endCreateTime;
}
