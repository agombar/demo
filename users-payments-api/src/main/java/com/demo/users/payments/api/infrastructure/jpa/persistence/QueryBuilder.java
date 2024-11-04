package com.demo.users.payments.api.infrastructure.jpa.persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public interface QueryBuilder<T> {

	void configure(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> query);

}