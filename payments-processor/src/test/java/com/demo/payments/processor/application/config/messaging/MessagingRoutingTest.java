package com.demo.payments.processor.application.config.messaging;

import com.demo.payments.processor.application.config.properties.MessagingRouting;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessagingRoutingTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		MessagingRouting messagingRouting = new MessagingRouting()
			.setExchange("::exchange::")
			.setQueue("::queue::")
			.setRoutingKey("::routing-key::");

		assertThat(messagingRouting.getExchange()).isEqualTo("::exchange::");
		assertThat(messagingRouting.getRoutingKey()).isEqualTo("::routing-key::");
		assertThat(messagingRouting.getQueue()).isEqualTo("::queue::");
	}

}
