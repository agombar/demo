package com.demo.users.payments.sink.intrastructure.jpa.entity.payment.mapper;

import com.demo.users.payments.sink.builder.FakeClock;
import com.demo.users.payments.sink.builder.FakeUuid;
import com.demo.users.payments.sink.domain.model.Payment;
import com.demo.users.payments.sink.domain.model.UserBuilder;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.mapper.PaymentEntityMapper;
import com.demo.users.payments.sink.intrastructure.jpa.entity.user.UserEntityBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentEntityMapperTest {

	private final PaymentEntityMapper mapper = PaymentEntityMapper.INSTANCE;

	@Test
	void when_entity_is_given_then_payment_is_retrieve() {
		Payment payment = this.mapper.toPayment(
			new PaymentEntity()
				.setId(FakeUuid.uuid(1))
				.setAmount(new BigDecimal(10000))
				.setUser(new UserEntityBuilder().build(5))
				.setPaymentDate(FakeClock.dateTime(3))
		);

		assertThat(payment.getId()).isEqualTo(FakeUuid.uuid(1));
		assertThat(payment.getAmount()).isEqualTo(new BigDecimal(10000));
		assertThat(payment.getUser()).isEqualTo(new UserBuilder().build(5));
		assertThat(payment.getPaymentDate()).isEqualTo(FakeClock.dateTime(3));
	}

}
