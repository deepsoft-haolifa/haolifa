package com.deepsoft.haolifa.model.dto.finance.reimburseapply;


import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailUpDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailUpDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseApplyUpDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payType;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;

    @ApiModelProperty(value = "报销部门id")
    private Integer deptId;

    @ApiModelProperty(value = "报销金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "类型 1 费用报销 2 费用报销")
    private String type;

    @ApiModelProperty(value = "报销方式	1普通报销 2借款冲抵")
    private String reimburseType;

    @ApiModelProperty(value = "报销日期")
    private Date reimburseDate;

    @ApiModelProperty(value = "出差人名称")
    private String travelUserName;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "备注摘要")
    private String remark;

    @ApiModelProperty(value = "费用报销")
    List<ReimburseCostDetailUpDTO> reimburseCostDetailUpDTOList;

    @ApiModelProperty(value = "差旅报销")
    List<ReimburseTravelDetailUpDTO> reimburseTravelDetailUpDTOList;

}
