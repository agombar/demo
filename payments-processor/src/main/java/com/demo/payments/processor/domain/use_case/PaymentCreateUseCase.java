package com.demo.payments.processor.domain.use_case;

import com.demo.payments.processor.domain.exception.PublishMessageException;
import com.demo.payments.processor.domain.model.Payment;
import com.demo.payments.processor.domain.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class PaymentCreateUseCase {

	private final MessagingService messagingService;

	public void execute(Payment payment) {
		try {
			this.messagingService.publishPaymentCreated(payment);
		} catch(PublishMessageException e) {
			log.error("Cannot publish payment created {}", payment, e);
		}
	}

}
