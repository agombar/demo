package com.demo.users.payments.sink.infrastructure.jpa.postgresql;

import com.demo.users.payments.sink.domain.exception.ResourceCreateException;
import com.demo.users.payments.sink.domain.model.Payment;
import com.demo.users.payments.sink.domain.repository.PaymentRepository;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.mapper.PaymentEntityMapper;
import com.demo.users.payments.sink.infrastructure.jpa.persistence.PostgresqlRepository;
import com.demo.users.payments.sink.infrastructure.jpa.persistence.QueryInsertException;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PostgresqlPaymentRepository implements PaymentRepository {

	private final PostgresqlRepository<PaymentEntity> postgresqlRepository;
	private final PaymentEntityMapper paymentEntityMapper;
	private final Clock clock;

	@Override
	public Payment create(Payment payment) throws ResourceCreateException {
		PaymentEntity paymentEntity = this.paymentEntityMapper.toPaymentEntity(payment)
			.setCreatedAt(LocalDateTime.now(this.clock));
		try {
			return this.paymentEntityMapper.toPayment(
				this.postgresqlRepository.insert(paymentEntity)
			);
		} catch(QueryInsertException e) {
			throw new ResourceCreateException(String.format("Cannot create payment %s", payment), e);
		}
	}

}
