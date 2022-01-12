package com.deepsoft.haolifa.model.dto.finance.payplan;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 应付汇总 rq
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanSummaryRQDTO extends PageParam {
    @ApiModelProperty(value = "供应商")
    private String supplierName;
    @ApiModelProperty(value = "需求方")
    private String  demander;
}
