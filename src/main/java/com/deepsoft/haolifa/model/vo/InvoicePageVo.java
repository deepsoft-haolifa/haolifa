package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.domain.Invoice;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class InvoicePageVo extends Invoice {

    @ApiModelProperty("合同总金额")
    private BigDecimal orderTotalAmount;
}
