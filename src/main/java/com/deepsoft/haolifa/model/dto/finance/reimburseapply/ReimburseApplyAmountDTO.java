package com.deepsoft.haolifa.model.dto.finance.reimburseapply;

import com.deepsoft.haolifa.model.dto.finance.FileUrlDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailAddDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseApplyAmountDTO {

    @ApiModelProperty(value = "报销金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "类型 1 差旅报销 2 费用报销")
    private String type;

    @ApiModelProperty(value = "报销方式	1普通报销 2借款冲抵")
    private String reimburseType;

    @ApiModelProperty(value = "2借款冲抵 必传 冲抵金额/不得大于借款金额")
    private BigDecimal offsetAmount;

    @ApiModelProperty(value = "费用报销")
    List<ReimburseCostDetailAmountDTO> reimburseCostDetailAddDTOList;

    @ApiModelProperty(value = "差旅报销")
    List<ReimburseTravelDetailAddDTO> reimburseTravelDetailAddDTOList;


    @Data
    public class ReimburseCostDetailAmountDTO {
        @ApiModelProperty(value = "单据张数")
        private  Integer docNum;
        @ApiModelProperty(value = "金额")
        private  BigDecimal amount;
    }

    @Data
    public class ReimburseTravelDetailAddDTO {
        @ApiModelProperty(value = "交通金额")
        private BigDecimal vehicleAmount;
        @ApiModelProperty(value = "出差天数")
        private Double travelDays = 0.0;
        @ApiModelProperty(value = "出差补贴金额")
        private BigDecimal travelSubsidyAmount;
        @ApiModelProperty(value = "金额")
        private BigDecimal projectAmount;
    }

}
