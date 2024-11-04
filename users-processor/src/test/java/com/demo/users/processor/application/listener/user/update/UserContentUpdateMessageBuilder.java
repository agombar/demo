package com.demo.users.processor.application.listener.user.update;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.builder.FakeUuid;

public class UserContentUpdateMessageBuilder extends Builder<UserContentUpdateMessage> {

	@Override
	public UserContentUpdateMessage build(int index) {
		return new UserContentUpdateMessage()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
