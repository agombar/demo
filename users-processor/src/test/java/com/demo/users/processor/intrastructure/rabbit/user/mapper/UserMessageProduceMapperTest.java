package com.demo.users.processor.intrastructure.rabbit.user.mapper;

import com.demo.users.processor.builder.FakeUuid;
import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.infrastructure.rabbit.user.create.UserContentCreateMessage;
import com.demo.users.processor.infrastructure.rabbit.user.mapper.UserMessageProduceMapper;
import com.demo.users.processor.infrastructure.rabbit.user.update.UserContentUpdateMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserMessageProduceMapperTest {

	private final UserMessageProduceMapper mapper = UserMessageProduceMapper.INSTANCE;

	@Test
	void when_user_create_is_given_then_message_is_retrieve() {
		UserContentCreateMessage user = this.mapper.toUserCreatedMessage(
			new User()
				.setId(FakeUuid.uuid(3))
				.setUsername("::username::")
				.setEmail("::email::")
		);

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

	@Test
	void when_user_update_is_given_then_message_is_retrieve() {
		UserContentUpdateMessage user = this.mapper.toUserUpdatedMessage(
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
