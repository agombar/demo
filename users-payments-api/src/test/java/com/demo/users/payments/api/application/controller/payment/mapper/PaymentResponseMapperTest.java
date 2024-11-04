package com.demo.users.payments.api.application.controller.payment.mapper;

import com.demo.users.payments.api.application.controller.payment.response.PaymentResponse;
import com.demo.users.payments.api.application.controller.user.response.UserResponseBuilder;
import com.demo.users.payments.api.builder.FakeClock;
import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.domain.model.Payment;
import com.demo.users.payments.api.domain.model.UserBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentResponseMapperTest {

	private final PaymentResponseMapper mapper = PaymentResponseMapper.INSTANCE;

	@Test
	void when_response_is_given_then_payment_is_retrieve() {
		PaymentResponse payment = this.mapper.toPaymentResponse(
			new Payment()
				.setId(FakeUuid.uuid(1))
				.setAmount(new BigDecimal(10000))
				.setUser(new UserBuilder().build(5))
				.setPaymentDate(FakeClock.dateTime(3))
		);

		assertThat(payment.getId()).isEqualTo(FakeUuid.uuid(1));
		assertThat(payment.getAmount()).isEqualTo(new BigDecimal(10000));
		assertThat(payment.getUser()).isEqualTo(new UserResponseBuilder().build(5));
		assertThat(payment.getPaymentDate()).isEqualTo(FakeClock.dateTime(3));
	}

}
