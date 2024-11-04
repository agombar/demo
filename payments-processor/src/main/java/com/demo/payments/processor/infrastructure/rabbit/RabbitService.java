package com.demo.payments.processor.infrastructure.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
public class RabbitService {

	private final RabbitTemplate rabbitTemplate;

	public void publish(Routing routing, RabbitMessage message) {
		this.rabbitTemplate.convertAndSend(
			routing.getExchange(),
			routing.getRoutingKey(),
			MessageBuilder
				.withBody(message.getBody().getBytes())
				.setContentType(message.getContentType())
				.copyHeaders(message.getHeaders())
				.build()
		);
	}

}
