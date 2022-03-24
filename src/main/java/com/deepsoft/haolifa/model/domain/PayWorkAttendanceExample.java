package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayWorkAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayWorkAttendanceExample() {
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

        public Criteria andSerialEqualTo(Integer value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(Integer value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(Integer value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(Integer value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(Integer value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<Integer> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<Integer> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(Integer value1, Integer value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(Integer value1, Integer value2) {
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

        public Criteria andAttendanceDaysIsNull() {
            addCriterion("attendance_days is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysIsNotNull() {
            addCriterion("attendance_days is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysEqualTo(Integer value) {
            addCriterion("attendance_days =", value, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysNotEqualTo(Integer value) {
            addCriterion("attendance_days <>", value, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysGreaterThan(Integer value) {
            addCriterion("attendance_days >", value, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance_days >=", value, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysLessThan(Integer value) {
            addCriterion("attendance_days <", value, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysLessThanOrEqualTo(Integer value) {
            addCriterion("attendance_days <=", value, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysIn(List<Integer> values) {
            addCriterion("attendance_days in", values, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysNotIn(List<Integer> values) {
            addCriterion("attendance_days not in", values, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysBetween(Integer value1, Integer value2) {
            addCriterion("attendance_days between", value1, value2, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andAttendanceDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance_days not between", value1, value2, "attendanceDays");
            return (Criteria) this;
        }

        public Criteria andLateTimesIsNull() {
            addCriterion("late_times is null");
            return (Criteria) this;
        }

        public Criteria andLateTimesIsNotNull() {
            addCriterion("late_times is not null");
            return (Criteria) this;
        }

        public Criteria andLateTimesEqualTo(Integer value) {
            addCriterion("late_times =", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesNotEqualTo(Integer value) {
            addCriterion("late_times <>", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesGreaterThan(Integer value) {
            addCriterion("late_times >", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("late_times >=", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesLessThan(Integer value) {
            addCriterion("late_times <", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesLessThanOrEqualTo(Integer value) {
            addCriterion("late_times <=", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesIn(List<Integer> values) {
            addCriterion("late_times in", values, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesNotIn(List<Integer> values) {
            addCriterion("late_times not in", values, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesBetween(Integer value1, Integer value2) {
            addCriterion("late_times between", value1, value2, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("late_times not between", value1, value2, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesIsNull() {
            addCriterion("leave_early_times is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesIsNotNull() {
            addCriterion("leave_early_times is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesEqualTo(Integer value) {
            addCriterion("leave_early_times =", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesNotEqualTo(Integer value) {
            addCriterion("leave_early_times <>", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesGreaterThan(Integer value) {
            addCriterion("leave_early_times >", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_early_times >=", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesLessThan(Integer value) {
            addCriterion("leave_early_times <", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesLessThanOrEqualTo(Integer value) {
            addCriterion("leave_early_times <=", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesIn(List<Integer> values) {
            addCriterion("leave_early_times in", values, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesNotIn(List<Integer> values) {
            addCriterion("leave_early_times not in", values, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesBetween(Integer value1, Integer value2) {
            addCriterion("leave_early_times between", value1, value2, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_early_times not between", value1, value2, "leaveEarlyTimes");
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

        public Criteria andMiddleDaysIsNull() {
            addCriterion("middle_days is null");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysIsNotNull() {
            addCriterion("middle_days is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysEqualTo(Integer value) {
            addCriterion("middle_days =", value, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysNotEqualTo(Integer value) {
            addCriterion("middle_days <>", value, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysGreaterThan(Integer value) {
            addCriterion("middle_days >", value, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("middle_days >=", value, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysLessThan(Integer value) {
            addCriterion("middle_days <", value, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysLessThanOrEqualTo(Integer value) {
            addCriterion("middle_days <=", value, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysIn(List<Integer> values) {
            addCriterion("middle_days in", values, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysNotIn(List<Integer> values) {
            addCriterion("middle_days not in", values, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysBetween(Integer value1, Integer value2) {
            addCriterion("middle_days between", value1, value2, "middleDays");
            return (Criteria) this;
        }

        public Criteria andMiddleDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("middle_days not between", value1, value2, "middleDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysIsNull() {
            addCriterion("night_days is null");
            return (Criteria) this;
        }

        public Criteria andNightDaysIsNotNull() {
            addCriterion("night_days is not null");
            return (Criteria) this;
        }

        public Criteria andNightDaysEqualTo(Integer value) {
            addCriterion("night_days =", value, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysNotEqualTo(Integer value) {
            addCriterion("night_days <>", value, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysGreaterThan(Integer value) {
            addCriterion("night_days >", value, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("night_days >=", value, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysLessThan(Integer value) {
            addCriterion("night_days <", value, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysLessThanOrEqualTo(Integer value) {
            addCriterion("night_days <=", value, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysIn(List<Integer> values) {
            addCriterion("night_days in", values, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysNotIn(List<Integer> values) {
            addCriterion("night_days not in", values, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysBetween(Integer value1, Integer value2) {
            addCriterion("night_days between", value1, value2, "nightDays");
            return (Criteria) this;
        }

        public Criteria andNightDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("night_days not between", value1, value2, "nightDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysIsNull() {
            addCriterion("business_travel_days is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysIsNotNull() {
            addCriterion("business_travel_days is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysEqualTo(Integer value) {
            addCriterion("business_travel_days =", value, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysNotEqualTo(Integer value) {
            addCriterion("business_travel_days <>", value, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysGreaterThan(Integer value) {
            addCriterion("business_travel_days >", value, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_travel_days >=", value, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysLessThan(Integer value) {
            addCriterion("business_travel_days <", value, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysLessThanOrEqualTo(Integer value) {
            addCriterion("business_travel_days <=", value, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysIn(List<Integer> values) {
            addCriterion("business_travel_days in", values, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysNotIn(List<Integer> values) {
            addCriterion("business_travel_days not in", values, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysBetween(Integer value1, Integer value2) {
            addCriterion("business_travel_days between", value1, value2, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andBusinessTravelDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("business_travel_days not between", value1, value2, "businessTravelDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysIsNull() {
            addCriterion("compassionate_leave_days is null");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysIsNotNull() {
            addCriterion("compassionate_leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysEqualTo(Integer value) {
            addCriterion("compassionate_leave_days =", value, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysNotEqualTo(Integer value) {
            addCriterion("compassionate_leave_days <>", value, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysGreaterThan(Integer value) {
            addCriterion("compassionate_leave_days >", value, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("compassionate_leave_days >=", value, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysLessThan(Integer value) {
            addCriterion("compassionate_leave_days <", value, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("compassionate_leave_days <=", value, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysIn(List<Integer> values) {
            addCriterion("compassionate_leave_days in", values, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysNotIn(List<Integer> values) {
            addCriterion("compassionate_leave_days not in", values, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysBetween(Integer value1, Integer value2) {
            addCriterion("compassionate_leave_days between", value1, value2, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("compassionate_leave_days not between", value1, value2, "compassionateLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysIsNull() {
            addCriterion("sick_leave_days is null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysIsNotNull() {
            addCriterion("sick_leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysEqualTo(Integer value) {
            addCriterion("sick_leave_days =", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysNotEqualTo(Integer value) {
            addCriterion("sick_leave_days <>", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysGreaterThan(Integer value) {
            addCriterion("sick_leave_days >", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("sick_leave_days >=", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysLessThan(Integer value) {
            addCriterion("sick_leave_days <", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("sick_leave_days <=", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysIn(List<Integer> values) {
            addCriterion("sick_leave_days in", values, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysNotIn(List<Integer> values) {
            addCriterion("sick_leave_days not in", values, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysBetween(Integer value1, Integer value2) {
            addCriterion("sick_leave_days between", value1, value2, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("sick_leave_days not between", value1, value2, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysIsNull() {
            addCriterion("work_overtime_days is null");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysIsNotNull() {
            addCriterion("work_overtime_days is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysEqualTo(Integer value) {
            addCriterion("work_overtime_days =", value, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysNotEqualTo(Integer value) {
            addCriterion("work_overtime_days <>", value, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysGreaterThan(Integer value) {
            addCriterion("work_overtime_days >", value, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_overtime_days >=", value, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysLessThan(Integer value) {
            addCriterion("work_overtime_days <", value, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysLessThanOrEqualTo(Integer value) {
            addCriterion("work_overtime_days <=", value, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysIn(List<Integer> values) {
            addCriterion("work_overtime_days in", values, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysNotIn(List<Integer> values) {
            addCriterion("work_overtime_days not in", values, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysBetween(Integer value1, Integer value2) {
            addCriterion("work_overtime_days between", value1, value2, "workOvertimeDays");
            return (Criteria) this;
        }

        public Criteria andWorkOvertimeDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("work_overtime_days not between", value1, value2, "workOvertimeDays");
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

        public Criteria andAttendYearIsNull() {
            addCriterion("attend_year is null");
            return (Criteria) this;
        }

        public Criteria andAttendYearIsNotNull() {
            addCriterion("attend_year is not null");
            return (Criteria) this;
        }

        public Criteria andAttendYearEqualTo(String value) {
            addCriterion("attend_year =", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearNotEqualTo(String value) {
            addCriterion("attend_year <>", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearGreaterThan(String value) {
            addCriterion("attend_year >", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearGreaterThanOrEqualTo(String value) {
            addCriterion("attend_year >=", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearLessThan(String value) {
            addCriterion("attend_year <", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearLessThanOrEqualTo(String value) {
            addCriterion("attend_year <=", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearLike(String value) {
            addCriterion("attend_year like", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearNotLike(String value) {
            addCriterion("attend_year not like", value, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearIn(List<String> values) {
            addCriterion("attend_year in", values, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearNotIn(List<String> values) {
            addCriterion("attend_year not in", values, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearBetween(String value1, String value2) {
            addCriterion("attend_year between", value1, value2, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendYearNotBetween(String value1, String value2) {
            addCriterion("attend_year not between", value1, value2, "attendYear");
            return (Criteria) this;
        }

        public Criteria andAttendMonthIsNull() {
            addCriterion("attend_month is null");
            return (Criteria) this;
        }

        public Criteria andAttendMonthIsNotNull() {
            addCriterion("attend_month is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMonthEqualTo(String value) {
            addCriterion("attend_month =", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthNotEqualTo(String value) {
            addCriterion("attend_month <>", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthGreaterThan(String value) {
            addCriterion("attend_month >", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthGreaterThanOrEqualTo(String value) {
            addCriterion("attend_month >=", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthLessThan(String value) {
            addCriterion("attend_month <", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthLessThanOrEqualTo(String value) {
            addCriterion("attend_month <=", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthLike(String value) {
            addCriterion("attend_month like", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthNotLike(String value) {
            addCriterion("attend_month not like", value, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthIn(List<String> values) {
            addCriterion("attend_month in", values, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthNotIn(List<String> values) {
            addCriterion("attend_month not in", values, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthBetween(String value1, String value2) {
            addCriterion("attend_month between", value1, value2, "attendMonth");
            return (Criteria) this;
        }

        public Criteria andAttendMonthNotBetween(String value1, String value2) {
            addCriterion("attend_month not between", value1, value2, "attendMonth");
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