package com.demo.users.payments.sink.application.listener.header;

import com.demo.users.payments.sink.builder.FakeClock;
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

		assertThat("::object-name::").isEqualTo(messageHeader.getObjectName());
		assertThat(1).isEqualTo(messageHeader.getVersion());
		assertThat(FakeClock.dateTime(2).toString()).isEqualTo(messageHeader.getCreatedAt());
	}

}