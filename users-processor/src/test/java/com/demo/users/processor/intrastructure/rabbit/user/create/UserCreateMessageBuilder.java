package com.demo.users.processor.intrastructure.rabbit.user.create;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.infrastructure.rabbit.user.create.UserCreateMessage;
import com.demo.users.processor.intrastructure.rabbit.header.MessageHeaderBuilder;

public class UserCreateMessageBuilder extends Builder<UserCreateMessage> {

	@Override
	public UserCreateMessage build(int index) {
		return new UserCreateMessage(
			new MessageHeaderBuilder().build(index),
			new UserContentCreateMessageBuilder().build(index)
		);
	}

}
