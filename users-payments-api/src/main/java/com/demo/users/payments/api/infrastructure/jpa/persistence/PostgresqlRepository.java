package com.demo.users.payments.api.infrastructure.jpa.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class PostgresqlRepository<T> {

	private final EntityManager entityManager;

	public T fetchOne(QueryBuilder<T> queryBuilder, Class<T> expectedType) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(expectedType);

		queryBuilder.configure(criteriaBuilder, criteriaQuery);

		TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
		query.setMaxResults(1);

		try {
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	public <T> Page<T> fetch(QueryBuilder<T> queryBuilder, Class<T> expectedType, int page, int size) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(expectedType);

		queryBuilder.configure(criteriaBuilder, criteriaQuery);

		TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
		query.setFirstResult(page * size);
		query.setMaxResults(size);

		List<T> resultList;
		try {
			resultList = query.getResultList();
		} catch(NoResultException e) {
			resultList = List.of();
		}

		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<T> root = countQuery.from(expectedType);
		countQuery.select(criteriaBuilder.count(root));

		Long totalElements = this.entityManager.createQuery(countQuery).getSingleResult();

		Pageable pageable = PageRequest.of(page, size);
		return new PageImpl<>(resultList, pageable, totalElements);
	}

}
