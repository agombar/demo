package com.demo.payments.processor.infrastructure.rabbit.payment.create.creator;

import com.demo.payments.processor.domain.model.Payment;
import com.demo.payments.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.PaymentCreateMessage;
import com.demo.payments.processor.infrastructure.rabbit.payment.mapper.PaymentMessageProduceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentCreateMessageCreator {

	private final MessageHeaderCreator messageHeaderCreator;
	private final PaymentMessageProduceMapper paymentMessageProduceMapper;

	public PaymentCreateMessage create(Payment payment) {
		return new PaymentCreateMessage(
			this.messageHeaderCreator.create("payment-created"),
			this.paymentMessageProduceMapper.toPaymentCreatedMessage(payment)
		);
	}

}