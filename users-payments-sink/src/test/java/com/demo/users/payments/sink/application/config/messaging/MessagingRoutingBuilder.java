package com.demo.users.payments.sink.application.config.messaging;

import com.demo.users.payments.sink.application.config.properties.MessagingRouting;
import com.demo.users.payments.sink.builder.Builder;

public class MessagingRoutingBuilder extends Builder<MessagingRouting> {

	@Override
	public MessagingRouting build(int seed) {
		return new MessagingRouting()
			.setExchange("::exchange-" + seed + "::")
			.setRoutingKey("::routing-key-" + seed + "::")
			.setQueue("::queue-" + seed + "::");
	}

}
