package com.demo.payments.processor.intrastructure.rabbit.payment.create;

import com.demo.payments.processor.builder.Builder;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.PaymentCreateMessage;
import com.demo.payments.processor.intrastructure.rabbit.header.MessageHeaderBuilder;

public class PaymentCreateMessageBuilder extends Builder<PaymentCreateMessage> {

	@Override
	public PaymentCreateMessage build(int index) {
		return new PaymentCreateMessage(
			new MessageHeaderBuilder().build(index),
			new PaymentContentCreateMessageBuilder().build(index)
		);
	}

}
