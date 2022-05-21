package com.deepsoft.haolifa.model.dto.businessAnalysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 首页经营分析
 *
 * @author murphy.he
 **/
@Data
public class BusinessAnalysisDTO {
    /**
     * 年份
     */
    @ApiModelProperty("年份")
    private String year;

    /**
     * 应收账款总额
     */
    @ApiModelProperty("应收账款总额")
    private BigDecimal totalAccountsReceivable;

    /**
     * 到期应收
     */
    @ApiModelProperty("到期应收")
    private BigDecimal dueReceivable;

    /**
     * 应付账款总额
     */
    @ApiModelProperty("应付账款总额")
    private BigDecimal totalAccountsPayable;

    /**
     * 产值总额
     */
    @ApiModelProperty("产值总额")
    private BigDecimal totalOutputValue;

    /**
     * 当月产值
     */
    @ApiModelProperty("当月产值")
    private BigDecimal currentMonthOutputValue;

    /**
     * 订货总额
     */
    @ApiModelProperty("订货总额")
    private BigDecimal totalOrder;

    /**
     * 当月订货额
     */
    @ApiModelProperty("当月订货额")
    private BigDecimal currentMonthTotalOrder;

    /**
     * 利润总额
     */
    @ApiModelProperty("利润总额")
    private BigDecimal totalProfit;

    /**
     * 成本费用
     */
    @ApiModelProperty("成本费用")
    private BigDecimal cost;

    /**
     * 费用合计
     */
    @ApiModelProperty("费用合计")
    private BigDecimal totalExpenses;

    /**
     * 各项费用支出总额
     */
    @ApiModelProperty("各项费用支出总额")
    private BigDecimal variousExpenses;

    /**
     * 资产负债率
     */
    @ApiModelProperty("资产负债率")
    private BigDecimal assetLiabilityRatio;

    /**
     * 销售利润率
     */
    @ApiModelProperty("销售利润率")
    private BigDecimal salesProfitMargin;

    /**
     * 成本费用利用率
     */
    @ApiModelProperty("成本费用利用率")
    private BigDecimal costUtilization;

    /**
     * 现金流量
     */
    @ApiModelProperty("现金流量")
    private BigDecimal cashFlow;

    /**
     * 制造成本
     */
    @ApiModelProperty("制造成本")
    private BigDecimal manufacturingCost;

    /**
     * 管理成本
     */
    @ApiModelProperty("管理成本")
    private BigDecimal manageCost;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
}
