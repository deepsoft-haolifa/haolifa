package com.deepsoft.haolifa.model.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode()
@ApiModel(description = "工序明人员明细表")
public class PayWorkingProcedureUserVO {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "订单ID")
    private String orderNo;
    @ApiModelProperty(value = "产品ID")
    private Integer productId;
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
    @ApiModelProperty(value = "工序对应的人员列表")
    private List<ProcedureUserVO> userList;
}
