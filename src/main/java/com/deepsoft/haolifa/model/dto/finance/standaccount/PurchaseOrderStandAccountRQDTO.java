package com.deepsoft.haolifa.model.dto.finance.standaccount;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 财务挂帐
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrderStandAccountRQDTO extends PageParam {

    @ApiModelProperty(value = "订单编号")
    private String purchaseOrderNo;

    @ApiModelProperty(value = "供应方")
    private String supplierName;

    @ApiModelProperty(value = "结算方")
    private String demander;

//    @ApiModelProperty(value = "归属单位")
//    private String ;

}
