package com.demo.users.payments.api.application.controller.user.mapper;

import com.demo.users.payments.api.application.controller.user.response.UserResponse;
import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResponseMapperTest {

	private final UserResponseMapper mapper = UserResponseMapper.INSTANCE;

	@Test
	void when_response_is_given_then_user_is_retrieve() {
		UserResponse user = this.mapper.toUserResponse(
			new User()
				.setId(FakeUuid.uuid(3))
				.setUsername("::username::")
				.setEmail("::email::")
		);

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
