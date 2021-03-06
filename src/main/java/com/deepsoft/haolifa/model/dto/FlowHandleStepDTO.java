package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class FlowHandleStepDTO {

    @ApiModelProperty(required = true, value = "流程实例id")
    private Integer id;

    @ApiModelProperty(required = true, value = "当前处理节点id")
    private Integer stepId;

    @ApiModelProperty(value = "审核意见")
    private String auditInfo;

    @ApiModelProperty(value = "节点分配的人员id")
    private Integer allotUserId;

    @ApiModelProperty(required = true, value = "审核结果 0 不同意 1 通过（下一步） 2 退回")
    private Integer auditResult;

    @ApiModelProperty(required = true, value = "表单id,流程节点填写表单的实例id")
    private Integer formId;
    @ApiModelProperty(required = true, value = "表单类型：默认0 无 1 生产订单 2 请购单 3 采购单 4 送检单 5 产品质检单 6 零件质检单 7 发票单 8 发货单", allowableValues = "0,1,2,3,4," +
            "5,6,7,8")
    private Integer formType;

    @ApiModelProperty(value = "当审核结果为 2 时（退回），该字段必填")
    private Integer backStepId;

    @ApiModelProperty(required = true,value = "节点条件判断：true ：条件为真 or false：条件为假;默认为true")
    private Boolean condition;

    @ApiModelProperty(value = "附件信息")
    private List<Accessory> accessorys;
}
