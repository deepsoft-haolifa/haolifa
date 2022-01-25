package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizReimburseTravelDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizReimburseTravelDetailExample() {
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

        public Criteria andReimburseIdIsNull() {
            addCriterion("reimburse_id is null");
            return (Criteria) this;
        }

        public Criteria andReimburseIdIsNotNull() {
            addCriterion("reimburse_id is not null");
            return (Criteria) this;
        }

        public Criteria andReimburseIdEqualTo(Integer value) {
            addCriterion("reimburse_id =", value, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdNotEqualTo(Integer value) {
            addCriterion("reimburse_id <>", value, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdGreaterThan(Integer value) {
            addCriterion("reimburse_id >", value, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reimburse_id >=", value, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdLessThan(Integer value) {
            addCriterion("reimburse_id <", value, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdLessThanOrEqualTo(Integer value) {
            addCriterion("reimburse_id <=", value, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdIn(List<Integer> values) {
            addCriterion("reimburse_id in", values, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdNotIn(List<Integer> values) {
            addCriterion("reimburse_id not in", values, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdBetween(Integer value1, Integer value2) {
            addCriterion("reimburse_id between", value1, value2, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andReimburseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reimburse_id not between", value1, value2, "reimburseId");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNull() {
            addCriterion("serial_no is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("serial_no =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("serial_no <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("serial_no >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("serial_no >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("serial_no <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("serial_no <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("serial_no like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("serial_no not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("serial_no in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("serial_no not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("serial_no between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("serial_no not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andDepTimeIsNull() {
            addCriterion("dep_time is null");
            return (Criteria) this;
        }

        public Criteria andDepTimeIsNotNull() {
            addCriterion("dep_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepTimeEqualTo(Date value) {
            addCriterion("dep_time =", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotEqualTo(Date value) {
            addCriterion("dep_time <>", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeGreaterThan(Date value) {
            addCriterion("dep_time >", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dep_time >=", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeLessThan(Date value) {
            addCriterion("dep_time <", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeLessThanOrEqualTo(Date value) {
            addCriterion("dep_time <=", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeIn(List<Date> values) {
            addCriterion("dep_time in", values, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotIn(List<Date> values) {
            addCriterion("dep_time not in", values, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeBetween(Date value1, Date value2) {
            addCriterion("dep_time between", value1, value2, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotBetween(Date value1, Date value2) {
            addCriterion("dep_time not between", value1, value2, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepAddressIsNull() {
            addCriterion("dep_address is null");
            return (Criteria) this;
        }

        public Criteria andDepAddressIsNotNull() {
            addCriterion("dep_address is not null");
            return (Criteria) this;
        }

        public Criteria andDepAddressEqualTo(String value) {
            addCriterion("dep_address =", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressNotEqualTo(String value) {
            addCriterion("dep_address <>", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressGreaterThan(String value) {
            addCriterion("dep_address >", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressGreaterThanOrEqualTo(String value) {
            addCriterion("dep_address >=", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressLessThan(String value) {
            addCriterion("dep_address <", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressLessThanOrEqualTo(String value) {
            addCriterion("dep_address <=", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressLike(String value) {
            addCriterion("dep_address like", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressNotLike(String value) {
            addCriterion("dep_address not like", value, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressIn(List<String> values) {
            addCriterion("dep_address in", values, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressNotIn(List<String> values) {
            addCriterion("dep_address not in", values, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressBetween(String value1, String value2) {
            addCriterion("dep_address between", value1, value2, "depAddress");
            return (Criteria) this;
        }

        public Criteria andDepAddressNotBetween(String value1, String value2) {
            addCriterion("dep_address not between", value1, value2, "depAddress");
            return (Criteria) this;
        }

        public Criteria andArrTimeIsNull() {
            addCriterion("arr_time is null");
            return (Criteria) this;
        }

        public Criteria andArrTimeIsNotNull() {
            addCriterion("arr_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrTimeEqualTo(Date value) {
            addCriterion("arr_time =", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotEqualTo(Date value) {
            addCriterion("arr_time <>", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeGreaterThan(Date value) {
            addCriterion("arr_time >", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("arr_time >=", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLessThan(Date value) {
            addCriterion("arr_time <", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLessThanOrEqualTo(Date value) {
            addCriterion("arr_time <=", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeIn(List<Date> values) {
            addCriterion("arr_time in", values, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotIn(List<Date> values) {
            addCriterion("arr_time not in", values, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeBetween(Date value1, Date value2) {
            addCriterion("arr_time between", value1, value2, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotBetween(Date value1, Date value2) {
            addCriterion("arr_time not between", value1, value2, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrAddressIsNull() {
            addCriterion("arr_address is null");
            return (Criteria) this;
        }

        public Criteria andArrAddressIsNotNull() {
            addCriterion("arr_address is not null");
            return (Criteria) this;
        }

        public Criteria andArrAddressEqualTo(String value) {
            addCriterion("arr_address =", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressNotEqualTo(String value) {
            addCriterion("arr_address <>", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressGreaterThan(String value) {
            addCriterion("arr_address >", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressGreaterThanOrEqualTo(String value) {
            addCriterion("arr_address >=", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressLessThan(String value) {
            addCriterion("arr_address <", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressLessThanOrEqualTo(String value) {
            addCriterion("arr_address <=", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressLike(String value) {
            addCriterion("arr_address like", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressNotLike(String value) {
            addCriterion("arr_address not like", value, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressIn(List<String> values) {
            addCriterion("arr_address in", values, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressNotIn(List<String> values) {
            addCriterion("arr_address not in", values, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressBetween(String value1, String value2) {
            addCriterion("arr_address between", value1, value2, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andArrAddressNotBetween(String value1, String value2) {
            addCriterion("arr_address not between", value1, value2, "arrAddress");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNull() {
            addCriterion("vehicle is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNotNull() {
            addCriterion("vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleEqualTo(Integer value) {
            addCriterion("vehicle =", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotEqualTo(Integer value) {
            addCriterion("vehicle <>", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThan(Integer value) {
            addCriterion("vehicle >", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle >=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThan(Integer value) {
            addCriterion("vehicle <", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle <=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleIn(List<Integer> values) {
            addCriterion("vehicle in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotIn(List<Integer> values) {
            addCriterion("vehicle not in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleBetween(Integer value1, Integer value2) {
            addCriterion("vehicle between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle not between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumIsNull() {
            addCriterion("vehicle_doc_num is null");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumIsNotNull() {
            addCriterion("vehicle_doc_num is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumEqualTo(Integer value) {
            addCriterion("vehicle_doc_num =", value, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumNotEqualTo(Integer value) {
            addCriterion("vehicle_doc_num <>", value, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumGreaterThan(Integer value) {
            addCriterion("vehicle_doc_num >", value, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_doc_num >=", value, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumLessThan(Integer value) {
            addCriterion("vehicle_doc_num <", value, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_doc_num <=", value, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumIn(List<Integer> values) {
            addCriterion("vehicle_doc_num in", values, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumNotIn(List<Integer> values) {
            addCriterion("vehicle_doc_num not in", values, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_doc_num between", value1, value2, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleDocNumNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_doc_num not between", value1, value2, "vehicleDocNum");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountIsNull() {
            addCriterion("vehicle_amount is null");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountIsNotNull() {
            addCriterion("vehicle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountEqualTo(BigDecimal value) {
            addCriterion("vehicle_amount =", value, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountNotEqualTo(BigDecimal value) {
            addCriterion("vehicle_amount <>", value, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountGreaterThan(BigDecimal value) {
            addCriterion("vehicle_amount >", value, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicle_amount >=", value, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountLessThan(BigDecimal value) {
            addCriterion("vehicle_amount <", value, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicle_amount <=", value, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountIn(List<BigDecimal> values) {
            addCriterion("vehicle_amount in", values, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountNotIn(List<BigDecimal> values) {
            addCriterion("vehicle_amount not in", values, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicle_amount between", value1, value2, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andVehicleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicle_amount not between", value1, value2, "vehicleAmount");
            return (Criteria) this;
        }

        public Criteria andTravelDaysIsNull() {
            addCriterion("travel_days is null");
            return (Criteria) this;
        }

        public Criteria andTravelDaysIsNotNull() {
            addCriterion("travel_days is not null");
            return (Criteria) this;
        }

        public Criteria andTravelDaysEqualTo(Integer value) {
            addCriterion("travel_days =", value, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysNotEqualTo(Integer value) {
            addCriterion("travel_days <>", value, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysGreaterThan(Integer value) {
            addCriterion("travel_days >", value, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_days >=", value, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysLessThan(Integer value) {
            addCriterion("travel_days <", value, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysLessThanOrEqualTo(Integer value) {
            addCriterion("travel_days <=", value, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysIn(List<Integer> values) {
            addCriterion("travel_days in", values, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysNotIn(List<Integer> values) {
            addCriterion("travel_days not in", values, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysBetween(Integer value1, Integer value2) {
            addCriterion("travel_days between", value1, value2, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_days not between", value1, value2, "travelDays");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountIsNull() {
            addCriterion("travel_subsidy_amount is null");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountIsNotNull() {
            addCriterion("travel_subsidy_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountEqualTo(BigDecimal value) {
            addCriterion("travel_subsidy_amount =", value, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountNotEqualTo(BigDecimal value) {
            addCriterion("travel_subsidy_amount <>", value, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountGreaterThan(BigDecimal value) {
            addCriterion("travel_subsidy_amount >", value, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("travel_subsidy_amount >=", value, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountLessThan(BigDecimal value) {
            addCriterion("travel_subsidy_amount <", value, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("travel_subsidy_amount <=", value, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountIn(List<BigDecimal> values) {
            addCriterion("travel_subsidy_amount in", values, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountNotIn(List<BigDecimal> values) {
            addCriterion("travel_subsidy_amount not in", values, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("travel_subsidy_amount between", value1, value2, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andTravelSubsidyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("travel_subsidy_amount not between", value1, value2, "travelSubsidyAmount");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Integer value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Integer value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Integer value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Integer value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Integer> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Integer> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumIsNull() {
            addCriterion("project_doc_num is null");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumIsNotNull() {
            addCriterion("project_doc_num is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumEqualTo(Integer value) {
            addCriterion("project_doc_num =", value, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumNotEqualTo(Integer value) {
            addCriterion("project_doc_num <>", value, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumGreaterThan(Integer value) {
            addCriterion("project_doc_num >", value, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_doc_num >=", value, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumLessThan(Integer value) {
            addCriterion("project_doc_num <", value, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumLessThanOrEqualTo(Integer value) {
            addCriterion("project_doc_num <=", value, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumIn(List<Integer> values) {
            addCriterion("project_doc_num in", values, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumNotIn(List<Integer> values) {
            addCriterion("project_doc_num not in", values, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumBetween(Integer value1, Integer value2) {
            addCriterion("project_doc_num between", value1, value2, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectDocNumNotBetween(Integer value1, Integer value2) {
            addCriterion("project_doc_num not between", value1, value2, "projectDocNum");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIsNull() {
            addCriterion("project_amount is null");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIsNotNull() {
            addCriterion("project_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAmountEqualTo(BigDecimal value) {
            addCriterion("project_amount =", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotEqualTo(BigDecimal value) {
            addCriterion("project_amount <>", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountGreaterThan(BigDecimal value) {
            addCriterion("project_amount >", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_amount >=", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLessThan(BigDecimal value) {
            addCriterion("project_amount <", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_amount <=", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIn(List<BigDecimal> values) {
            addCriterion("project_amount in", values, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotIn(List<BigDecimal> values) {
            addCriterion("project_amount not in", values, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_amount between", value1, value2, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_amount not between", value1, value2, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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