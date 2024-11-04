package com.demo.users.payments.sink.application.config.messaging;

import com.demo.users.payments.sink.application.config.properties.MessagingProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MessagingPropertiesTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		MessagingProperties messagingProperties = new MessagingProperties()
			.setUserCreated(new MessagingRoutingBuilder().build(1))
			.setUserUpdated(new MessagingRoutingBuilder().build(2))
			.setPaymentCreated(new MessagingRoutingBuilder().build(3));

		assertThat(messagingProperties.getUserCreated()).isEqualTo(new MessagingRoutingBuilder().build(1));
		assertThat(messagingProperties.getUserUpdated()).isEqualTo(new MessagingRoutingBuilder().build(2));
		assertThat(messagingProperties.getPaymentCreated()).isEqualTo(new MessagingRoutingBuilder().build(3));
	}

}
