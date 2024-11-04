package com.demo.users.payments.api.infrastructure.jpa.postgresql;

import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Payment;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.repository.PaymentRepository;
import com.demo.users.payments.api.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.api.infrastructure.jpa.entity.payment.mapper.PaymentEntityMapper;
import com.demo.users.payments.api.infrastructure.jpa.persistence.PostgresqlRepository;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PostgresqlPaymentRepository implements PaymentRepository {

	private final PostgresqlRepository<PaymentEntity> postgresqlRepository;
	private final PaymentEntityMapper paymentEntityMapper;

	@Override
	public Optional<Payment> findById(UUID id) {
		PaymentEntity paymentEntity = this.postgresqlRepository.fetchOne((builder, query) -> {
			Root<PaymentEntity> root = query.from(PaymentEntity.class);

			query
				.select(root)
				.where(builder.equal(root.get("id"), id));
		}, PaymentEntity.class);

		return Optional.ofNullable(paymentEntity).map(this.paymentEntityMapper::toPayment);
	}

	@Override
	public Search<Payment> findByUserId(UUID userId, Paging paging) {
		Page<Payment> page = this.postgresqlRepository.fetch(
			(builder, query) -> {
				Root<PaymentEntity> root = query.from(PaymentEntity.class);
				query.select(root);
			},
			PaymentEntity.class,
			paging.getPage(),
			paging.getSize()
		).map(this.paymentEntityMapper::toPayment);

		return new Search<>(
			page.getContent(),
			page.getNumber(),
			page.getTotalElements(),
			page.getTotalPages()
		);
	}

}
