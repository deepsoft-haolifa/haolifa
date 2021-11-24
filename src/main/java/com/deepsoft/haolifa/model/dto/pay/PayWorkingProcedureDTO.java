package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "工序明细表")
public class PayWorkingProcedureDTO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "序号")
    private Integer serial;
    @ApiModelProperty(value = "车间名称")
    private String workshopName;
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ApiModelProperty(value = "适用工单产品型号")
    private String productModel;
    @ApiModelProperty(value = "岗位（工序）名称")
    private String postName;
    @ApiModelProperty(value = "岗位能力简称")
    private String postCapability;
    @ApiModelProperty(value = "岗位（工序）代码")
    private String postCode;
}
