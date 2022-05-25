package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessAnalysisRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessAnalysisRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableIsNull() {
            addCriterion("total_accounts_receivable is null");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableIsNotNull() {
            addCriterion("total_accounts_receivable is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableEqualTo(BigDecimal value) {
            addCriterion("total_accounts_receivable =", value, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableNotEqualTo(BigDecimal value) {
            addCriterion("total_accounts_receivable <>", value, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableGreaterThan(BigDecimal value) {
            addCriterion("total_accounts_receivable >", value, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_accounts_receivable >=", value, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableLessThan(BigDecimal value) {
            addCriterion("total_accounts_receivable <", value, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_accounts_receivable <=", value, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableIn(List<BigDecimal> values) {
            addCriterion("total_accounts_receivable in", values, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableNotIn(List<BigDecimal> values) {
            addCriterion("total_accounts_receivable not in", values, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_accounts_receivable between", value1, value2, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsReceivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_accounts_receivable not between", value1, value2, "totalAccountsReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableIsNull() {
            addCriterion("due_receivable is null");
            return (Criteria) this;
        }

        public Criteria andDueReceivableIsNotNull() {
            addCriterion("due_receivable is not null");
            return (Criteria) this;
        }

        public Criteria andDueReceivableEqualTo(BigDecimal value) {
            addCriterion("due_receivable =", value, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableNotEqualTo(BigDecimal value) {
            addCriterion("due_receivable <>", value, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableGreaterThan(BigDecimal value) {
            addCriterion("due_receivable >", value, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("due_receivable >=", value, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableLessThan(BigDecimal value) {
            addCriterion("due_receivable <", value, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("due_receivable <=", value, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableIn(List<BigDecimal> values) {
            addCriterion("due_receivable in", values, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableNotIn(List<BigDecimal> values) {
            addCriterion("due_receivable not in", values, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("due_receivable between", value1, value2, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andDueReceivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("due_receivable not between", value1, value2, "dueReceivable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableIsNull() {
            addCriterion("total_accounts_payable is null");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableIsNotNull() {
            addCriterion("total_accounts_payable is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableEqualTo(BigDecimal value) {
            addCriterion("total_accounts_payable =", value, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableNotEqualTo(BigDecimal value) {
            addCriterion("total_accounts_payable <>", value, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableGreaterThan(BigDecimal value) {
            addCriterion("total_accounts_payable >", value, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_accounts_payable >=", value, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableLessThan(BigDecimal value) {
            addCriterion("total_accounts_payable <", value, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_accounts_payable <=", value, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableIn(List<BigDecimal> values) {
            addCriterion("total_accounts_payable in", values, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableNotIn(List<BigDecimal> values) {
            addCriterion("total_accounts_payable not in", values, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_accounts_payable between", value1, value2, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andTotalAccountsPayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_accounts_payable not between", value1, value2, "totalAccountsPayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableIsNull() {
            addCriterion("due_payable is null");
            return (Criteria) this;
        }

        public Criteria andDuePayableIsNotNull() {
            addCriterion("due_payable is not null");
            return (Criteria) this;
        }

        public Criteria andDuePayableEqualTo(BigDecimal value) {
            addCriterion("due_payable =", value, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableNotEqualTo(BigDecimal value) {
            addCriterion("due_payable <>", value, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableGreaterThan(BigDecimal value) {
            addCriterion("due_payable >", value, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("due_payable >=", value, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableLessThan(BigDecimal value) {
            addCriterion("due_payable <", value, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("due_payable <=", value, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableIn(List<BigDecimal> values) {
            addCriterion("due_payable in", values, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableNotIn(List<BigDecimal> values) {
            addCriterion("due_payable not in", values, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("due_payable between", value1, value2, "duePayable");
            return (Criteria) this;
        }

        public Criteria andDuePayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("due_payable not between", value1, value2, "duePayable");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueIsNull() {
            addCriterion("total_output_value is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueIsNotNull() {
            addCriterion("total_output_value is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueEqualTo(BigDecimal value) {
            addCriterion("total_output_value =", value, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueNotEqualTo(BigDecimal value) {
            addCriterion("total_output_value <>", value, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueGreaterThan(BigDecimal value) {
            addCriterion("total_output_value >", value, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_output_value >=", value, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueLessThan(BigDecimal value) {
            addCriterion("total_output_value <", value, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_output_value <=", value, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueIn(List<BigDecimal> values) {
            addCriterion("total_output_value in", values, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueNotIn(List<BigDecimal> values) {
            addCriterion("total_output_value not in", values, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_output_value between", value1, value2, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOutputValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_output_value not between", value1, value2, "totalOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueIsNull() {
            addCriterion("current_month_output_value is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueIsNotNull() {
            addCriterion("current_month_output_value is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueEqualTo(BigDecimal value) {
            addCriterion("current_month_output_value =", value, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueNotEqualTo(BigDecimal value) {
            addCriterion("current_month_output_value <>", value, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueGreaterThan(BigDecimal value) {
            addCriterion("current_month_output_value >", value, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_output_value >=", value, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueLessThan(BigDecimal value) {
            addCriterion("current_month_output_value <", value, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_output_value <=", value, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueIn(List<BigDecimal> values) {
            addCriterion("current_month_output_value in", values, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueNotIn(List<BigDecimal> values) {
            addCriterion("current_month_output_value not in", values, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_output_value between", value1, value2, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOutputValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_output_value not between", value1, value2, "currentMonthOutputValue");
            return (Criteria) this;
        }

        public Criteria andTotalOrderIsNull() {
            addCriterion("total_order is null");
            return (Criteria) this;
        }

        public Criteria andTotalOrderIsNotNull() {
            addCriterion("total_order is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOrderEqualTo(BigDecimal value) {
            addCriterion("total_order =", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotEqualTo(BigDecimal value) {
            addCriterion("total_order <>", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderGreaterThan(BigDecimal value) {
            addCriterion("total_order >", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_order >=", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderLessThan(BigDecimal value) {
            addCriterion("total_order <", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_order <=", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderIn(List<BigDecimal> values) {
            addCriterion("total_order in", values, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotIn(List<BigDecimal> values) {
            addCriterion("total_order not in", values, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_order between", value1, value2, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_order not between", value1, value2, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderIsNull() {
            addCriterion("current_month_total_order is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderIsNotNull() {
            addCriterion("current_month_total_order is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderEqualTo(BigDecimal value) {
            addCriterion("current_month_total_order =", value, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderNotEqualTo(BigDecimal value) {
            addCriterion("current_month_total_order <>", value, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderGreaterThan(BigDecimal value) {
            addCriterion("current_month_total_order >", value, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_total_order >=", value, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderLessThan(BigDecimal value) {
            addCriterion("current_month_total_order <", value, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_total_order <=", value, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderIn(List<BigDecimal> values) {
            addCriterion("current_month_total_order in", values, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderNotIn(List<BigDecimal> values) {
            addCriterion("current_month_total_order not in", values, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_total_order between", value1, value2, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthTotalOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_total_order not between", value1, value2, "currentMonthTotalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalProfitIsNull() {
            addCriterion("total_profit is null");
            return (Criteria) this;
        }

        public Criteria andTotalProfitIsNotNull() {
            addCriterion("total_profit is not null");
            return (Criteria) this;
        }

        public Criteria andTotalProfitEqualTo(BigDecimal value) {
            addCriterion("total_profit =", value, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitNotEqualTo(BigDecimal value) {
            addCriterion("total_profit <>", value, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitGreaterThan(BigDecimal value) {
            addCriterion("total_profit >", value, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_profit >=", value, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitLessThan(BigDecimal value) {
            addCriterion("total_profit <", value, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_profit <=", value, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitIn(List<BigDecimal> values) {
            addCriterion("total_profit in", values, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitNotIn(List<BigDecimal> values) {
            addCriterion("total_profit not in", values, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_profit between", value1, value2, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andTotalProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_profit not between", value1, value2, "totalProfit");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesIsNull() {
            addCriterion("total_expenses is null");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesIsNotNull() {
            addCriterion("total_expenses is not null");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesEqualTo(BigDecimal value) {
            addCriterion("total_expenses =", value, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesNotEqualTo(BigDecimal value) {
            addCriterion("total_expenses <>", value, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesGreaterThan(BigDecimal value) {
            addCriterion("total_expenses >", value, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_expenses >=", value, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesLessThan(BigDecimal value) {
            addCriterion("total_expenses <", value, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_expenses <=", value, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesIn(List<BigDecimal> values) {
            addCriterion("total_expenses in", values, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesNotIn(List<BigDecimal> values) {
            addCriterion("total_expenses not in", values, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_expenses between", value1, value2, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andTotalExpensesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_expenses not between", value1, value2, "totalExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesIsNull() {
            addCriterion("various_expenses is null");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesIsNotNull() {
            addCriterion("various_expenses is not null");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesEqualTo(BigDecimal value) {
            addCriterion("various_expenses =", value, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesNotEqualTo(BigDecimal value) {
            addCriterion("various_expenses <>", value, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesGreaterThan(BigDecimal value) {
            addCriterion("various_expenses >", value, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("various_expenses >=", value, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesLessThan(BigDecimal value) {
            addCriterion("various_expenses <", value, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("various_expenses <=", value, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesIn(List<BigDecimal> values) {
            addCriterion("various_expenses in", values, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesNotIn(List<BigDecimal> values) {
            addCriterion("various_expenses not in", values, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("various_expenses between", value1, value2, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andVariousExpensesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("various_expenses not between", value1, value2, "variousExpenses");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioIsNull() {
            addCriterion("asset_liability_ratio is null");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioIsNotNull() {
            addCriterion("asset_liability_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioEqualTo(BigDecimal value) {
            addCriterion("asset_liability_ratio =", value, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioNotEqualTo(BigDecimal value) {
            addCriterion("asset_liability_ratio <>", value, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioGreaterThan(BigDecimal value) {
            addCriterion("asset_liability_ratio >", value, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("asset_liability_ratio >=", value, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioLessThan(BigDecimal value) {
            addCriterion("asset_liability_ratio <", value, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("asset_liability_ratio <=", value, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioIn(List<BigDecimal> values) {
            addCriterion("asset_liability_ratio in", values, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioNotIn(List<BigDecimal> values) {
            addCriterion("asset_liability_ratio not in", values, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("asset_liability_ratio between", value1, value2, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andAssetLiabilityRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("asset_liability_ratio not between", value1, value2, "assetLiabilityRatio");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginIsNull() {
            addCriterion("sales_profit_margin is null");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginIsNotNull() {
            addCriterion("sales_profit_margin is not null");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginEqualTo(BigDecimal value) {
            addCriterion("sales_profit_margin =", value, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginNotEqualTo(BigDecimal value) {
            addCriterion("sales_profit_margin <>", value, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginGreaterThan(BigDecimal value) {
            addCriterion("sales_profit_margin >", value, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_profit_margin >=", value, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginLessThan(BigDecimal value) {
            addCriterion("sales_profit_margin <", value, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_profit_margin <=", value, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginIn(List<BigDecimal> values) {
            addCriterion("sales_profit_margin in", values, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginNotIn(List<BigDecimal> values) {
            addCriterion("sales_profit_margin not in", values, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_profit_margin between", value1, value2, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andSalesProfitMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_profit_margin not between", value1, value2, "salesProfitMargin");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationIsNull() {
            addCriterion("cost_utilization is null");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationIsNotNull() {
            addCriterion("cost_utilization is not null");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationEqualTo(BigDecimal value) {
            addCriterion("cost_utilization =", value, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationNotEqualTo(BigDecimal value) {
            addCriterion("cost_utilization <>", value, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationGreaterThan(BigDecimal value) {
            addCriterion("cost_utilization >", value, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_utilization >=", value, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationLessThan(BigDecimal value) {
            addCriterion("cost_utilization <", value, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_utilization <=", value, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationIn(List<BigDecimal> values) {
            addCriterion("cost_utilization in", values, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationNotIn(List<BigDecimal> values) {
            addCriterion("cost_utilization not in", values, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_utilization between", value1, value2, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCostUtilizationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_utilization not between", value1, value2, "costUtilization");
            return (Criteria) this;
        }

        public Criteria andCashFlowIsNull() {
            addCriterion("cash_flow is null");
            return (Criteria) this;
        }

        public Criteria andCashFlowIsNotNull() {
            addCriterion("cash_flow is not null");
            return (Criteria) this;
        }

        public Criteria andCashFlowEqualTo(BigDecimal value) {
            addCriterion("cash_flow =", value, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowNotEqualTo(BigDecimal value) {
            addCriterion("cash_flow <>", value, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowGreaterThan(BigDecimal value) {
            addCriterion("cash_flow >", value, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_flow >=", value, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowLessThan(BigDecimal value) {
            addCriterion("cash_flow <", value, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_flow <=", value, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowIn(List<BigDecimal> values) {
            addCriterion("cash_flow in", values, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowNotIn(List<BigDecimal> values) {
            addCriterion("cash_flow not in", values, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_flow between", value1, value2, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andCashFlowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_flow not between", value1, value2, "cashFlow");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostIsNull() {
            addCriterion("manufacturing_cost is null");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostIsNotNull() {
            addCriterion("manufacturing_cost is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost =", value, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostNotEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost <>", value, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostGreaterThan(BigDecimal value) {
            addCriterion("manufacturing_cost >", value, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost >=", value, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostLessThan(BigDecimal value) {
            addCriterion("manufacturing_cost <", value, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost <=", value, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostIn(List<BigDecimal> values) {
            addCriterion("manufacturing_cost in", values, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostNotIn(List<BigDecimal> values) {
            addCriterion("manufacturing_cost not in", values, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manufacturing_cost between", value1, value2, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manufacturing_cost not between", value1, value2, "manufacturingCost");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioIsNull() {
            addCriterion("manufacturing_cost_ratio is null");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioIsNotNull() {
            addCriterion("manufacturing_cost_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost_ratio =", value, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioNotEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost_ratio <>", value, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioGreaterThan(BigDecimal value) {
            addCriterion("manufacturing_cost_ratio >", value, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost_ratio >=", value, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioLessThan(BigDecimal value) {
            addCriterion("manufacturing_cost_ratio <", value, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manufacturing_cost_ratio <=", value, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioIn(List<BigDecimal> values) {
            addCriterion("manufacturing_cost_ratio in", values, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioNotIn(List<BigDecimal> values) {
            addCriterion("manufacturing_cost_ratio not in", values, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manufacturing_cost_ratio between", value1, value2, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManufacturingCostRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manufacturing_cost_ratio not between", value1, value2, "manufacturingCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostIsNull() {
            addCriterion("manage_cost is null");
            return (Criteria) this;
        }

        public Criteria andManageCostIsNotNull() {
            addCriterion("manage_cost is not null");
            return (Criteria) this;
        }

        public Criteria andManageCostEqualTo(BigDecimal value) {
            addCriterion("manage_cost =", value, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostNotEqualTo(BigDecimal value) {
            addCriterion("manage_cost <>", value, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostGreaterThan(BigDecimal value) {
            addCriterion("manage_cost >", value, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_cost >=", value, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostLessThan(BigDecimal value) {
            addCriterion("manage_cost <", value, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_cost <=", value, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostIn(List<BigDecimal> values) {
            addCriterion("manage_cost in", values, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostNotIn(List<BigDecimal> values) {
            addCriterion("manage_cost not in", values, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_cost between", value1, value2, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_cost not between", value1, value2, "manageCost");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioIsNull() {
            addCriterion("manage_cost_ratio is null");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioIsNotNull() {
            addCriterion("manage_cost_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioEqualTo(BigDecimal value) {
            addCriterion("manage_cost_ratio =", value, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioNotEqualTo(BigDecimal value) {
            addCriterion("manage_cost_ratio <>", value, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioGreaterThan(BigDecimal value) {
            addCriterion("manage_cost_ratio >", value, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_cost_ratio >=", value, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioLessThan(BigDecimal value) {
            addCriterion("manage_cost_ratio <", value, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_cost_ratio <=", value, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioIn(List<BigDecimal> values) {
            addCriterion("manage_cost_ratio in", values, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioNotIn(List<BigDecimal> values) {
            addCriterion("manage_cost_ratio not in", values, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_cost_ratio between", value1, value2, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andManageCostRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_cost_ratio not between", value1, value2, "manageCostRatio");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}