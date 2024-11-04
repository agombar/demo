package com.demo.users.payments.sink.intrastructure.jpa.entity.user.mapper;

import com.demo.users.payments.sink.builder.FakeUuid;
import com.demo.users.payments.sink.domain.model.User;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.UserEntity;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.mapper.UserEntityMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserEntityMapperTest {

	private final UserEntityMapper mapper = UserEntityMapper.INSTANCE;

	@Test
	void when_entity_is_given_then_user_is_retrieve() {
		User user = this.mapper.toUser(
			new UserEntity()
				.setId(FakeUuid.uuid(3))
				.setUsername("::username::")
				.setEmail("::email::")
		);

		assertThat(user.getId()).isEqualTo(FakeUuid.uuid(3));
		assertThat(user.getUsername()).isEqualTo("::username::");
		assertThat(user.getEmail()).isEqualTo("::email::");
	}

}
