package com.demo.payments.processor.infrastructure.rabbit;

import com.demo.payments.processor.domain.exception.PublishMessageException;
import com.demo.payments.processor.domain.model.Payment;
import com.demo.payments.processor.domain.service.MessagingService;
import com.demo.payments.processor.infrastructure.exception.HydrationException;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.creator.PaymentCreateMessageCreator;
import com.demo.payments.processor.infrastructure.util.JsonHydrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RabbitMessagingService implements MessagingService {

	private final RabbitService rabbitService;

	private final JsonHydrator jsonHydrator;

	private final Routing paymentCreatedRouting;

	private final PaymentCreateMessageCreator paymentCreateMessageCreator;

	@Override
	public void publishPaymentCreated(Payment payment) throws PublishMessageException {
		log.info("Payment created published: {}", payment);

		this.rabbitService.publish(
			this.paymentCreatedRouting.resolve(),
			new RabbitMessage(
				this.dehydrate(this.paymentCreateMessageCreator.create(payment))
			)
		);

	}

	private String dehydrate(Object object) throws PublishMessageException {
		try {
			return this.jsonHydrator.dehydrate(object);
		} catch(HydrationException e) {
			throw new PublishMessageException("Bad message format", e);
		}
	}

}
