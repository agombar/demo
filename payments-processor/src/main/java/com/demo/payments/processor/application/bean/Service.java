package com.demo.payments.processor.application.bean;


import com.demo.payments.processor.application.config.properties.MessagingProperties;
import com.demo.payments.processor.domain.service.MessagingService;
import com.demo.payments.processor.infrastructure.rabbit.RabbitMessagingService;
import com.demo.payments.processor.infrastructure.rabbit.RabbitService;
import com.demo.payments.processor.infrastructure.rabbit.Routing;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.creator.PaymentCreateMessageCreator;
import com.demo.payments.processor.infrastructure.util.JsonHydrator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Service {

	@Bean
	public MessagingService rabbitMessagingService(
		RabbitService rabbitService,
		JsonHydrator jsonHydrator,
		MessagingProperties messagingProperties,
		PaymentCreateMessageCreator userCreateMessageCreator
	) {
		return new RabbitMessagingService(
			rabbitService,
			jsonHydrator,
			new Routing(
				messagingProperties.getPaymentCreated().getExchange(),
				messagingProperties.getPaymentCreated().getRoutingKey()
			),
			userCreateMessageCreator
		);
	}

}
