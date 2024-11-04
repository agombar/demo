package com.demo.users.processor.intrastructure.rabbit.user.update;

import com.demo.users.processor.infrastructure.rabbit.user.update.UserUpdateMessage;
import com.demo.users.processor.intrastructure.rabbit.header.MessageHeaderBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserUpdateMessageTest {

	@Test
	void when_user_is_updated_then_it_is_retrieve() {
		UserUpdateMessage user = new UserUpdateMessage(
			new MessageHeaderBuilder().build(3),
			new UserContentUpdateMessageBuilder().build(4)
		);

		assertThat(user.getHeader()).isEqualTo(new MessageHeaderBuilder().build(3));
		assertThat(user.getContent()).isEqualTo(new UserContentUpdateMessageBuilder().build(4));
	}

}
