package com.deepsoft.haolifa.model.dto.finance.billcontract;


import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同收款表(合同分解)
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BillContractRSDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "记账id")
    private Long billId;
    @ApiModelProperty(value = "记账类型 1 银行日记账 2 其他货币日记账")
    private Byte billType;
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "收款金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "记账员")
    private String bookKeeper;
    @ApiModelProperty(value = "审批状态（0未审批；1.通过；2.不通过）")
    private Byte auditStatus;
    @ApiModelProperty(value = "审批状态（0未审批；1.通过；2.不通过）")
    private String auditStatusCN;
    @ApiModelProperty(value = "是否可审批")
    private Boolean canAudit = true;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建者")
    private Integer createUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Integer updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
