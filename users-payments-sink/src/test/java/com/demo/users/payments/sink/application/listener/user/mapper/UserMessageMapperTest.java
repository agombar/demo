package com.demo.users.payments.sink.application.listener.user.mapper;

import com.demo.users.payments.sink.application.listener.user.dto.create.UserContentCreateMessage;
import com.demo.users.payments.sink.builder.FakeUuid;
import com.demo.users.payments.sink.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserMessageMapperTest {

	private final UserMessageMapper mapper = UserMessageMapper.INSTANCE;

	@Test
	void when_message_is_given_then_user_is_retrieve() {
		User user = this.mapper.toUser(
			new UserContentCreateMessage()
				.setId(FakeUuid.uuid(3))
				.setUsername("::username::")
				.setEmail("::email::")
		);

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
