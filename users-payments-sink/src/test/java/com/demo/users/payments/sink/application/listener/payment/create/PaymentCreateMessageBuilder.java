package com.demo.users.payments.sink.application.listener.payment.create;

import com.demo.users.payments.sink.application.listener.header.MessageHeaderBuilder;
import com.demo.users.payments.sink.application.listener.payment.dto.create.PaymentCreateMessage;
import com.demo.users.payments.sink.builder.Builder;

public class PaymentCreateMessageBuilder extends Builder<PaymentCreateMessage> {

	@Override
	public PaymentCreateMessage build(int index) {
		return new PaymentCreateMessage(
			new MessageHeaderBuilder().build(index),
			new PaymentContentCreateMessageBuilder().build(index)
		);
	}

}
