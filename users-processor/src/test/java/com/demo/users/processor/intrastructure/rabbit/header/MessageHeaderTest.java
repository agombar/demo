package com.demo.users.processor.intrastructure.rabbit.header;

import com.demo.users.processor.builder.FakeClock;
import com.demo.users.processor.infrastructure.rabbit.header.MessageHeader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessageHeaderTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		MessageHeader messageHeader = new MessageHeader(
			"::object-name::",
			1,
			FakeClock.dateTime(2).toString()
		);

		assertThat(messageHeader.getObjectName()).isEqualTo("::object-name::");
		assertThat(messageHeader.getVersion()).isEqualTo(1);
		assertThat(messageHeader.getCreatedAt()).isEqualTo(FakeClock.dateTime(2).toString());
	}

}