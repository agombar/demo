package com.demo.users.processor.domain.model;

import com.demo.users.processor.builder.Builder;
import com.demo.users.processor.builder.FakeUuid;

public class UserBuilder extends Builder<User> {

	@Override
	public User build(int index) {
		return new User()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
