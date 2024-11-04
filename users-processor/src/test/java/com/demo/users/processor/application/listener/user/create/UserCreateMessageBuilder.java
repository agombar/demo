package com.demo.users.processor.application.listener.user.create;

import com.demo.users.processor.application.listener.header.MessageHeaderBuilder;
import com.demo.users.processor.builder.Builder;

public class UserCreateMessageBuilder extends Builder<UserCreateMessage> {

	@Override
	public UserCreateMessage build(int index) {
		return new UserCreateMessage(
			new MessageHeaderBuilder().build(index),
			new UserContentCreateMessageBuilder().build(index)
		);
	}

}
