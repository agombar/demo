package com.demo.payments.processor.application.listener.payment.create;

import com.demo.payments.processor.application.listener.header.MessageHeaderBuilder;
import com.demo.payments.processor.builder.Builder;

public class PaymentCreateMessageBuilder extends Builder<PaymentCreateMessage> {

	@Override
	public PaymentCreateMessage build(int index) {
		return new PaymentCreateMessage(
			new MessageHeaderBuilder().build(index),
			new PaymentContentCreateMessageBuilder().build(index)
		);
	}

}
