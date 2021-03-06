package com.deepsoft.haolifa.model.dto.order;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 生成订单合同的参数
 */
@Data
public class GenerateOrderDTO {

    @ApiModelProperty(value = "需方")
    private String demandName;
    @ApiModelProperty(value = "供应方")
    private String supplyName;
    @ApiModelProperty(value = "平台编码")
    private String orderContractNo;
    @ApiModelProperty(value = "签订日期")
    private String contractSignDate;

    @ApiModelProperty(value = "订单产品列表")
    List<OrderProductAssociate> orderProductAssociates;

    @ApiModelProperty(value = "总计数量")
    private Integer totalCount;
    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "优惠后总价")
    private BigDecimal discountTotalPrice;

    @ApiModelProperty(value = "特殊要求")
    private String specialRequire;
    @ApiModelProperty(value = "随货资料")
    private String cargoInformation;
    @ApiModelProperty(value = "标牌")
    private String signBoard;
    @ApiModelProperty(value = "验收标准")
    private String acceptanceCriteria;
    @ApiModelProperty(value = "质量保证")
    private String warrantyPeriod;
    @ApiModelProperty(value = "包装规范")
    private String packagingSpecification;
    @ApiModelProperty(value = "运输方式")
    private String transportMode;
    @ApiModelProperty(value = "发货日期")
    private String deliveryDate;
    @ApiModelProperty(value = "收货信息")
    private String receivingInformation;
    @ApiModelProperty(value = "付款方式")
    private String paymentMethod;
    @ApiModelProperty(value = "运费承担")
    private String freightCharges;
    @ApiModelProperty(value = "违约责任")
    private String liabilityForBreach;


    @ApiModelProperty(value = "需求方代理人")
    private String demandAgentName;
    @ApiModelProperty(value = "需求方电话")
    private String demandPhone;
    @ApiModelProperty(value = "需求方传真")
    private String demandFax;
    @ApiModelProperty(value = "需求方地址")
    private String demandAddress;

    @ApiModelProperty(value = "供应方代理人")
    private String supplyAgentName;
    @ApiModelProperty(value = "供应方电话")
    private String supplyPhone;
    @ApiModelProperty(value = "供应方传真")
    private String supplyFax;
    @ApiModelProperty(value = "供应方地址")
    private String supplyAddress;





}
