package com.demo.users.payments.sink.application.listener.user.update;

import com.demo.users.payments.sink.application.listener.header.MessageHeaderBuilder;
import com.demo.users.payments.sink.application.listener.user.dto.update.UserUpdateMessage;
import com.demo.users.payments.sink.builder.Builder;

public class UserUpdateMessageBuilder extends Builder<UserUpdateMessage> {

	@Override
	public UserUpdateMessage build(int index) {
		return new UserUpdateMessage(
			new MessageHeaderBuilder().build(index),
			new UserContentUpdateMessageBuilder().build(index)
		);
	}

}
