package com.demo.payments.processor.infrastructure.rabbit.header;

import com.demo.payments.processor.infrastructure.util.LocalDateTimeFormatter;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class MessageHeaderCreator {

	private final LocalDateTimeFormatter localDateTimeFormatter;
	private final Clock clock;

	public MessageHeader create(String objectName) {
		return new MessageHeader(
			objectName,
			1,
			this.localDateTimeFormatter.toISO(LocalDateTime.now(this.clock))
		);
	}

}