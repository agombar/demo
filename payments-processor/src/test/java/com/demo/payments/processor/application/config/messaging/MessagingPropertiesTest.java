package com.demo.payments.processor.application.config.messaging;

import com.demo.payments.processor.application.config.properties.MessagingProperties;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessagingPropertiesTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		MessagingProperties messagingProperties = new MessagingProperties()
			.setPaymentExternalCreated(new MessagingRoutingBuilder().build(1))
			.setPaymentCreated(new MessagingRoutingBuilder().build(2));

		assertThat(messagingProperties.getPaymentExternalCreated()).isEqualTo(new MessagingRoutingBuilder().build(1));
		assertThat(messagingProperties.getPaymentCreated()).isEqualTo(new MessagingRoutingBuilder().build(2));
	}

}
