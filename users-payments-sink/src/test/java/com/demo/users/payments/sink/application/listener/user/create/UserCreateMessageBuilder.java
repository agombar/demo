package com.demo.users.payments.sink.application.listener.user.create;

import com.demo.users.payments.sink.application.listener.header.MessageHeaderBuilder;
import com.demo.users.payments.sink.application.listener.user.dto.create.UserCreateMessage;
import com.demo.users.payments.sink.builder.Builder;

public class UserCreateMessageBuilder extends Builder<UserCreateMessage> {

	@Override
	public UserCreateMessage build(int index) {
		return new UserCreateMessage(
			new MessageHeaderBuilder().build(index),
			new UserContentCreateMessageBuilder().build(index)
		);
	}

}
