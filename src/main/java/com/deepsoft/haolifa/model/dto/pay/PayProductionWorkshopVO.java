package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "岗位VO")
@Data
@EqualsAndHashCode(callSuper=true)
public class PayProductionWorkshopVO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "岗位代码")
    private String postCode;
    @ApiModelProperty(value = "开始创建时间")
    private String startCreateTime;
    @ApiModelProperty(value = "结束创建时间")
    private String endCreateTime;


}
