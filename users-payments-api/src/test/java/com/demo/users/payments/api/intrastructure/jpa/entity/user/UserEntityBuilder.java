package com.demo.users.payments.api.intrastructure.jpa.entity.user;

import com.demo.users.payments.api.builder.Builder;
import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.UserEntity;

public class UserEntityBuilder extends Builder<UserEntity> {

	@Override
	public UserEntity build(int index) {
		return new UserEntity()
			.setId(FakeUuid.uuid(index))
			.setUsername("::username-" + index + "::")
			.setEmail("::email-" + index + "::");
	}

}
