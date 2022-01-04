package com.deepsoft.haolifa.model.dto.finance.receivable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class ReceivableOrderRSDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "这些字段待确定 归属部门，发票类别，发货时间，付款方式")
    private String aaa;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建用户")
    private Integer createUser;

    @ApiModelProperty(value = "更新用户")
    private Integer updateUser;
    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "rs-合同编号")
    private String orderContractNo;

    @ApiModelProperty(value = "s-订单状态")
    private Byte orderStatus;

    @ApiModelProperty(value = "订单合同url")
    private String orderContractUrl;

    @ApiModelProperty(value = "订单合同url（价格隐藏）")
    private String orderContractExtendUrl;

    @ApiModelProperty(value = "技术清单（技术员填写）")
    private String technicalRequire;

    @ApiModelProperty(value = "工厂反馈完成时间")
    private String finishFeedbackTime;

    @ApiModelProperty(value = "反馈确认人")
    private String feedbackTimeConfirmUser;

    @ApiModelProperty(value = "采购反馈时间")
    private String purchaseFeedbackTime;

    @ApiModelProperty(value = "生产反馈时间")
    private String productionFeedbackTime;

    @ApiModelProperty(value = "装配车间")
    private String assemblyShop;

    @ApiModelProperty(value = "装配小组")
    private String assemblyGroup;

    @ApiModelProperty(value = "rs-需求方名称")
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

    @ApiModelProperty(value = "rs-供应方")
    private String supplyName;

    @ApiModelProperty(value = "rs-供应方代理人")
    private String supplyAgentName;

    @ApiModelProperty(value = "供应方电话")
    private String supplyPhone;

    @ApiModelProperty(value = "供应方传真")
    private String supplyFax;

    @ApiModelProperty(value = "供应方开户银行")
    private String supplyBankName;

    @ApiModelProperty(value = "供应方开户银行账号")
    private String contractBankCardNo;

    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;

    @ApiModelProperty(value = "交货日期")
    private String deliveryDate;

    @ApiModelProperty(value = "rs-合同签订日期")
    private String contractSignDate;

    @ApiModelProperty(value = "s-数量合计")
    private Integer totalCount;

    @ApiModelProperty(value = "s-优惠后总价")
    private BigDecimal discountTotalPrice;

    @ApiModelProperty(value = "s-总价")
    private BigDecimal totalPrice;

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

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "发货状态：0 待发货（默认） 1 部分发货 2 发货完成")
    private Byte deliverStatus;

    @ApiModelProperty(value = "订单附件")
    private String accessory;

    @ApiModelProperty(value = "成品检验合格数量")
    private Integer qualifiedNumber;

    @ApiModelProperty(value = "压力检测合格数量")
    private Integer pressureQualifiedNumber;

    @ApiModelProperty(value = "s-已发货数量")
    private Integer deliveredNumber;

    @ApiModelProperty(value = "s-已收货款")
    private BigDecimal receivedAccount;

    @ApiModelProperty(value = "是否生成了领料单（0 否；1.是）")
    private Byte genPickingList;

    @ApiModelProperty(value = "此订单是否需要核料（0 不需要；1 需要）")
    private Byte isCheckMaterial;

    @ApiModelProperty(value = "任务状态 0：未分配；1：已分配")
    private Byte taskStatus;

}


