package com.demo.payments.processor.intrastructure.rabbit.payment.mapper;

import com.demo.payments.processor.builder.FakeClock;
import com.demo.payments.processor.builder.FakeUuid;
import com.demo.payments.processor.domain.model.Payment;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.PaymentContentCreateMessage;
import com.demo.payments.processor.infrastructure.rabbit.payment.mapper.PaymentMessageProduceMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentMessageProduceMapperTest {

	private final PaymentMessageProduceMapper mapper = PaymentMessageProduceMapper.INSTANCE;

	@Test
	void when_message_is_given_then_payment_is_retrieve() {
		PaymentContentCreateMessage payment = this.mapper.toPaymentCreatedMessage(
			new Payment()
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
