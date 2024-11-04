package com.demo.users.payments.sink.infrastructure.jpa.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import static jakarta.transaction.Transactional.TxType.REQUIRED;

@RequiredArgsConstructor
public class PostgresqlRepository<T> {

	private final EntityManager entityManager;

	@Transactional(REQUIRED)
	public T insert(T object) throws QueryInsertException {
		try {
			this.entityManager.persist(object);
			return object;
		} catch(Exception e) {
			throw new QueryInsertException(e);
		}
	}

	@Transactional(REQUIRED)
	public void update(QueryUpdateBuilder<T> queryBuilder, Class<T> expectedType) throws QueryExecuteException {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaUpdate<T> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(expectedType);

		queryBuilder.configure(criteriaBuilder, criteriaUpdate);

		Query query = this.entityManager.createQuery(criteriaUpdate);

		try {
			query.executeUpdate();
		} catch(Exception e) {
			throw new QueryExecuteException(e);
		}

	}

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

}
