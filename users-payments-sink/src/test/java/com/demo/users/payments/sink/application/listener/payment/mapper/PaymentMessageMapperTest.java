package com.demo.users.payments.sink.application.listener.payment.mapper;

import com.demo.users.payments.sink.application.listener.payment.dto.create.PaymentContentCreateMessage;
import com.demo.users.payments.sink.builder.FakeClock;
import com.demo.users.payments.sink.builder.FakeUuid;
import com.demo.users.payments.sink.domain.model.Payment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentMessageMapperTest {

	private final PaymentMessageMapper mapper = PaymentMessageMapper.INSTANCE;

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
		assertThat(payment.getUser().getId()).isEqualTo(FakeUuid.uuid(2));
		assertThat(payment.getPaymentDate()).isEqualTo(FakeClock.dateTime(3));
	}

}
