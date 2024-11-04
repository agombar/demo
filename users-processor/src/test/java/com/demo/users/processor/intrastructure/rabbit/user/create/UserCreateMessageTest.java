package com.demo.users.processor.intrastructure.rabbit.user.create;

import com.demo.users.processor.infrastructure.rabbit.user.create.UserCreateMessage;
import com.demo.users.processor.intrastructure.rabbit.header.MessageHeaderBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserCreateMessageTest {

	@Test
	void when_user_is_created_then_it_is_retrieve() {
		UserCreateMessage user = new UserCreateMessage(
			new MessageHeaderBuilder().build(3),
			new UserContentCreateMessageBuilder().build(4)
		);

		assertThat(user.getHeader()).isEqualTo(new MessageHeaderBuilder().build(3));
		assertThat(user.getContent()).isEqualTo(new UserContentCreateMessageBuilder().build(4));
	}

}
