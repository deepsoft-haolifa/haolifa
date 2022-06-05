package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchaseOrderRQParam extends PageParam {

    @ApiModelProperty(value = "采购合同号:")
    private String orderNo;
    @ApiModelProperty(value = "订单状态：1 待审批 2 审批中 3 采购中 4 审批不通过 5 采购完成 ")
    private int status;
    @ApiModelProperty(value = "订单类型 0 采购订单 1 外部机加工订单")
    private Integer orderType;
    @ApiModelProperty(value = "供方单位:")
    private String supplierName;



}
