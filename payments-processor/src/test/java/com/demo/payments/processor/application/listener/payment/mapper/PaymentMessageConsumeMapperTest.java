package com.demo.payments.processor.application.listener.payment.mapper;

import com.demo.payments.processor.application.listener.payment.create.PaymentContentCreateMessage;
import com.demo.payments.processor.builder.FakeClock;
import com.demo.payments.processor.builder.FakeUuid;
import com.demo.payments.processor.domain.model.Payment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentMessageConsumeMapperTest {

	private final PaymentMessageConsumeMapper mapper = PaymentMessageConsumeMapper.INSTANCE;

	@Test
	void when_message_is_given_then_payment_is_retrieve() {
		Payment payment = this.mapper.toPayment(
			new PaymentContentCreateMessage()
				.setId(FakeUuid.uuid(1))
				.setAmount(new BigDecimal(10000))
				.setUserId(FakeUuid.uuid(2))
				.setPaymentDate(FakeClock.dateTime(3))
		);

		assertThat(payment.getId()).isEqualTo(FakeUuid.uuid(1));
		assertThat(payment.getAmount()).isEqualTo(new BigDecimal(10000));
		assertThat(payment.getUserId()).isEqualTo(FakeUuid.uuid(2));
		assertThat(payment.getPaymentDate()).isEqualTo(FakeClock.dateTime(3));
	}

}
