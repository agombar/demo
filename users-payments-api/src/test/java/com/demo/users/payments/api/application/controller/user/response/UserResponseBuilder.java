package com.demo.users.payments.api.application.controller.user.response;

import com.demo.users.payments.api.builder.Builder;
import com.demo.users.payments.api.builder.FakeUuid;

public class UserResponseBuilder extends Builder<UserResponse> {

	@Override
	public UserResponse build(int index) {
		return new UserResponse()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
