package com.demo.users.processor.intrastructure.rabbit.user.create;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.builder.FakeUuid;
import com.demo.users.processor.infrastructure.rabbit.user.create.UserContentCreateMessage;

public class UserContentCreateMessageBuilder extends Builder<UserContentCreateMessage> {

	@Override
	public UserContentCreateMessage build(int index) {
		return new UserContentCreateMessage()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
