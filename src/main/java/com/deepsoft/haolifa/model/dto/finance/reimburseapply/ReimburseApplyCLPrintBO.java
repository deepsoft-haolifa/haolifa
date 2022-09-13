package com.deepsoft.haolifa.model.dto.finance.reimburseapply;

import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailRSDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseApplyCLPrintBO {


    @ApiModelProperty(value = "报销部门名称")
    private String deptName;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payTypeCN;

    @ApiModelProperty(value = "报销金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    //---
    @ApiModelProperty(value = "差旅报销")
    List<ReimburseTravelDetailRSDTO> reimburseTravelDetailRSDTOList;

}
