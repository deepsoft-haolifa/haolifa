package com.deepsoft.haolifa.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderReviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderReviewExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andReviewFormIsNull() {
            addCriterion("review_form is null");
            return (Criteria) this;
        }

        public Criteria andReviewFormIsNotNull() {
            addCriterion("review_form is not null");
            return (Criteria) this;
        }

        public Criteria andReviewFormEqualTo(String value) {
            addCriterion("review_form =", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormNotEqualTo(String value) {
            addCriterion("review_form <>", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormGreaterThan(String value) {
            addCriterion("review_form >", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormGreaterThanOrEqualTo(String value) {
            addCriterion("review_form >=", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormLessThan(String value) {
            addCriterion("review_form <", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormLessThanOrEqualTo(String value) {
            addCriterion("review_form <=", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormLike(String value) {
            addCriterion("review_form like", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormNotLike(String value) {
            addCriterion("review_form not like", value, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormIn(List<String> values) {
            addCriterion("review_form in", values, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormNotIn(List<String> values) {
            addCriterion("review_form not in", values, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormBetween(String value1, String value2) {
            addCriterion("review_form between", value1, value2, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andReviewFormNotBetween(String value1, String value2) {
            addCriterion("review_form not between", value1, value2, "reviewForm");
            return (Criteria) this;
        }

        public Criteria andTechUserIsNull() {
            addCriterion("tech_user is null");
            return (Criteria) this;
        }

        public Criteria andTechUserIsNotNull() {
            addCriterion("tech_user is not null");
            return (Criteria) this;
        }

        public Criteria andTechUserEqualTo(Integer value) {
            addCriterion("tech_user =", value, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserNotEqualTo(Integer value) {
            addCriterion("tech_user <>", value, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserGreaterThan(Integer value) {
            addCriterion("tech_user >", value, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("tech_user >=", value, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserLessThan(Integer value) {
            addCriterion("tech_user <", value, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserLessThanOrEqualTo(Integer value) {
            addCriterion("tech_user <=", value, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserIn(List<Integer> values) {
            addCriterion("tech_user in", values, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserNotIn(List<Integer> values) {
            addCriterion("tech_user not in", values, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserBetween(Integer value1, Integer value2) {
            addCriterion("tech_user between", value1, value2, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechUserNotBetween(Integer value1, Integer value2) {
            addCriterion("tech_user not between", value1, value2, "techUser");
            return (Criteria) this;
        }

        public Criteria andTechRemarkIsNull() {
            addCriterion("tech_remark is null");
            return (Criteria) this;
        }

        public Criteria andTechRemarkIsNotNull() {
            addCriterion("tech_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTechRemarkEqualTo(String value) {
            addCriterion("tech_remark =", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkNotEqualTo(String value) {
            addCriterion("tech_remark <>", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkGreaterThan(String value) {
            addCriterion("tech_remark >", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tech_remark >=", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkLessThan(String value) {
            addCriterion("tech_remark <", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkLessThanOrEqualTo(String value) {
            addCriterion("tech_remark <=", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkLike(String value) {
            addCriterion("tech_remark like", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkNotLike(String value) {
            addCriterion("tech_remark not like", value, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkIn(List<String> values) {
            addCriterion("tech_remark in", values, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkNotIn(List<String> values) {
            addCriterion("tech_remark not in", values, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkBetween(String value1, String value2) {
            addCriterion("tech_remark between", value1, value2, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechRemarkNotBetween(String value1, String value2) {
            addCriterion("tech_remark not between", value1, value2, "techRemark");
            return (Criteria) this;
        }

        public Criteria andTechTimeIsNull() {
            addCriterion("tech_time is null");
            return (Criteria) this;
        }

        public Criteria andTechTimeIsNotNull() {
            addCriterion("tech_time is not null");
            return (Criteria) this;
        }

        public Criteria andTechTimeEqualTo(Date value) {
            addCriterion("tech_time =", value, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeNotEqualTo(Date value) {
            addCriterion("tech_time <>", value, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeGreaterThan(Date value) {
            addCriterion("tech_time >", value, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tech_time >=", value, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeLessThan(Date value) {
            addCriterion("tech_time <", value, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeLessThanOrEqualTo(Date value) {
            addCriterion("tech_time <=", value, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeIn(List<Date> values) {
            addCriterion("tech_time in", values, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeNotIn(List<Date> values) {
            addCriterion("tech_time not in", values, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeBetween(Date value1, Date value2) {
            addCriterion("tech_time between", value1, value2, "techTime");
            return (Criteria) this;
        }

        public Criteria andTechTimeNotBetween(Date value1, Date value2) {
            addCriterion("tech_time not between", value1, value2, "techTime");
            return (Criteria) this;
        }

        public Criteria andStoreUserIsNull() {
            addCriterion("store_user is null");
            return (Criteria) this;
        }

        public Criteria andStoreUserIsNotNull() {
            addCriterion("store_user is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUserEqualTo(Integer value) {
            addCriterion("store_user =", value, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserNotEqualTo(Integer value) {
            addCriterion("store_user <>", value, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserGreaterThan(Integer value) {
            addCriterion("store_user >", value, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_user >=", value, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserLessThan(Integer value) {
            addCriterion("store_user <", value, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserLessThanOrEqualTo(Integer value) {
            addCriterion("store_user <=", value, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserIn(List<Integer> values) {
            addCriterion("store_user in", values, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserNotIn(List<Integer> values) {
            addCriterion("store_user not in", values, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserBetween(Integer value1, Integer value2) {
            addCriterion("store_user between", value1, value2, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreUserNotBetween(Integer value1, Integer value2) {
            addCriterion("store_user not between", value1, value2, "storeUser");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkIsNull() {
            addCriterion("store_remark is null");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkIsNotNull() {
            addCriterion("store_remark is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkEqualTo(String value) {
            addCriterion("store_remark =", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkNotEqualTo(String value) {
            addCriterion("store_remark <>", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkGreaterThan(String value) {
            addCriterion("store_remark >", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("store_remark >=", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkLessThan(String value) {
            addCriterion("store_remark <", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkLessThanOrEqualTo(String value) {
            addCriterion("store_remark <=", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkLike(String value) {
            addCriterion("store_remark like", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkNotLike(String value) {
            addCriterion("store_remark not like", value, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkIn(List<String> values) {
            addCriterion("store_remark in", values, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkNotIn(List<String> values) {
            addCriterion("store_remark not in", values, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkBetween(String value1, String value2) {
            addCriterion("store_remark between", value1, value2, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreRemarkNotBetween(String value1, String value2) {
            addCriterion("store_remark not between", value1, value2, "storeRemark");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeIsNull() {
            addCriterion("store_review_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeIsNotNull() {
            addCriterion("store_review_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeEqualTo(Date value) {
            addCriterion("store_review_time =", value, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeNotEqualTo(Date value) {
            addCriterion("store_review_time <>", value, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeGreaterThan(Date value) {
            addCriterion("store_review_time >", value, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_review_time >=", value, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeLessThan(Date value) {
            addCriterion("store_review_time <", value, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_review_time <=", value, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeIn(List<Date> values) {
            addCriterion("store_review_time in", values, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeNotIn(List<Date> values) {
            addCriterion("store_review_time not in", values, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeBetween(Date value1, Date value2) {
            addCriterion("store_review_time between", value1, value2, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andStoreReviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_review_time not between", value1, value2, "storeReviewTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserIsNull() {
            addCriterion("purchase_user is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserIsNotNull() {
            addCriterion("purchase_user is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserEqualTo(Integer value) {
            addCriterion("purchase_user =", value, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserNotEqualTo(Integer value) {
            addCriterion("purchase_user <>", value, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserGreaterThan(Integer value) {
            addCriterion("purchase_user >", value, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_user >=", value, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserLessThan(Integer value) {
            addCriterion("purchase_user <", value, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_user <=", value, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserIn(List<Integer> values) {
            addCriterion("purchase_user in", values, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserNotIn(List<Integer> values) {
            addCriterion("purchase_user not in", values, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserBetween(Integer value1, Integer value2) {
            addCriterion("purchase_user between", value1, value2, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseUserNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_user not between", value1, value2, "purchaseUser");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkIsNull() {
            addCriterion("purchase_remark is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkIsNotNull() {
            addCriterion("purchase_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkEqualTo(String value) {
            addCriterion("purchase_remark =", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkNotEqualTo(String value) {
            addCriterion("purchase_remark <>", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkGreaterThan(String value) {
            addCriterion("purchase_remark >", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_remark >=", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkLessThan(String value) {
            addCriterion("purchase_remark <", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkLessThanOrEqualTo(String value) {
            addCriterion("purchase_remark <=", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkLike(String value) {
            addCriterion("purchase_remark like", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkNotLike(String value) {
            addCriterion("purchase_remark not like", value, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkIn(List<String> values) {
            addCriterion("purchase_remark in", values, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkNotIn(List<String> values) {
            addCriterion("purchase_remark not in", values, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkBetween(String value1, String value2) {
            addCriterion("purchase_remark between", value1, value2, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseRemarkNotBetween(String value1, String value2) {
            addCriterion("purchase_remark not between", value1, value2, "purchaseRemark");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNull() {
            addCriterion("purchase_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNotNull() {
            addCriterion("purchase_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeEqualTo(Date value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Date value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Date value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Date value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Date> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Date> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andQualityUserIsNull() {
            addCriterion("quality_user is null");
            return (Criteria) this;
        }

        public Criteria andQualityUserIsNotNull() {
            addCriterion("quality_user is not null");
            return (Criteria) this;
        }

        public Criteria andQualityUserEqualTo(Integer value) {
            addCriterion("quality_user =", value, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserNotEqualTo(Integer value) {
            addCriterion("quality_user <>", value, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserGreaterThan(Integer value) {
            addCriterion("quality_user >", value, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_user >=", value, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserLessThan(Integer value) {
            addCriterion("quality_user <", value, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserLessThanOrEqualTo(Integer value) {
            addCriterion("quality_user <=", value, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserIn(List<Integer> values) {
            addCriterion("quality_user in", values, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserNotIn(List<Integer> values) {
            addCriterion("quality_user not in", values, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserBetween(Integer value1, Integer value2) {
            addCriterion("quality_user between", value1, value2, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityUserNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_user not between", value1, value2, "qualityUser");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkIsNull() {
            addCriterion("quality_remark is null");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkIsNotNull() {
            addCriterion("quality_remark is not null");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkEqualTo(String value) {
            addCriterion("quality_remark =", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkNotEqualTo(String value) {
            addCriterion("quality_remark <>", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkGreaterThan(String value) {
            addCriterion("quality_remark >", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("quality_remark >=", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkLessThan(String value) {
            addCriterion("quality_remark <", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkLessThanOrEqualTo(String value) {
            addCriterion("quality_remark <=", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkLike(String value) {
            addCriterion("quality_remark like", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkNotLike(String value) {
            addCriterion("quality_remark not like", value, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkIn(List<String> values) {
            addCriterion("quality_remark in", values, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkNotIn(List<String> values) {
            addCriterion("quality_remark not in", values, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkBetween(String value1, String value2) {
            addCriterion("quality_remark between", value1, value2, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityRemarkNotBetween(String value1, String value2) {
            addCriterion("quality_remark not between", value1, value2, "qualityRemark");
            return (Criteria) this;
        }

        public Criteria andQualityTimeIsNull() {
            addCriterion("quality_time is null");
            return (Criteria) this;
        }

        public Criteria andQualityTimeIsNotNull() {
            addCriterion("quality_time is not null");
            return (Criteria) this;
        }

        public Criteria andQualityTimeEqualTo(Date value) {
            addCriterion("quality_time =", value, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeNotEqualTo(Date value) {
            addCriterion("quality_time <>", value, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeGreaterThan(Date value) {
            addCriterion("quality_time >", value, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("quality_time >=", value, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeLessThan(Date value) {
            addCriterion("quality_time <", value, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeLessThanOrEqualTo(Date value) {
            addCriterion("quality_time <=", value, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeIn(List<Date> values) {
            addCriterion("quality_time in", values, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeNotIn(List<Date> values) {
            addCriterion("quality_time not in", values, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeBetween(Date value1, Date value2) {
            addCriterion("quality_time between", value1, value2, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andQualityTimeNotBetween(Date value1, Date value2) {
            addCriterion("quality_time not between", value1, value2, "qualityTime");
            return (Criteria) this;
        }

        public Criteria andProduceUserIsNull() {
            addCriterion("produce_user is null");
            return (Criteria) this;
        }

        public Criteria andProduceUserIsNotNull() {
            addCriterion("produce_user is not null");
            return (Criteria) this;
        }

        public Criteria andProduceUserEqualTo(Integer value) {
            addCriterion("produce_user =", value, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserNotEqualTo(Integer value) {
            addCriterion("produce_user <>", value, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserGreaterThan(Integer value) {
            addCriterion("produce_user >", value, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("produce_user >=", value, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserLessThan(Integer value) {
            addCriterion("produce_user <", value, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserLessThanOrEqualTo(Integer value) {
            addCriterion("produce_user <=", value, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserIn(List<Integer> values) {
            addCriterion("produce_user in", values, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserNotIn(List<Integer> values) {
            addCriterion("produce_user not in", values, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserBetween(Integer value1, Integer value2) {
            addCriterion("produce_user between", value1, value2, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceUserNotBetween(Integer value1, Integer value2) {
            addCriterion("produce_user not between", value1, value2, "produceUser");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkIsNull() {
            addCriterion("produce_remark is null");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkIsNotNull() {
            addCriterion("produce_remark is not null");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkEqualTo(String value) {
            addCriterion("produce_remark =", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkNotEqualTo(String value) {
            addCriterion("produce_remark <>", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkGreaterThan(String value) {
            addCriterion("produce_remark >", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("produce_remark >=", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkLessThan(String value) {
            addCriterion("produce_remark <", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkLessThanOrEqualTo(String value) {
            addCriterion("produce_remark <=", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkLike(String value) {
            addCriterion("produce_remark like", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkNotLike(String value) {
            addCriterion("produce_remark not like", value, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkIn(List<String> values) {
            addCriterion("produce_remark in", values, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkNotIn(List<String> values) {
            addCriterion("produce_remark not in", values, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkBetween(String value1, String value2) {
            addCriterion("produce_remark between", value1, value2, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceRemarkNotBetween(String value1, String value2) {
            addCriterion("produce_remark not between", value1, value2, "produceRemark");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNull() {
            addCriterion("produce_time is null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNotNull() {
            addCriterion("produce_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeEqualTo(Date value) {
            addCriterion("produce_time =", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotEqualTo(Date value) {
            addCriterion("produce_time <>", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThan(Date value) {
            addCriterion("produce_time >", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("produce_time >=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThan(Date value) {
            addCriterion("produce_time <", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThanOrEqualTo(Date value) {
            addCriterion("produce_time <=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIn(List<Date> values) {
            addCriterion("produce_time in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotIn(List<Date> values) {
            addCriterion("produce_time not in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeBetween(Date value1, Date value2) {
            addCriterion("produce_time between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotBetween(Date value1, Date value2) {
            addCriterion("produce_time not between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(Integer value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(Integer value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(Integer value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(Integer value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(Integer value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<Integer> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<Integer> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(Integer value1, Integer value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(Integer value1, Integer value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkIsNull() {
            addCriterion("manager_remark is null");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkIsNotNull() {
            addCriterion("manager_remark is not null");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkEqualTo(String value) {
            addCriterion("manager_remark =", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkNotEqualTo(String value) {
            addCriterion("manager_remark <>", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkGreaterThan(String value) {
            addCriterion("manager_remark >", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("manager_remark >=", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkLessThan(String value) {
            addCriterion("manager_remark <", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkLessThanOrEqualTo(String value) {
            addCriterion("manager_remark <=", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkLike(String value) {
            addCriterion("manager_remark like", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkNotLike(String value) {
            addCriterion("manager_remark not like", value, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkIn(List<String> values) {
            addCriterion("manager_remark in", values, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkNotIn(List<String> values) {
            addCriterion("manager_remark not in", values, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkBetween(String value1, String value2) {
            addCriterion("manager_remark between", value1, value2, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerRemarkNotBetween(String value1, String value2) {
            addCriterion("manager_remark not between", value1, value2, "managerRemark");
            return (Criteria) this;
        }

        public Criteria andManagerTimeIsNull() {
            addCriterion("manager_time is null");
            return (Criteria) this;
        }

        public Criteria andManagerTimeIsNotNull() {
            addCriterion("manager_time is not null");
            return (Criteria) this;
        }

        public Criteria andManagerTimeEqualTo(Date value) {
            addCriterion("manager_time =", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeNotEqualTo(Date value) {
            addCriterion("manager_time <>", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeGreaterThan(Date value) {
            addCriterion("manager_time >", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("manager_time >=", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeLessThan(Date value) {
            addCriterion("manager_time <", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeLessThanOrEqualTo(Date value) {
            addCriterion("manager_time <=", value, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeIn(List<Date> values) {
            addCriterion("manager_time in", values, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeNotIn(List<Date> values) {
            addCriterion("manager_time not in", values, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeBetween(Date value1, Date value2) {
            addCriterion("manager_time between", value1, value2, "managerTime");
            return (Criteria) this;
        }

        public Criteria andManagerTimeNotBetween(Date value1, Date value2) {
            addCriterion("manager_time not between", value1, value2, "managerTime");
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