package com.demo.users.payments.sink.application.config.properties;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MessagingRouting {

	private String exchange;
	private String routingKey;
	private String queue;

}
