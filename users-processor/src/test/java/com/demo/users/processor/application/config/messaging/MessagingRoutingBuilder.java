package com.demo.users.processor.application.config.messaging;

import com.demo.users.processor.application.config.properties.MessagingRouting;
import com.demo.users.processor.builder.Builder;

public class MessagingRoutingBuilder extends Builder<MessagingRouting> {

	@Override
	public MessagingRouting build(int seed) {
		return new MessagingRouting()
			.setExchange("::exchange-" + seed + "::")
			.setRoutingKey("::routing-key-" + seed + "::")
			.setQueue("::queue-" + seed + "::");
	}

}
