package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.annotation.ExcelHandle;
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
    @ExcelHandle(name = "序号")
    @ApiModelProperty(value = "序号")
    private Integer serial;
    @ExcelHandle(name = "车间名称")
    @ApiModelProperty(value = "车间名称")
    private String workshopName;
    @ExcelHandle(name = "工种类别")
    @ApiModelProperty(value = "工种类别")
    private String workType;
    @ExcelHandle(name = "适用工单产品型号")
    @ApiModelProperty(value = "适用工单产品型号")
    private String productModel;
    @ExcelHandle(name = "岗位（工序）名称")
    @ApiModelProperty(value = "岗位（工序）名称")
    private String postName;
    @ExcelHandle(name = "岗位能力简称")
    @ApiModelProperty(value = "岗位能力简称")
    private String postCapability;
    @ExcelHandle(name = "岗位（工序）代码")
    @ApiModelProperty(value = "岗位（工序）代码")
    private String postCode;
}
