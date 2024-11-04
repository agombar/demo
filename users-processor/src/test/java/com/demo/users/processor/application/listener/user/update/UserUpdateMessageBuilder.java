package com.demo.users.processor.application.listener.user.update;

import com.demo.users.processor.application.listener.header.MessageHeaderBuilder;
import com.demo.users.processor.builder.Builder;

public class UserUpdateMessageBuilder extends Builder<UserUpdateMessage> {

	@Override
	public UserUpdateMessage build(int index) {
		return new UserUpdateMessage(
			new MessageHeaderBuilder().build(index),
			new UserContentUpdateMessageBuilder().build(index)
		);
	}

}
