package com.demo.users.processor.application.config.messaging;

import com.demo.users.processor.application.config.properties.MessagingProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MessagingPropertiesTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		MessagingProperties messagingProperties = new MessagingProperties()
			.setUserExternalCreated(new MessagingRoutingBuilder().build(1))
			.setUserCreated(new MessagingRoutingBuilder().build(2))
			.setUserExternalUpdated(new MessagingRoutingBuilder().build(3))
			.setUserUpdated(new MessagingRoutingBuilder().build(4));

		assertThat(messagingProperties.getUserExternalCreated()).isEqualTo(new MessagingRoutingBuilder().build(1));
		assertThat(messagingProperties.getUserCreated()).isEqualTo(new MessagingRoutingBuilder().build(2));
		assertThat(messagingProperties.getUserExternalUpdated()).isEqualTo(new MessagingRoutingBuilder().build(3));
		assertThat(messagingProperties.getUserUpdated()).isEqualTo(new MessagingRoutingBuilder().build(4));
	}

}
