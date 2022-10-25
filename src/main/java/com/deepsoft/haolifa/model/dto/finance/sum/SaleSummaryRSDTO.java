package com.deepsoft.haolifa.model.dto.finance.sum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 销售合同汇总的返回实体
 * @author murphy.he
 **/
@Data
public class SaleSummaryRSDTO {

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    /**
     * 客户
     */
    @ApiModelProperty(value = "客户")
    private String customerId;

    /**
     * 合同额
     */
    @ApiModelProperty(value = "合同额")
    private Double contractAmount;

    /**
     * 发货额
     */
    @ApiModelProperty(value = "发货额")
    private Double deliveryAmount;

    /**
     * 出货应收（发货金额-已收款）
     */
    @ApiModelProperty(value = "出货应收")
    private Double deliveryNeedCollectAmount;

    /**
     * 开票应收（已开票-已收款）
     */
    @ApiModelProperty(value = "开票应收")
    private Double invoiceNeedCollectAmount;
    /**
     * 已收款
     */
    @ApiModelProperty(value = "已收款")
    private Double collectedAmount;
    /**
     * 未开票(发货金额-已开票)
     */
    @ApiModelProperty(value = "未开票")
    private Double needInvoiceAmount;
    /**
     * 已开票
     */
    @ApiModelProperty(value = "已开票")
    private Double invoicedAmount;


}
