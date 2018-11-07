package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProductDTO {

    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "成品合同订单号")
    private String orderContractNo;
    @ApiModelProperty(value = "订单状态")
    private Byte orderStatus;
    @ApiModelProperty(value = "订单合同url")
    private String orderContractUrl;
    @ApiModelProperty(value = "需求方名称")
    private String demandName;
    @ApiModelProperty(value = "需求方代理人")
    private String demandAgentName;
    @ApiModelProperty(value = "需求方电话")
    private String demandTelphone;
    @ApiModelProperty(value = "需求方传真")
    private String demandFax;
    @ApiModelProperty(value = "需求方地址")
    private String demandAddress;
    @ApiModelProperty(value = "供应方")
    private String supplyName;
    @ApiModelProperty(value = "供应方代理人")
    private String supplyAgentName;
    @ApiModelProperty(value = "供应方电话")
    private String supplyTelphone;
    @ApiModelProperty(value = "供应方传真")
    private String supplyFax;
    @ApiModelProperty(value = "供应方地址")
    private String supplyAddress;
    @ApiModelProperty(value = "合同编号")
    private String contractNumber;
    @ApiModelProperty(value = "合同签订日期")
    private String contractSignDate;
    @ApiModelProperty(value = "成品编号")
    private String productNo;
    @ApiModelProperty(value = "成品名称")
    private String productName;
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "标签属性")
    private String lable;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "颜色")
    private String productColor;
    @ApiModelProperty(value = "数量")
    private Integer productNumber;
    @ApiModelProperty(value = "单价")
    private BigDecimal price;
    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "优惠后总价")
    private BigDecimal discountTotalPrice;
    @ApiModelProperty(value = "材质说明")
    private String materialDescription;
    @ApiModelProperty(value = "成品备注")
    private String productRemark;
    @ApiModelProperty(value = "采购反馈时间")
    private String purchaseFeedbackTime;
    @ApiModelProperty(value = "生产反馈时间")
    private String productionFeedbackTime;
    @ApiModelProperty(value = "特殊要求")
    private String specialRequire;
    @ApiModelProperty(value = "随货资料")
    private String cargoInformation;
    @ApiModelProperty(value = "标牌")
    private String signBoard;
    @ApiModelProperty(value = "验收标准")
    private String acceptanceCriteria;
    @ApiModelProperty(value = "质保期限")
    private String warrantyPeriod;
    @ApiModelProperty(value = "包装规范")
    private String packagingSpecification;
    @ApiModelProperty(value = "运输方式")
    private String transportType;
    @ApiModelProperty(value = "发货时间")
    private String deliveryTime;
    @ApiModelProperty(value = "收货信息")
    private String receiptInfo;
    @ApiModelProperty(value = "付款方式")
    private String paymentMethod;
    @ApiModelProperty(value = "运费承担")
    private String freight;
}
