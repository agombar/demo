package com.demo.users.payments.sink.application.listener.payment;

import com.demo.users.payments.sink.application.listener.payment.dto.create.PaymentCreateMessage;
import com.demo.users.payments.sink.application.listener.payment.mapper.PaymentMessageMapper;
import com.demo.users.payments.sink.domain.model.Payment;
import com.demo.users.payments.sink.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RequiredArgsConstructor
public class PaymentListener {

	private final PaymentRepository paymentRepository;
	private final PaymentMessageMapper paymentMessageMapper;

	@RabbitListener(queues = "${messaging.paymentCreated.queue}")
	public void handleUserCreatedMessage(PaymentCreateMessage paymentMessage) {
		try {
			Payment payment = this.paymentRepository.create(this.paymentMessageMapper.toPayment(paymentMessage.getContent()));
			log.info("Payment created: {}", payment);
		} catch(Exception e) {
			log.error("Error processing payment created message: {}", paymentMessage, e);
		}
	}

}
