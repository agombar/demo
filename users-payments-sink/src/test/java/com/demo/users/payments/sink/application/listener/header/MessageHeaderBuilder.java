package com.demo.users.payments.sink.application.listener.header;

import com.demo.users.payments.sink.builder.Builder;
import com.demo.users.payments.sink.builder.FakeClock;

public class MessageHeaderBuilder extends Builder<MessageHeader> {

	@Override
	public MessageHeader build(int index) {
		return new MessageHeader(
			"::object-name-" + index + "::",
			index,
			FakeClock.dateTime(index).toString()
		);
	}

}
