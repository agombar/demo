package com.demo.users.payments.sink.application.listener.user.update;

import com.demo.users.payments.sink.application.listener.user.dto.update.UserContentUpdateMessage;
import com.demo.users.payments.sink.builder.Builder;
import com.demo.users.payments.sink.builder.FakeUuid;

public class UserContentUpdateMessageBuilder extends Builder<UserContentUpdateMessage> {

	@Override
	public UserContentUpdateMessage build(int index) {
		return new UserContentUpdateMessage()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
