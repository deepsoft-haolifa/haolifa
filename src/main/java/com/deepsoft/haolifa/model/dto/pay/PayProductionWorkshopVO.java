package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "生产车间DTO")
@Data
@EqualsAndHashCode(callSuper=true)
public class PayProductionWorkshopVO extends BaseCondition {
    @ApiModelProperty(value = "车间名称")
    private String workshopName;
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "开始创建时间")
    private String startCreateTime;
    @ApiModelProperty(value = "结束创建时间")
    private String endCreateTime;


}
