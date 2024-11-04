package com.demo.users.processor.application.listener.user.create;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.builder.FakeUuid;

public class UserContentCreateMessageBuilder extends Builder<UserContentCreateMessage> {

	@Override
	public UserContentCreateMessage build(int index) {
		return new UserContentCreateMessage()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
