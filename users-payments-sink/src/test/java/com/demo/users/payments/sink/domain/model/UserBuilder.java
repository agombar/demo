package com.demo.users.payments.sink.domain.model;

import com.demo.users.payments.sink.builder.Builder;
import com.demo.users.payments.sink.builder.FakeUuid;

public class UserBuilder extends Builder<User> {

	@Override
	public User build(int index) {
		return new User()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
