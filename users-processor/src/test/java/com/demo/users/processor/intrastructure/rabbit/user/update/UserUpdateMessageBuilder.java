package com.demo.users.processor.intrastructure.rabbit.user.update;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.infrastructure.rabbit.user.update.UserUpdateMessage;
import com.demo.users.processor.intrastructure.rabbit.header.MessageHeaderBuilder;

public class UserUpdateMessageBuilder extends Builder<UserUpdateMessage> {

	@Override
	public UserUpdateMessage build(int index) {
		return new UserUpdateMessage(
			new MessageHeaderBuilder().build(index),
			new UserContentUpdateMessageBuilder().build(index)
		);
	}

}
