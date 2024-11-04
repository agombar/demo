package com.demo.users.payments.api.domain.model;

import com.demo.users.payments.api.builder.Builder;
import com.demo.users.payments.api.builder.FakeUuid;

public class UserBuilder extends Builder<User> {

	@Override
	public User build(int index) {
		return new User()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}