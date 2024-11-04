package com.demo.payments.processor.application.bean;

import com.demo.payments.processor.application.config.properties.MessagingProperties;
import com.demo.payments.processor.application.config.properties.MessagingRouting;
import com.demo.payments.processor.infrastructure.rabbit.RabbitService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
	public Declarables paymentExternalCreatedQueueDeclarable(MessagingProperties messagingProperties) {
		return this.createEventQueueDeclarable(messagingProperties.getPaymentExternalCreated());
	}

	@Bean
	public TopicExchange paymentCreatedTopicExchange(MessagingProperties messagingProperties) {
		log.debug(
			"Create {} topic exchange with {} routing-key",
			messagingProperties.getPaymentCreated().getExchange(),
			messagingProperties.getPaymentCreated().getRoutingKey()
		);

		return new TopicExchange(messagingProperties.getPaymentCreated().getExchange());
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter(ObjectMapper objectMapper) {
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new Jackson2JsonMessageConverter(objectMapper);
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

	@Bean
	public RabbitService rabbitService(RabbitTemplate rabbitTemplate) {
		return new RabbitService(rabbitTemplate);
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
