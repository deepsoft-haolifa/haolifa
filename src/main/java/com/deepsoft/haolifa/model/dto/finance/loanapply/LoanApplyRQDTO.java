package com.deepsoft.haolifa.model.dto.finance.loanapply;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplyRQDTO extends PageParam {

    @ApiModelProperty(value = "列表类型 1 借款审批列表  2 出纳付款列表")
    private String type;

    @ApiModelProperty(value = "编号")
    private String serialNo;

    @ApiModelProperty(value = "状态 1 代办 2 已办")
    private Integer status;

    @ApiModelProperty(value = "借款部门名称")
    private String deptName;

    @ApiModelProperty(value = "借款人名称")
    private String loanUserName;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "审批节点 例：2,3（1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成）")
    private String applyStatus;

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成）")
    private String payStatus;


    @ApiModelProperty(value = "是否可查全部",hidden = true)
    private Boolean lookAll;

    @ApiModelProperty(value = "借款部门id list ）",hidden = true)
    private List<Integer> deptIdList;
    @ApiModelProperty(value = "借款人id list ）",hidden = true)
    private List<Integer> userIdList;

    @ApiModelProperty(value = "状态 list ）",hidden = true)
    private List<String> applyStatusList;


    @ApiModelProperty(value = "户名(2022-03-20 新增)")
    private String accountName;

}
