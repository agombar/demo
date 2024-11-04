package com.demo.users.payments.sink.infrastructure.jpa.persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;

public interface QueryUpdateBuilder<T> {

	void configure(CriteriaBuilder criteriaBuilder, CriteriaUpdate<T> query);

}
