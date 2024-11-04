package com.demo.users.processor.application.listener.header;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.builder.FakeClock;

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
