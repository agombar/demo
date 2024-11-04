package com.demo.users.payments.sink.application.bean;

import com.demo.users.payments.sink.application.config.properties.MessagingProperties;
import com.demo.users.payments.sink.application.config.properties.MessagingRouting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Messaging {

	@Bean
	public Declarables userCreatedQueueDeclarable(MessagingProperties messagingProperties) {
		return this.createEventQueueDeclarable(messagingProperties.getUserCreated());
	}

	@Bean
	public Declarables userUpdatedQueueDeclarable(MessagingProperties messagingProperties) {
		return this.createEventQueueDeclarable(messagingProperties.getUserUpdated());
	}

	@Bean
	public Declarables paymentCreatedQueueDeclarable(MessagingProperties messagingProperties) {
		return this.createEventQueueDeclarable(messagingProperties.getPaymentCreated());
	}

	@Bean
	public RabbitTemplate rabbitTemplate(
		final ConnectionFactory connectionFactory,
		final Jackson2JsonMessageConverter jackson2JsonMessageConverter
	) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
		return rabbitTemplate;
	}

	private Declarables createEventQueueDeclarable(MessagingRouting messagingRouting) {
		log.info(
			"Declaring exchange {} routing key {} queue {}",
			messagingRouting.getExchange(),
			messagingRouting.getRoutingKey(),
			messagingRouting.getQueue()
		);

		TopicExchange topicExchange = this.createTopicExchange(messagingRouting);
		Queue queue = this.createQueue(messagingRouting.getQueue());

		return new Declarables(
			queue,
			topicExchange,
			BindingBuilder
				.bind(queue)
				.to(topicExchange)
				.with(messagingRouting.getRoutingKey())
		);
	}

	private Queue createQueue(String queueName) {
		return new Queue(queueName, true, false, false);
	}

	private TopicExchange createTopicExchange(MessagingRouting messagingRouting) {
		return new TopicExchange(messagingRouting.getExchange());
	}

}
