package com.demo.users.payments.sink.domain.model;

import com.demo.users.payments.sink.builder.FakeUuid;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

	@Test
	void when_user_is_created_then_it_is_retrieve() {
		User user = new User()
			.setId(FakeUuid.uuid(3))
			.setUsername("::username::")
			.setEmail("::email::");

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
