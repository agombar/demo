package com.demo.users.payments.sink.intrastructure.jpa.entity.payment;

import com.demo.users.payments.sink.builder.FakeClock;
import com.demo.users.payments.sink.builder.FakeUuid;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.sink.intrastructure.jpa.entity.user.UserEntityBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentEntityTest {

	@Test
	void when_payment_is_created_then_it_is_retrieve() {
		PaymentEntity payment = new PaymentEntity()
			.setId(FakeUuid.uuid(3))
			.setAmount(new BigDecimal(1000))
			.setUser(new UserEntityBuilder().build(6))
			.setPaymentDate(FakeClock.dateTime(5));

		assertThat(payment.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(payment.getAmount()).isEqualTo(new BigDecimal(1000));
		assertThat(payment.getUser()).isEqualTo(new UserEntityBuilder().build(6));
		assertThat(payment.getPaymentDate()).isEqualTo(FakeClock.dateTime(5));
	}

}
