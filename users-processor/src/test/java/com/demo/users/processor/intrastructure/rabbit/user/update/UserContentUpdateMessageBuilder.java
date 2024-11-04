package com.demo.users.processor.intrastructure.rabbit.user.update;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.builder.FakeUuid;
import com.demo.users.processor.infrastructure.rabbit.user.update.UserContentUpdateMessage;

public class UserContentUpdateMessageBuilder extends Builder<UserContentUpdateMessage> {

	@Override
	public UserContentUpdateMessage build(int index) {
		return new UserContentUpdateMessage()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
