package com.demo.users.processor.infrastructure.util;

import com.demo.users.processor.infrastructure.exception.HydrationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JacksonJsonHydrator implements JsonHydrator {

	private final ObjectMapper objectMapper;

	public <T> T hydrate(String json, Class<T> type) throws HydrationException {
		T message;
		try {
			message = this.objectMapper.readValue(json, type);
		} catch(Exception e) {
			throw new HydrationException(String.format("Cannot hydrate to %s", type.getName()), e);
		}

		return message;
	}

	public <T> String dehydrate(T message) throws HydrationException {
		try {
			return this.objectMapper.writeValueAsString(message);
		} catch(JsonProcessingException e) {
			throw new HydrationException("Cannot dehydrate", e);
		}
	}

}
