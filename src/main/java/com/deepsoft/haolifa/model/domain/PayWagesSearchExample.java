package com.deepsoft.haolifa.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayWagesSearchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayWagesSearchExample() {
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

        public Criteria andSerialIsNull() {
            addCriterion("serial is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("serial is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(String value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(String value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(String value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(String value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(String value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(String value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLike(String value) {
            addCriterion("serial like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotLike(String value) {
            addCriterion("serial not like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<String> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<String> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(String value1, String value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(String value1, String value2) {
            addCriterion("serial not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andWagesYearIsNull() {
            addCriterion("wages_year is null");
            return (Criteria) this;
        }

        public Criteria andWagesYearIsNotNull() {
            addCriterion("wages_year is not null");
            return (Criteria) this;
        }

        public Criteria andWagesYearEqualTo(String value) {
            addCriterion("wages_year =", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearNotEqualTo(String value) {
            addCriterion("wages_year <>", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearGreaterThan(String value) {
            addCriterion("wages_year >", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearGreaterThanOrEqualTo(String value) {
            addCriterion("wages_year >=", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearLessThan(String value) {
            addCriterion("wages_year <", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearLessThanOrEqualTo(String value) {
            addCriterion("wages_year <=", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearLike(String value) {
            addCriterion("wages_year like", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearNotLike(String value) {
            addCriterion("wages_year not like", value, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearIn(List<String> values) {
            addCriterion("wages_year in", values, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearNotIn(List<String> values) {
            addCriterion("wages_year not in", values, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearBetween(String value1, String value2) {
            addCriterion("wages_year between", value1, value2, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesYearNotBetween(String value1, String value2) {
            addCriterion("wages_year not between", value1, value2, "wagesYear");
            return (Criteria) this;
        }

        public Criteria andWagesMonthIsNull() {
            addCriterion("wages_month is null");
            return (Criteria) this;
        }

        public Criteria andWagesMonthIsNotNull() {
            addCriterion("wages_month is not null");
            return (Criteria) this;
        }

        public Criteria andWagesMonthEqualTo(String value) {
            addCriterion("wages_month =", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthNotEqualTo(String value) {
            addCriterion("wages_month <>", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthGreaterThan(String value) {
            addCriterion("wages_month >", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthGreaterThanOrEqualTo(String value) {
            addCriterion("wages_month >=", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthLessThan(String value) {
            addCriterion("wages_month <", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthLessThanOrEqualTo(String value) {
            addCriterion("wages_month <=", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthLike(String value) {
            addCriterion("wages_month like", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthNotLike(String value) {
            addCriterion("wages_month not like", value, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthIn(List<String> values) {
            addCriterion("wages_month in", values, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthNotIn(List<String> values) {
            addCriterion("wages_month not in", values, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthBetween(String value1, String value2) {
            addCriterion("wages_month between", value1, value2, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andWagesMonthNotBetween(String value1, String value2) {
            addCriterion("wages_month not between", value1, value2, "wagesMonth");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysIsNull() {
            addCriterion("required_attendance_days is null");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysIsNotNull() {
            addCriterion("required_attendance_days is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysEqualTo(Integer value) {
            addCriterion("required_attendance_days =", value, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysNotEqualTo(Integer value) {
            addCriterion("required_attendance_days <>", value, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysGreaterThan(Integer value) {
            addCriterion("required_attendance_days >", value, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("required_attendance_days >=", value, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysLessThan(Integer value) {
            addCriterion("required_attendance_days <", value, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysLessThanOrEqualTo(Integer value) {
            addCriterion("required_attendance_days <=", value, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysIn(List<Integer> values) {
            addCriterion("required_attendance_days in", values, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysNotIn(List<Integer> values) {
            addCriterion("required_attendance_days not in", values, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysBetween(Integer value1, Integer value2) {
            addCriterion("required_attendance_days between", value1, value2, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRequiredAttendanceDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("required_attendance_days not between", value1, value2, "requiredAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysIsNull() {
            addCriterion("actual_attendance_days is null");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysIsNotNull() {
            addCriterion("actual_attendance_days is not null");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysEqualTo(Integer value) {
            addCriterion("actual_attendance_days =", value, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysNotEqualTo(Integer value) {
            addCriterion("actual_attendance_days <>", value, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysGreaterThan(Integer value) {
            addCriterion("actual_attendance_days >", value, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_attendance_days >=", value, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysLessThan(Integer value) {
            addCriterion("actual_attendance_days <", value, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysLessThanOrEqualTo(Integer value) {
            addCriterion("actual_attendance_days <=", value, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysIn(List<Integer> values) {
            addCriterion("actual_attendance_days in", values, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysNotIn(List<Integer> values) {
            addCriterion("actual_attendance_days not in", values, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysBetween(Integer value1, Integer value2) {
            addCriterion("actual_attendance_days between", value1, value2, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_attendance_days not between", value1, value2, "actualAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesIsNull() {
            addCriterion("late_and_leave_times is null");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesIsNotNull() {
            addCriterion("late_and_leave_times is not null");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesEqualTo(Integer value) {
            addCriterion("late_and_leave_times =", value, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesNotEqualTo(Integer value) {
            addCriterion("late_and_leave_times <>", value, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesGreaterThan(Integer value) {
            addCriterion("late_and_leave_times >", value, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("late_and_leave_times >=", value, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesLessThan(Integer value) {
            addCriterion("late_and_leave_times <", value, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesLessThanOrEqualTo(Integer value) {
            addCriterion("late_and_leave_times <=", value, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesIn(List<Integer> values) {
            addCriterion("late_and_leave_times in", values, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesNotIn(List<Integer> values) {
            addCriterion("late_and_leave_times not in", values, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesBetween(Integer value1, Integer value2) {
            addCriterion("late_and_leave_times between", value1, value2, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("late_and_leave_times not between", value1, value2, "lateAndLeaveTimes");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineIsNull() {
            addCriterion("late_and_leave_fine is null");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineIsNotNull() {
            addCriterion("late_and_leave_fine is not null");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineEqualTo(BigDecimal value) {
            addCriterion("late_and_leave_fine =", value, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineNotEqualTo(BigDecimal value) {
            addCriterion("late_and_leave_fine <>", value, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineGreaterThan(BigDecimal value) {
            addCriterion("late_and_leave_fine >", value, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("late_and_leave_fine >=", value, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineLessThan(BigDecimal value) {
            addCriterion("late_and_leave_fine <", value, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("late_and_leave_fine <=", value, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineIn(List<BigDecimal> values) {
            addCriterion("late_and_leave_fine in", values, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineNotIn(List<BigDecimal> values) {
            addCriterion("late_and_leave_fine not in", values, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("late_and_leave_fine between", value1, value2, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andLateAndLeaveFineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("late_and_leave_fine not between", value1, value2, "lateAndLeaveFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesIsNull() {
            addCriterion("absenteeism_times is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesIsNotNull() {
            addCriterion("absenteeism_times is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesEqualTo(Integer value) {
            addCriterion("absenteeism_times =", value, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesNotEqualTo(Integer value) {
            addCriterion("absenteeism_times <>", value, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesGreaterThan(Integer value) {
            addCriterion("absenteeism_times >", value, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("absenteeism_times >=", value, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesLessThan(Integer value) {
            addCriterion("absenteeism_times <", value, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesLessThanOrEqualTo(Integer value) {
            addCriterion("absenteeism_times <=", value, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesIn(List<Integer> values) {
            addCriterion("absenteeism_times in", values, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesNotIn(List<Integer> values) {
            addCriterion("absenteeism_times not in", values, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesBetween(Integer value1, Integer value2) {
            addCriterion("absenteeism_times between", value1, value2, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("absenteeism_times not between", value1, value2, "absenteeismTimes");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineIsNull() {
            addCriterion("absenteeism_fine is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineIsNotNull() {
            addCriterion("absenteeism_fine is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineEqualTo(BigDecimal value) {
            addCriterion("absenteeism_fine =", value, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineNotEqualTo(BigDecimal value) {
            addCriterion("absenteeism_fine <>", value, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineGreaterThan(BigDecimal value) {
            addCriterion("absenteeism_fine >", value, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("absenteeism_fine >=", value, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineLessThan(BigDecimal value) {
            addCriterion("absenteeism_fine <", value, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("absenteeism_fine <=", value, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineIn(List<BigDecimal> values) {
            addCriterion("absenteeism_fine in", values, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineNotIn(List<BigDecimal> values) {
            addCriterion("absenteeism_fine not in", values, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("absenteeism_fine between", value1, value2, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismFineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("absenteeism_fine not between", value1, value2, "absenteeismFine");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyIsNull() {
            addCriterion("full_attendance_money is null");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyIsNotNull() {
            addCriterion("full_attendance_money is not null");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyEqualTo(BigDecimal value) {
            addCriterion("full_attendance_money =", value, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("full_attendance_money <>", value, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyGreaterThan(BigDecimal value) {
            addCriterion("full_attendance_money >", value, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("full_attendance_money >=", value, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyLessThan(BigDecimal value) {
            addCriterion("full_attendance_money <", value, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("full_attendance_money <=", value, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyIn(List<BigDecimal> values) {
            addCriterion("full_attendance_money in", values, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("full_attendance_money not in", values, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("full_attendance_money between", value1, value2, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andFullAttendanceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("full_attendance_money not between", value1, value2, "fullAttendanceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceCountIsNull() {
            addCriterion("by_piece_count is null");
            return (Criteria) this;
        }

        public Criteria andByPieceCountIsNotNull() {
            addCriterion("by_piece_count is not null");
            return (Criteria) this;
        }

        public Criteria andByPieceCountEqualTo(Integer value) {
            addCriterion("by_piece_count =", value, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountNotEqualTo(Integer value) {
            addCriterion("by_piece_count <>", value, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountGreaterThan(Integer value) {
            addCriterion("by_piece_count >", value, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("by_piece_count >=", value, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountLessThan(Integer value) {
            addCriterion("by_piece_count <", value, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountLessThanOrEqualTo(Integer value) {
            addCriterion("by_piece_count <=", value, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountIn(List<Integer> values) {
            addCriterion("by_piece_count in", values, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountNotIn(List<Integer> values) {
            addCriterion("by_piece_count not in", values, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountBetween(Integer value1, Integer value2) {
            addCriterion("by_piece_count between", value1, value2, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceCountNotBetween(Integer value1, Integer value2) {
            addCriterion("by_piece_count not between", value1, value2, "byPieceCount");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyIsNull() {
            addCriterion("by_piece_money is null");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyIsNotNull() {
            addCriterion("by_piece_money is not null");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyEqualTo(BigDecimal value) {
            addCriterion("by_piece_money =", value, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("by_piece_money <>", value, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyGreaterThan(BigDecimal value) {
            addCriterion("by_piece_money >", value, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("by_piece_money >=", value, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyLessThan(BigDecimal value) {
            addCriterion("by_piece_money <", value, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("by_piece_money <=", value, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyIn(List<BigDecimal> values) {
            addCriterion("by_piece_money in", values, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("by_piece_money not in", values, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_piece_money between", value1, value2, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andByPieceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("by_piece_money not between", value1, value2, "byPieceMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountIsNull() {
            addCriterion("temporary_dispatch_count is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountIsNotNull() {
            addCriterion("temporary_dispatch_count is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountEqualTo(Integer value) {
            addCriterion("temporary_dispatch_count =", value, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountNotEqualTo(Integer value) {
            addCriterion("temporary_dispatch_count <>", value, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountGreaterThan(Integer value) {
            addCriterion("temporary_dispatch_count >", value, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("temporary_dispatch_count >=", value, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountLessThan(Integer value) {
            addCriterion("temporary_dispatch_count <", value, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountLessThanOrEqualTo(Integer value) {
            addCriterion("temporary_dispatch_count <=", value, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountIn(List<Integer> values) {
            addCriterion("temporary_dispatch_count in", values, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountNotIn(List<Integer> values) {
            addCriterion("temporary_dispatch_count not in", values, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountBetween(Integer value1, Integer value2) {
            addCriterion("temporary_dispatch_count between", value1, value2, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchCountNotBetween(Integer value1, Integer value2) {
            addCriterion("temporary_dispatch_count not between", value1, value2, "temporaryDispatchCount");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyIsNull() {
            addCriterion("temporary_dispatch_money is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyIsNotNull() {
            addCriterion("temporary_dispatch_money is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyEqualTo(BigDecimal value) {
            addCriterion("temporary_dispatch_money =", value, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyNotEqualTo(BigDecimal value) {
            addCriterion("temporary_dispatch_money <>", value, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyGreaterThan(BigDecimal value) {
            addCriterion("temporary_dispatch_money >", value, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("temporary_dispatch_money >=", value, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyLessThan(BigDecimal value) {
            addCriterion("temporary_dispatch_money <", value, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("temporary_dispatch_money <=", value, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyIn(List<BigDecimal> values) {
            addCriterion("temporary_dispatch_money in", values, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyNotIn(List<BigDecimal> values) {
            addCriterion("temporary_dispatch_money not in", values, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("temporary_dispatch_money between", value1, value2, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryDispatchMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("temporary_dispatch_money not between", value1, value2, "temporaryDispatchMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobCountIsNull() {
            addCriterion("odd_job_count is null");
            return (Criteria) this;
        }

        public Criteria andOddJobCountIsNotNull() {
            addCriterion("odd_job_count is not null");
            return (Criteria) this;
        }

        public Criteria andOddJobCountEqualTo(Integer value) {
            addCriterion("odd_job_count =", value, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountNotEqualTo(Integer value) {
            addCriterion("odd_job_count <>", value, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountGreaterThan(Integer value) {
            addCriterion("odd_job_count >", value, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("odd_job_count >=", value, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountLessThan(Integer value) {
            addCriterion("odd_job_count <", value, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountLessThanOrEqualTo(Integer value) {
            addCriterion("odd_job_count <=", value, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountIn(List<Integer> values) {
            addCriterion("odd_job_count in", values, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountNotIn(List<Integer> values) {
            addCriterion("odd_job_count not in", values, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountBetween(Integer value1, Integer value2) {
            addCriterion("odd_job_count between", value1, value2, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobCountNotBetween(Integer value1, Integer value2) {
            addCriterion("odd_job_count not between", value1, value2, "oddJobCount");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyIsNull() {
            addCriterion("odd_job_money is null");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyIsNotNull() {
            addCriterion("odd_job_money is not null");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyEqualTo(BigDecimal value) {
            addCriterion("odd_job_money =", value, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyNotEqualTo(BigDecimal value) {
            addCriterion("odd_job_money <>", value, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyGreaterThan(BigDecimal value) {
            addCriterion("odd_job_money >", value, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("odd_job_money >=", value, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyLessThan(BigDecimal value) {
            addCriterion("odd_job_money <", value, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("odd_job_money <=", value, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyIn(List<BigDecimal> values) {
            addCriterion("odd_job_money in", values, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyNotIn(List<BigDecimal> values) {
            addCriterion("odd_job_money not in", values, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("odd_job_money between", value1, value2, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andOddJobMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("odd_job_money not between", value1, value2, "oddJobMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountIsNull() {
            addCriterion("industrial_waste_count is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountIsNotNull() {
            addCriterion("industrial_waste_count is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountEqualTo(Integer value) {
            addCriterion("industrial_waste_count =", value, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountNotEqualTo(Integer value) {
            addCriterion("industrial_waste_count <>", value, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountGreaterThan(Integer value) {
            addCriterion("industrial_waste_count >", value, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("industrial_waste_count >=", value, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountLessThan(Integer value) {
            addCriterion("industrial_waste_count <", value, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountLessThanOrEqualTo(Integer value) {
            addCriterion("industrial_waste_count <=", value, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountIn(List<Integer> values) {
            addCriterion("industrial_waste_count in", values, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountNotIn(List<Integer> values) {
            addCriterion("industrial_waste_count not in", values, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountBetween(Integer value1, Integer value2) {
            addCriterion("industrial_waste_count between", value1, value2, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("industrial_waste_count not between", value1, value2, "industrialWasteCount");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyIsNull() {
            addCriterion("industrial_waste_money is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyIsNotNull() {
            addCriterion("industrial_waste_money is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyEqualTo(BigDecimal value) {
            addCriterion("industrial_waste_money =", value, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyNotEqualTo(BigDecimal value) {
            addCriterion("industrial_waste_money <>", value, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyGreaterThan(BigDecimal value) {
            addCriterion("industrial_waste_money >", value, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("industrial_waste_money >=", value, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyLessThan(BigDecimal value) {
            addCriterion("industrial_waste_money <", value, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("industrial_waste_money <=", value, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyIn(List<BigDecimal> values) {
            addCriterion("industrial_waste_money in", values, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyNotIn(List<BigDecimal> values) {
            addCriterion("industrial_waste_money not in", values, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("industrial_waste_money between", value1, value2, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("industrial_waste_money not between", value1, value2, "industrialWasteMoney");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundIsNull() {
            addCriterion("min_live_security_fund is null");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundIsNotNull() {
            addCriterion("min_live_security_fund is not null");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundEqualTo(BigDecimal value) {
            addCriterion("min_live_security_fund =", value, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundNotEqualTo(BigDecimal value) {
            addCriterion("min_live_security_fund <>", value, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundGreaterThan(BigDecimal value) {
            addCriterion("min_live_security_fund >", value, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_live_security_fund >=", value, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundLessThan(BigDecimal value) {
            addCriterion("min_live_security_fund <", value, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_live_security_fund <=", value, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundIn(List<BigDecimal> values) {
            addCriterion("min_live_security_fund in", values, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundNotIn(List<BigDecimal> values) {
            addCriterion("min_live_security_fund not in", values, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_live_security_fund between", value1, value2, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andMinLiveSecurityFundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_live_security_fund not between", value1, value2, "minLiveSecurityFund");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryIsNull() {
            addCriterion("accrued_performance_salary is null");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryIsNotNull() {
            addCriterion("accrued_performance_salary is not null");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryEqualTo(BigDecimal value) {
            addCriterion("accrued_performance_salary =", value, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryNotEqualTo(BigDecimal value) {
            addCriterion("accrued_performance_salary <>", value, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryGreaterThan(BigDecimal value) {
            addCriterion("accrued_performance_salary >", value, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accrued_performance_salary >=", value, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryLessThan(BigDecimal value) {
            addCriterion("accrued_performance_salary <", value, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accrued_performance_salary <=", value, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryIn(List<BigDecimal> values) {
            addCriterion("accrued_performance_salary in", values, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryNotIn(List<BigDecimal> values) {
            addCriterion("accrued_performance_salary not in", values, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accrued_performance_salary between", value1, value2, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andAccruedPerformanceSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accrued_performance_salary not between", value1, value2, "accruedPerformanceSalary");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyIsNull() {
            addCriterion("commendation_money is null");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyIsNotNull() {
            addCriterion("commendation_money is not null");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyEqualTo(BigDecimal value) {
            addCriterion("commendation_money =", value, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyNotEqualTo(BigDecimal value) {
            addCriterion("commendation_money <>", value, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyGreaterThan(BigDecimal value) {
            addCriterion("commendation_money >", value, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commendation_money >=", value, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyLessThan(BigDecimal value) {
            addCriterion("commendation_money <", value, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commendation_money <=", value, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyIn(List<BigDecimal> values) {
            addCriterion("commendation_money in", values, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyNotIn(List<BigDecimal> values) {
            addCriterion("commendation_money not in", values, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commendation_money between", value1, value2, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andCommendationMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commendation_money not between", value1, value2, "commendationMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyIsNull() {
            addCriterion("lunch_allowance_money is null");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyIsNotNull() {
            addCriterion("lunch_allowance_money is not null");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyEqualTo(BigDecimal value) {
            addCriterion("lunch_allowance_money =", value, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("lunch_allowance_money <>", value, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyGreaterThan(BigDecimal value) {
            addCriterion("lunch_allowance_money >", value, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lunch_allowance_money >=", value, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyLessThan(BigDecimal value) {
            addCriterion("lunch_allowance_money <", value, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lunch_allowance_money <=", value, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyIn(List<BigDecimal> values) {
            addCriterion("lunch_allowance_money in", values, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("lunch_allowance_money not in", values, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lunch_allowance_money between", value1, value2, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andLunchAllowanceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lunch_allowance_money not between", value1, value2, "lunchAllowanceMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyIsNull() {
            addCriterion("overtime_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyIsNotNull() {
            addCriterion("overtime_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyEqualTo(BigDecimal value) {
            addCriterion("overtime_pay_money =", value, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("overtime_pay_money <>", value, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyGreaterThan(BigDecimal value) {
            addCriterion("overtime_pay_money >", value, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_pay_money >=", value, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyLessThan(BigDecimal value) {
            addCriterion("overtime_pay_money <", value, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_pay_money <=", value, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyIn(List<BigDecimal> values) {
            addCriterion("overtime_pay_money in", values, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("overtime_pay_money not in", values, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_pay_money between", value1, value2, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimePayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_pay_money not between", value1, value2, "overtimePayMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyIsNull() {
            addCriterion("other_subsidies_money is null");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyIsNotNull() {
            addCriterion("other_subsidies_money is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyEqualTo(BigDecimal value) {
            addCriterion("other_subsidies_money =", value, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyNotEqualTo(BigDecimal value) {
            addCriterion("other_subsidies_money <>", value, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyGreaterThan(BigDecimal value) {
            addCriterion("other_subsidies_money >", value, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_subsidies_money >=", value, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyLessThan(BigDecimal value) {
            addCriterion("other_subsidies_money <", value, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_subsidies_money <=", value, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyIn(List<BigDecimal> values) {
            addCriterion("other_subsidies_money in", values, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyNotIn(List<BigDecimal> values) {
            addCriterion("other_subsidies_money not in", values, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_subsidies_money between", value1, value2, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidiesMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_subsidies_money not between", value1, value2, "otherSubsidiesMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyIsNull() {
            addCriterion("total_payable_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyIsNotNull() {
            addCriterion("total_payable_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyEqualTo(BigDecimal value) {
            addCriterion("total_payable_money =", value, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_payable_money <>", value, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_payable_money >", value, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_payable_money >=", value, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyLessThan(BigDecimal value) {
            addCriterion("total_payable_money <", value, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_payable_money <=", value, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyIn(List<BigDecimal> values) {
            addCriterion("total_payable_money in", values, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_payable_money not in", values, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_payable_money between", value1, value2, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayableMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_payable_money not between", value1, value2, "totalPayableMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyIsNull() {
            addCriterion("deduct_personal_insurance_money is null");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyIsNotNull() {
            addCriterion("deduct_personal_insurance_money is not null");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyEqualTo(BigDecimal value) {
            addCriterion("deduct_personal_insurance_money =", value, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("deduct_personal_insurance_money <>", value, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyGreaterThan(BigDecimal value) {
            addCriterion("deduct_personal_insurance_money >", value, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_personal_insurance_money >=", value, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyLessThan(BigDecimal value) {
            addCriterion("deduct_personal_insurance_money <", value, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_personal_insurance_money <=", value, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyIn(List<BigDecimal> values) {
            addCriterion("deduct_personal_insurance_money in", values, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("deduct_personal_insurance_money not in", values, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_personal_insurance_money between", value1, value2, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andDeductPersonalInsuranceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_personal_insurance_money not between", value1, value2, "deductPersonalInsuranceMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyIsNull() {
            addCriterion("total_tax_payable_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyIsNotNull() {
            addCriterion("total_tax_payable_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyEqualTo(BigDecimal value) {
            addCriterion("total_tax_payable_money =", value, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_tax_payable_money <>", value, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_tax_payable_money >", value, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_tax_payable_money >=", value, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyLessThan(BigDecimal value) {
            addCriterion("total_tax_payable_money <", value, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_tax_payable_money <=", value, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyIn(List<BigDecimal> values) {
            addCriterion("total_tax_payable_money in", values, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_tax_payable_money not in", values, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_tax_payable_money between", value1, value2, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxPayableMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_tax_payable_money not between", value1, value2, "totalTaxPayableMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyIsNull() {
            addCriterion("taxable_wages_money is null");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyIsNotNull() {
            addCriterion("taxable_wages_money is not null");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyEqualTo(BigDecimal value) {
            addCriterion("taxable_wages_money =", value, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyNotEqualTo(BigDecimal value) {
            addCriterion("taxable_wages_money <>", value, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyGreaterThan(BigDecimal value) {
            addCriterion("taxable_wages_money >", value, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taxable_wages_money >=", value, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyLessThan(BigDecimal value) {
            addCriterion("taxable_wages_money <", value, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taxable_wages_money <=", value, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyIn(List<BigDecimal> values) {
            addCriterion("taxable_wages_money in", values, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyNotIn(List<BigDecimal> values) {
            addCriterion("taxable_wages_money not in", values, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxable_wages_money between", value1, value2, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxableWagesMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxable_wages_money not between", value1, value2, "taxableWagesMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxIsNull() {
            addCriterion("deduction_personal_income_tax is null");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxIsNotNull() {
            addCriterion("deduction_personal_income_tax is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxEqualTo(BigDecimal value) {
            addCriterion("deduction_personal_income_tax =", value, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxNotEqualTo(BigDecimal value) {
            addCriterion("deduction_personal_income_tax <>", value, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxGreaterThan(BigDecimal value) {
            addCriterion("deduction_personal_income_tax >", value, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_personal_income_tax >=", value, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxLessThan(BigDecimal value) {
            addCriterion("deduction_personal_income_tax <", value, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_personal_income_tax <=", value, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxIn(List<BigDecimal> values) {
            addCriterion("deduction_personal_income_tax in", values, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxNotIn(List<BigDecimal> values) {
            addCriterion("deduction_personal_income_tax not in", values, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_personal_income_tax between", value1, value2, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andDeductionPersonalIncomeTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_personal_income_tax not between", value1, value2, "deductionPersonalIncomeTax");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyIsNull() {
            addCriterion("net_salary_money is null");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyIsNotNull() {
            addCriterion("net_salary_money is not null");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyEqualTo(BigDecimal value) {
            addCriterion("net_salary_money =", value, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyNotEqualTo(BigDecimal value) {
            addCriterion("net_salary_money <>", value, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyGreaterThan(BigDecimal value) {
            addCriterion("net_salary_money >", value, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_salary_money >=", value, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyLessThan(BigDecimal value) {
            addCriterion("net_salary_money <", value, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_salary_money <=", value, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyIn(List<BigDecimal> values) {
            addCriterion("net_salary_money in", values, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyNotIn(List<BigDecimal> values) {
            addCriterion("net_salary_money not in", values, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_salary_money between", value1, value2, "netSalaryMoney");
            return (Criteria) this;
        }

        public Criteria andNetSalaryMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_salary_money not between", value1, value2, "netSalaryMoney");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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