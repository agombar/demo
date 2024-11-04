package com.demo.users.payments.sink.application.listener.payment.create;


import com.demo.users.payments.sink.application.listener.payment.dto.create.PaymentContentCreateMessage;
import com.demo.users.payments.sink.builder.FakeClock;
import com.demo.users.payments.sink.builder.FakeUuid;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentContentCreateMessageTest {

	@Test
	void when_payment_is_created_then_it_is_retrieve() {
		PaymentContentCreateMessage payment = new PaymentContentCreateMessage()
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
