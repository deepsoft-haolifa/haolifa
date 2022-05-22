package com.deepsoft.haolifa.model.dto.businessAnalysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 经营分析需要的采购报表数据
 *
 * @author murphy.he
 **/
@Data
public class BusinessAnalysisPurchaseAmountDTO {

    @ApiModelProperty(value = "回票金额")
    private BigDecimal returnTicketAmount;
    @ApiModelProperty("付款金额")
    private BigDecimal paidTotal;


}
