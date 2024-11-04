package com.demo.users.payments.sink.application.listener.user.update;

import com.demo.users.payments.sink.application.listener.user.dto.update.UserContentUpdateMessage;
import com.demo.users.payments.sink.builder.FakeUuid;
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
