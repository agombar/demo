package com.demo.users.payments.api.intrastructure.jpa.entity.user;

import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.UserEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserEntityTest {

	@Test
	void when_user_is_created_then_it_is_retrieve() {
		UserEntity user = new UserEntity()
			.setId(FakeUuid.uuid(3))
			.setUsername("::username::")
			.setEmail("::email::");

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
