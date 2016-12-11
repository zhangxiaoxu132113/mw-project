package com.water.crawl.model;

import java.util.ArrayList;
import java.util.List;

public class WeiboCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeiboCriteria() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andPicIdsIsNull() {
            addCriterion("pic_ids is null");
            return (Criteria) this;
        }

        public Criteria andPicIdsIsNotNull() {
            addCriterion("pic_ids is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdsEqualTo(String value) {
            addCriterion("pic_ids =", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsNotEqualTo(String value) {
            addCriterion("pic_ids <>", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsGreaterThan(String value) {
            addCriterion("pic_ids >", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsGreaterThanOrEqualTo(String value) {
            addCriterion("pic_ids >=", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsLessThan(String value) {
            addCriterion("pic_ids <", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsLessThanOrEqualTo(String value) {
            addCriterion("pic_ids <=", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsLike(String value) {
            addCriterion("pic_ids like", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsNotLike(String value) {
            addCriterion("pic_ids not like", value, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsIn(List<String> values) {
            addCriterion("pic_ids in", values, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsNotIn(List<String> values) {
            addCriterion("pic_ids not in", values, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsBetween(String value1, String value2) {
            addCriterion("pic_ids between", value1, value2, "picIds");
            return (Criteria) this;
        }

        public Criteria andPicIdsNotBetween(String value1, String value2) {
            addCriterion("pic_ids not between", value1, value2, "picIds");
            return (Criteria) this;
        }

        public Criteria andGeoIsNull() {
            addCriterion("geo is null");
            return (Criteria) this;
        }

        public Criteria andGeoIsNotNull() {
            addCriterion("geo is not null");
            return (Criteria) this;
        }

        public Criteria andGeoEqualTo(String value) {
            addCriterion("geo =", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotEqualTo(String value) {
            addCriterion("geo <>", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoGreaterThan(String value) {
            addCriterion("geo >", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoGreaterThanOrEqualTo(String value) {
            addCriterion("geo >=", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoLessThan(String value) {
            addCriterion("geo <", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoLessThanOrEqualTo(String value) {
            addCriterion("geo <=", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoLike(String value) {
            addCriterion("geo like", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotLike(String value) {
            addCriterion("geo not like", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoIn(List<String> values) {
            addCriterion("geo in", values, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotIn(List<String> values) {
            addCriterion("geo not in", values, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoBetween(String value1, String value2) {
            addCriterion("geo between", value1, value2, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotBetween(String value1, String value2) {
            addCriterion("geo not between", value1, value2, "geo");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNull() {
            addCriterion("visible is null");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNotNull() {
            addCriterion("visible is not null");
            return (Criteria) this;
        }

        public Criteria andVisibleEqualTo(Integer value) {
            addCriterion("visible =", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotEqualTo(Integer value) {
            addCriterion("visible <>", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThan(Integer value) {
            addCriterion("visible >", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("visible >=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThan(Integer value) {
            addCriterion("visible <", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThanOrEqualTo(Integer value) {
            addCriterion("visible <=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleIn(List<Integer> values) {
            addCriterion("visible in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotIn(List<Integer> values) {
            addCriterion("visible not in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleBetween(Integer value1, Integer value2) {
            addCriterion("visible between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("visible not between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountIsNull() {
            addCriterion("attitudes_count is null");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountIsNotNull() {
            addCriterion("attitudes_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountEqualTo(Integer value) {
            addCriterion("attitudes_count =", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotEqualTo(Integer value) {
            addCriterion("attitudes_count <>", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountGreaterThan(Integer value) {
            addCriterion("attitudes_count >", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attitudes_count >=", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountLessThan(Integer value) {
            addCriterion("attitudes_count <", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountLessThanOrEqualTo(Integer value) {
            addCriterion("attitudes_count <=", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountIn(List<Integer> values) {
            addCriterion("attitudes_count in", values, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotIn(List<Integer> values) {
            addCriterion("attitudes_count not in", values, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountBetween(Integer value1, Integer value2) {
            addCriterion("attitudes_count between", value1, value2, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("attitudes_count not between", value1, value2, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIsNull() {
            addCriterion("comments_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIsNotNull() {
            addCriterion("comments_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsCountEqualTo(Integer value) {
            addCriterion("comments_count =", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotEqualTo(Integer value) {
            addCriterion("comments_count <>", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountGreaterThan(Integer value) {
            addCriterion("comments_count >", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comments_count >=", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLessThan(Integer value) {
            addCriterion("comments_count <", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLessThanOrEqualTo(Integer value) {
            addCriterion("comments_count <=", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIn(List<Integer> values) {
            addCriterion("comments_count in", values, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotIn(List<Integer> values) {
            addCriterion("comments_count not in", values, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountBetween(Integer value1, Integer value2) {
            addCriterion("comments_count between", value1, value2, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comments_count not between", value1, value2, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIsNull() {
            addCriterion("reposts_count is null");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIsNotNull() {
            addCriterion("reposts_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepostsCountEqualTo(Integer value) {
            addCriterion("reposts_count =", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotEqualTo(Integer value) {
            addCriterion("reposts_count <>", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountGreaterThan(Integer value) {
            addCriterion("reposts_count >", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reposts_count >=", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLessThan(Integer value) {
            addCriterion("reposts_count <", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLessThanOrEqualTo(Integer value) {
            addCriterion("reposts_count <=", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIn(List<Integer> values) {
            addCriterion("reposts_count in", values, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotIn(List<Integer> values) {
            addCriterion("reposts_count not in", values, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountBetween(Integer value1, Integer value2) {
            addCriterion("reposts_count between", value1, value2, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reposts_count not between", value1, value2, "repostsCount");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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