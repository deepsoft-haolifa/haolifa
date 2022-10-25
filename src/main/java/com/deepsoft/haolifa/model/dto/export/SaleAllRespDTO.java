package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
@Data
public class SaleAllRespDTO {
    @ApiModelProperty(value = "生产总数量")
    private Integer outPutTotalNum;
    @ApiModelProperty(value = "产值总额")
    private BigDecimal outPutTotalAmount;
    @ApiModelProperty(value = "订货总数量")
    private Integer saleTotalNum;
    @ApiModelProperty(value = "订货额")
    private BigDecimal saleTotalAmount;
}
