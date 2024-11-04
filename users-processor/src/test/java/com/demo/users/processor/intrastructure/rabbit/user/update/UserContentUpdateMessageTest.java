package com.demo.users.processor.intrastructure.rabbit.user.update;

import com.demo.users.processor.builder.FakeUuid;
import com.demo.users.processor.infrastructure.rabbit.user.update.UserContentUpdateMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserContentUpdateMessageTest {

	@Test
	void when_user_is_updated_then_it_is_retrieve() {
		UserContentUpdateMessage user = new UserContentUpdateMessage()
			.setId(FakeUuid.uuid(3))
			.setUsername("::username::")
			.setEmail("::email::");

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
