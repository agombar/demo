package com.demo.users.processor.application.listener.user.mapper;

import com.demo.users.processor.application.listener.user.create.UserContentCreateMessage;
import com.demo.users.processor.builder.FakeUuid;
import com.demo.users.processor.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserMessageConsumeMapperTest {

	private final UserMessageConsumeMapper mapper = UserMessageConsumeMapper.INSTANCE;

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
