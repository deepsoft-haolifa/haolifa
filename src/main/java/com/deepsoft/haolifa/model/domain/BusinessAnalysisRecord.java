package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BusinessAnalysisRecord {
    /**
     * id
     */
    private Integer id;

    /**
     * 年份
     */
    private String year;

    /**
     * 应收账款总额
     */
    private BigDecimal totalAccountsReceivable;

    /**
     * 到期应收
     */
    private BigDecimal dueReceivable;

    /**
     * 应付账款总额
     */
    private BigDecimal totalAccountsPayable;

    /**
     * 产值总额
     */
    private BigDecimal totalOutputValue;

    /**
     * 当月产值
     */
    private BigDecimal currentMonthOutputValue;

    /**
     * 订货总额
     */
    private BigDecimal totalOrder;

    /**
     * 当月订货额
     */
    private BigDecimal currentMonthTotalOrder;

    /**
     * 利润总额
     */
    private BigDecimal totalProfit;

    /**
     * 成本费用
     */
    private BigDecimal cost;

    /**
     * 费用合计
     */
    private BigDecimal totalExpenses;

    /**
     * 各项费用支出总额
     */
    private BigDecimal variousExpenses;

    /**
     * 资产负债率
     */
    private BigDecimal assetLiabilityRatio;

    /**
     * 销售利润率
     */
    private BigDecimal salesProfitMargin;

    /**
     * 成本费用利用率
     */
    private BigDecimal costUtilization;

    /**
     * 现金流量
     */
    private BigDecimal cashFlow;

    /**
     * 制造成本
     */
    private BigDecimal manufacturingCost;

    /**
     * 管理成本
     */
    private BigDecimal manageCost;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public BusinessAnalysisRecord(Integer id, String year, BigDecimal totalAccountsReceivable, BigDecimal dueReceivable, BigDecimal totalAccountsPayable, BigDecimal totalOutputValue, BigDecimal currentMonthOutputValue, BigDecimal totalOrder, BigDecimal currentMonthTotalOrder, BigDecimal totalProfit, BigDecimal cost, BigDecimal totalExpenses, BigDecimal variousExpenses, BigDecimal assetLiabilityRatio, BigDecimal salesProfitMargin, BigDecimal costUtilization, BigDecimal cashFlow, BigDecimal manufacturingCost, BigDecimal manageCost, Date createTime, Date updateTime) {
        this.id = id;
        this.year = year;
        this.totalAccountsReceivable = totalAccountsReceivable;
        this.dueReceivable = dueReceivable;
        this.totalAccountsPayable = totalAccountsPayable;
        this.totalOutputValue = totalOutputValue;
        this.currentMonthOutputValue = currentMonthOutputValue;
        this.totalOrder = totalOrder;
        this.currentMonthTotalOrder = currentMonthTotalOrder;
        this.totalProfit = totalProfit;
        this.cost = cost;
        this.totalExpenses = totalExpenses;
        this.variousExpenses = variousExpenses;
        this.assetLiabilityRatio = assetLiabilityRatio;
        this.salesProfitMargin = salesProfitMargin;
        this.costUtilization = costUtilization;
        this.cashFlow = cashFlow;
        this.manufacturingCost = manufacturingCost;
        this.manageCost = manageCost;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BusinessAnalysisRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public BigDecimal getTotalAccountsReceivable() {
        return totalAccountsReceivable;
    }

    public void setTotalAccountsReceivable(BigDecimal totalAccountsReceivable) {
        this.totalAccountsReceivable = totalAccountsReceivable;
    }

    public BigDecimal getDueReceivable() {
        return dueReceivable;
    }

    public void setDueReceivable(BigDecimal dueReceivable) {
        this.dueReceivable = dueReceivable;
    }

    public BigDecimal getTotalAccountsPayable() {
        return totalAccountsPayable;
    }

    public void setTotalAccountsPayable(BigDecimal totalAccountsPayable) {
        this.totalAccountsPayable = totalAccountsPayable;
    }

    public BigDecimal getTotalOutputValue() {
        return totalOutputValue;
    }

    public void setTotalOutputValue(BigDecimal totalOutputValue) {
        this.totalOutputValue = totalOutputValue;
    }

    public BigDecimal getCurrentMonthOutputValue() {
        return currentMonthOutputValue;
    }

    public void setCurrentMonthOutputValue(BigDecimal currentMonthOutputValue) {
        this.currentMonthOutputValue = currentMonthOutputValue;
    }

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }

    public BigDecimal getCurrentMonthTotalOrder() {
        return currentMonthTotalOrder;
    }

    public void setCurrentMonthTotalOrder(BigDecimal currentMonthTotalOrder) {
        this.currentMonthTotalOrder = currentMonthTotalOrder;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getVariousExpenses() {
        return variousExpenses;
    }

    public void setVariousExpenses(BigDecimal variousExpenses) {
        this.variousExpenses = variousExpenses;
    }

    public BigDecimal getAssetLiabilityRatio() {
        return assetLiabilityRatio;
    }

    public void setAssetLiabilityRatio(BigDecimal assetLiabilityRatio) {
        this.assetLiabilityRatio = assetLiabilityRatio;
    }

    public BigDecimal getSalesProfitMargin() {
        return salesProfitMargin;
    }

    public void setSalesProfitMargin(BigDecimal salesProfitMargin) {
        this.salesProfitMargin = salesProfitMargin;
    }

    public BigDecimal getCostUtilization() {
        return costUtilization;
    }

    public void setCostUtilization(BigDecimal costUtilization) {
        this.costUtilization = costUtilization;
    }

    public BigDecimal getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(BigDecimal cashFlow) {
        this.cashFlow = cashFlow;
    }

    public BigDecimal getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(BigDecimal manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }

    public BigDecimal getManageCost() {
        return manageCost;
    }

    public void setManageCost(BigDecimal manageCost) {
        this.manageCost = manageCost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
