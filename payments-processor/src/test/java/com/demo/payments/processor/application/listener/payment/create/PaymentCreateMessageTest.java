package com.demo.payments.processor.application.listener.payment.create;

import com.demo.payments.processor.application.listener.header.MessageHeaderBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentCreateMessageTest {

	@Test
	void when_payment_is_created_then_it_is_retrieve() {
		PaymentCreateMessage payment = new PaymentCreateMessage(
			new MessageHeaderBuilder().build(3),
			new PaymentContentCreateMessageBuilder().build(4)
		);

		assertThat(payment.getHeader()).isEqualTo(new MessageHeaderBuilder().build(3));
		assertThat(payment.getContent()).isEqualTo(new PaymentContentCreateMessageBuilder().build(4));
	}

}
