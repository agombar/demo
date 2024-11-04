package com.demo.payments.processor.application.listener.payment;

import com.demo.payments.processor.application.listener.payment.create.PaymentCreateMessage;
import com.demo.payments.processor.application.listener.payment.mapper.PaymentMessageConsumeMapper;
import com.demo.payments.processor.domain.model.Payment;
import com.demo.payments.processor.domain.use_case.PaymentCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RequiredArgsConstructor
public class PaymentListener {

	private final PaymentCreateUseCase paymentCreateUseCase;
	private final PaymentMessageConsumeMapper paymentMessageConsumeMapper;

	@RabbitListener(queues = "${messaging.paymentExternalCreated.queue}")
	public void handleUserCreatedMessage(PaymentCreateMessage paymentMessage) {
		try {
			Payment payment = this.paymentMessageConsumeMapper.toPayment(paymentMessage.getContent());
			this.paymentCreateUseCase.execute(payment);
			log.info("Payment created consumed: {}", payment);
		} catch(Exception e) {
			log.error("Error processing payment created message: {}", paymentMessage, e);
		}
	}

}
