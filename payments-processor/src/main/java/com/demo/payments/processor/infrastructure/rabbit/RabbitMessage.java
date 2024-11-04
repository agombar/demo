package com.demo.payments.processor.infrastructure.rabbit;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.amqp.core.MessageProperties;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
public class RabbitMessage {

	private final String body;
	private final Map<String, Object> headers;

	public RabbitMessage(String body) {
		this.body = body;
		this.headers = new HashMap<>();
	}

	public String getContentType() {
		return MessageProperties.CONTENT_TYPE_JSON;
	}

	public RabbitMessage addHeader(String name, Object value) {
		this.headers.put(name, value);
		return this;
	}

}

