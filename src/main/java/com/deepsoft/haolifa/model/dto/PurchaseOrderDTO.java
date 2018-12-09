package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class PurchaseOrderDTO {
    @ApiModelProperty(required = true,value = "采购订单编号")
    private String orderNo;
    @ApiModelProperty(required = true,value = "供应商编号")
    private String supplierNo;
    @ApiModelProperty(required = true,value = "供应商名称")
    private String supplierName;
    @ApiModelProperty(required = true,value = "供方联系人")
    private String supplierLinkman;
    @ApiModelProperty(required = true,value = "供方地址")
    private String supplierAddr;
    @ApiModelProperty(required = true,value = "供方联系电话")
    private String suppilerPhone;
    @ApiModelProperty(required = true,value = "需方")
    private String demander;
    @ApiModelProperty(required = true,value = "需方联系人")
    private String demanderLinkman;
    @ApiModelProperty(required = true,value = "需方地址")
    private String demanderAddr;
    @ApiModelProperty(required = true,value = "需方联系电话")
    private String demanderPhone;
    @ApiModelProperty(required = true,value = "交货日期")
    private String deliveryTime;
    @ApiModelProperty(value = "经办人")
    private String operatorUserName;
    @ApiModelProperty(value = "经办时间")
    private String operateTime;
    @ApiModelProperty(required = true,value = "供方确认人")
    private String SupplierConfirmer;
    @ApiModelProperty(required = true,value = "确认时间")
    private String confirmTime;

    @ApiModelProperty(required = true,value = "采购单项")
    private List<PurchaseOrderItem> itemList;

}
