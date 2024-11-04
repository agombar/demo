package com.demo.payments.processor.domain.model;

import com.demo.payments.processor.builder.FakeClock;
import com.demo.payments.processor.builder.FakeUuid;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentTest {

	@Test
	void when_payment_is_created_then_it_is_retrieve() {
		Payment payment = new Payment()
			.setId(FakeUuid.uuid(3))
			.setAmount(new BigDecimal(1000))
			.setUserId(FakeUuid.uuid(6))
			.setPaymentDate(FakeClock.dateTime(5));

		assertThat(payment.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(payment.getAmount()).isEqualTo(new BigDecimal(1000));
		assertThat(payment.getUserId()).isEqualTo(FakeUuid.uuid(6));
		assertThat(payment.getPaymentDate()).isEqualTo(FakeClock.dateTime(5));
	}

}
