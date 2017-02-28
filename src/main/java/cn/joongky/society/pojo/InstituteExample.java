package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.List;

public class InstituteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstituteExample() {
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

        public Criteria andInstituteIdIsNull() {
            addCriterion("institute_id is null");
            return (Criteria) this;
        }

        public Criteria andInstituteIdIsNotNull() {
            addCriterion("institute_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstituteIdEqualTo(String value) {
            addCriterion("institute_id =", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdNotEqualTo(String value) {
            addCriterion("institute_id <>", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdGreaterThan(String value) {
            addCriterion("institute_id >", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdGreaterThanOrEqualTo(String value) {
            addCriterion("institute_id >=", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdLessThan(String value) {
            addCriterion("institute_id <", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdLessThanOrEqualTo(String value) {
            addCriterion("institute_id <=", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdLike(String value) {
            addCriterion("institute_id like", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdNotLike(String value) {
            addCriterion("institute_id not like", value, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdIn(List<String> values) {
            addCriterion("institute_id in", values, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdNotIn(List<String> values) {
            addCriterion("institute_id not in", values, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdBetween(String value1, String value2) {
            addCriterion("institute_id between", value1, value2, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteIdNotBetween(String value1, String value2) {
            addCriterion("institute_id not between", value1, value2, "instituteId");
            return (Criteria) this;
        }

        public Criteria andInstituteNameIsNull() {
            addCriterion("institute_name is null");
            return (Criteria) this;
        }

        public Criteria andInstituteNameIsNotNull() {
            addCriterion("institute_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstituteNameEqualTo(String value) {
            addCriterion("institute_name =", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotEqualTo(String value) {
            addCriterion("institute_name <>", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameGreaterThan(String value) {
            addCriterion("institute_name >", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameGreaterThanOrEqualTo(String value) {
            addCriterion("institute_name >=", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameLessThan(String value) {
            addCriterion("institute_name <", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameLessThanOrEqualTo(String value) {
            addCriterion("institute_name <=", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameLike(String value) {
            addCriterion("institute_name like", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotLike(String value) {
            addCriterion("institute_name not like", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameIn(List<String> values) {
            addCriterion("institute_name in", values, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotIn(List<String> values) {
            addCriterion("institute_name not in", values, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameBetween(String value1, String value2) {
            addCriterion("institute_name between", value1, value2, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotBetween(String value1, String value2) {
            addCriterion("institute_name not between", value1, value2, "instituteName");
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