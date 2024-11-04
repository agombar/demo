package com.demo.users.processor.domain.model;

import com.demo.users.processor.builder.FakeUuid;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

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
