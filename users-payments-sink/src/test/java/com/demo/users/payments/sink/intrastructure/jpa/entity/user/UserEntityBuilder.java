package com.demo.users.payments.sink.intrastructure.jpa.entity.user;

import com.demo.users.payments.sink.builder.Builder;
import com.demo.users.payments.sink.builder.FakeUuid;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.UserEntity;

public class UserEntityBuilder extends Builder<UserEntity> {

	@Override
	public UserEntity build(int index) {
		return new UserEntity()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
