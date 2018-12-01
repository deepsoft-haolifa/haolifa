package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderProductDTO {

    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "成品合同订单号(上传的订单上面的)")
    private String orderContractNo;
    @ApiModelProperty(value = "订单合同url")
    private String orderContractUrl;
    @ApiModelProperty(value = "工厂反馈完成时间")
    private String finishFeedbackTime;
    @ApiModelProperty(value = "反馈确认人")
    private String feedbackTimeConfirmUser;
    @ApiModelProperty(value = "采购反馈时间")
    private String purchaseFeedbackTime;
    @ApiModelProperty(value = "生产反馈时间")
    private String productionFeedbackTime;
    @ApiModelProperty(value = "需求方名称")
    private String demandName;
    @ApiModelProperty(value = "需求方代理人")
    private String demandAgentName;
    @ApiModelProperty(value = "需求方电话")
    private String demandPhone;
    @ApiModelProperty(value = "需求方传真")
    private String demandFax;
    @ApiModelProperty(value = "需求开户银行")
    private String demandBankName;
    @ApiModelProperty(value = "需求开户银行账号")
    private String demandBankCardNo;
    @ApiModelProperty(value = "供应方")
    private String supplyName;
    @ApiModelProperty(value = "供应方代理人")
    private String supplyAgentName;
    @ApiModelProperty(value = "供应方电话")
    private String supplyPhone;
    @ApiModelProperty(value = "供应方传真")
    private String supplyFax;
    @ApiModelProperty(value = "供应方开户银行")
    private String supplyBankName;
    @ApiModelProperty(value = "需求开户银行账号")
    private String supplyBankCardNo;
    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;
    @ApiModelProperty(value = "交货时间")
    private String deliveryDate;
    @ApiModelProperty(value = "合同签订日期")
    private String contractSignDate;
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
    @ApiModelProperty(value = "质保期限")
    private String warrantyPeriod;
    @ApiModelProperty(value = "包装规范")
    private String packagingSpecification;
    @ApiModelProperty(value = "订单产品列表")
    List<OrderProductAssociate> orderProductAssociates;

    @ApiModelProperty(value = "技术清单")
    private String technicalRequire;

    @ApiModelProperty(value = "装配车间")
    private String assemblyShop;

    @ApiModelProperty(value = "装配小组")
    private String assemblyGroup;

}
