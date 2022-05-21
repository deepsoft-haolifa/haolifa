package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 经营分析需要的销售报表数据
 *
 * @author murphy.he
 **/
@Data
public class BusinessAnalysisSaleAmountDTO {

    @ApiModelProperty(value = "开票金额")
    private BigDecimal invoiceAmount;
    @ApiModelProperty(value = "回款金额")
    private BigDecimal collectAmount;
    @ApiModelProperty(value = "订货总额")
    private BigDecimal saleAmount;
    @ApiModelProperty(value = "产值总额")
    private BigDecimal outPutAmount;

}
