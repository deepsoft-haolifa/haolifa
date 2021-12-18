package com.deepsoft.haolifa.model.dto.finance.receivable;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 应收货款
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrderReceivableRQDTO extends PageParam {


    @ApiModelProperty(value = "Query-订单编号")
    private String purchaseOrderNo;

    @ApiModelProperty(value = "Query-供应商编号")
    private String supplierNo;

    @ApiModelProperty(value = "Query-提供方")
    private String supplierName;


    @ApiModelProperty(value = "供方联系人电话")
    private String suppilerPhone;

    @ApiModelProperty(value = "需方联系人电话")
    private String demanderPhone;

    @ApiModelProperty(value = "Query-交货日期")
    private Date deliveryTime;

    @ApiModelProperty(value = "Query-订单经办人")
    private String operatorUserName;

    @ApiModelProperty(value = "Query-经办日期")
    private Date operateTime;


}
