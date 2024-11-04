package com.demo.users.processor.application.bean;

import com.demo.users.processor.infrastructure.util.JacksonJsonHydrator;
import com.demo.users.processor.infrastructure.util.JsonHydrator;
import com.demo.users.processor.infrastructure.util.LocalDateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class Util {

	@Bean
	public LocalDateTimeFormatter localDateTimeFormatter() {
		return new LocalDateTimeFormatter();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return objectMapper;
	}

	@Bean
	public JsonHydrator jsonHydrator(ObjectMapper objectMapper) {
		return new JacksonJsonHydrator(objectMapper);
	}

	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}

}
