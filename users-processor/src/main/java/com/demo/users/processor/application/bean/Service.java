package com.demo.users.processor.application.bean;

import com.demo.users.processor.application.config.properties.MessagingProperties;
import com.demo.users.processor.domain.service.MessagingService;
import com.demo.users.processor.infrastructure.rabbit.RabbitMessagingService;
import com.demo.users.processor.infrastructure.rabbit.RabbitService;
import com.demo.users.processor.infrastructure.rabbit.Routing;
import com.demo.users.processor.infrastructure.rabbit.user.create.creator.UserCreateMessageCreator;
import com.demo.users.processor.infrastructure.rabbit.user.update.creator.UserUpdateMessageCreator;
import com.demo.users.processor.infrastructure.util.JsonHydrator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Service {

	@Bean
	public MessagingService rabbitMessagingService(
		RabbitService rabbitService,
		JsonHydrator jsonHydrator,
		MessagingProperties messagingProperties,
		UserCreateMessageCreator userCreateMessageCreator,
		UserUpdateMessageCreator userUpdateMessageCreator
	) {
		return new RabbitMessagingService(
			rabbitService,
			jsonHydrator,
			new Routing(
				messagingProperties.getUserCreated().getExchange(),
				messagingProperties.getUserCreated().getRoutingKey()
			),
			new Routing(
				messagingProperties.getUserUpdated().getExchange(),
				messagingProperties.getUserUpdated().getRoutingKey()
			),
			userCreateMessageCreator,
			userUpdateMessageCreator
		);
	}

}
