package com.demo.users.processor.intrastructure.rabbit.header;

import com.demo.users.processor.builder.FakeClock;
import com.demo.users.processor.infrastructure.rabbit.header.MessageHeader;
import com.demo.users.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.users.processor.infrastructure.util.LocalDateTimeFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageHeaderCreatorTest {

	private MessageHeaderCreator creator;

	@Mock
	private LocalDateTimeFormatter localDateTimeFormatter;

	@BeforeEach
	public void setUp() {
		Clock clock = Clock.fixed(FakeClock.dateTime(2).toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
		this.creator = new MessageHeaderCreator(
			this.localDateTimeFormatter,
			clock
		);
	}

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		when(this.localDateTimeFormatter.toISO(any())).thenReturn(FakeClock.dateTime(2).toString());

		MessageHeader messageHeader = this.creator.create("::object-name::");

		assertThat(messageHeader.getObjectName()).isEqualTo("::object-name::");
		assertThat(messageHeader.getVersion()).isEqualTo(1);
		assertThat(messageHeader.getCreatedAt()).isEqualTo(FakeClock.dateTime(2).toString());
	}

}