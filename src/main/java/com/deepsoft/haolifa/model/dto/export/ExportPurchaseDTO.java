package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 采购报表
 */
@Data
public class ExportPurchaseDTO {

    @ApiModelProperty("合同编号")
    private String purchaseOrderNo;

    @ApiModelProperty("供应商名称")
    private String supplierName;

    @ApiModelProperty("采购数量")
    private Integer totalCount;

    @ApiModelProperty("采购状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("合同金额")
    private String total;

    @ApiModelProperty("付款金额")
    private String payTotal;

    @ApiModelProperty("欠款金额")
    private String unpay;

    @ApiModelProperty(value = "已挂账金额、入账金额")
    private String registered;

    @ApiModelProperty(value = "供应商已回款金额")
    private String collected;

    @ApiModelProperty(value = "累计回票金额")
    private String returnTicketAmount;

    @ApiModelProperty(value = "上账未开票金额(入账金额-回票金额)")
    private String unTicketAmount;

}
