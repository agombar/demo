package com.demo.users.processor.intrastructure.rabbit.user.create;

import com.demo.users.processor.builder.FakeUuid;
import com.demo.users.processor.infrastructure.rabbit.user.create.UserContentCreateMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserContentCreateMessageTest {

	@Test
	void when_user_is_created_then_it_is_retrieve() {
		UserContentCreateMessage user = new UserContentCreateMessage()
			.setId(FakeUuid.uuid(3))
			.setUsername("::username::")
			.setEmail("::email::");

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
