package com.demo.users.payments.sink.application.config.messaging;

import com.demo.users.payments.sink.application.config.properties.MessagingRouting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MessagingRoutingTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		MessagingRouting messagingRouting = new MessagingRouting()
			.setExchange("::exchange::")
			.setQueue("::queue::")
			.setRoutingKey("::routing-key::");

		assertThat("::exchange::").isEqualTo(messagingRouting.getExchange());
		assertThat("::routing-key::").isEqualTo(messagingRouting.getRoutingKey());
		assertThat("::queue::").isEqualTo(messagingRouting.getQueue());
	}

}
