package com.demo.users.payments.sink.application.listener.user.create;

import com.demo.users.payments.sink.application.listener.user.dto.create.UserContentCreateMessage;
import com.demo.users.payments.sink.builder.Builder;
import com.demo.users.payments.sink.builder.FakeUuid;

public class UserContentCreateMessageBuilder extends Builder<UserContentCreateMessage> {

	@Override
	public UserContentCreateMessage build(int index) {
		return new UserContentCreateMessage()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
