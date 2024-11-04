package com.demo.users.payments.sink.application.listener.user;


import com.demo.users.payments.sink.application.listener.user.create.UserCreateMessageBuilder;
import com.demo.users.payments.sink.application.listener.user.dto.create.UserContentCreateMessage;
import com.demo.users.payments.sink.application.listener.user.dto.update.UserContentUpdateMessage;
import com.demo.users.payments.sink.application.listener.user.mapper.UserMessageMapper;
import com.demo.users.payments.sink.application.listener.user.update.UserUpdateMessageBuilder;
import com.demo.users.payments.sink.domain.exception.ResourceCreateException;
import com.demo.users.payments.sink.domain.exception.ResourceUpdateException;
import com.demo.users.payments.sink.domain.model.UserBuilder;
import com.demo.users.payments.sink.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserListenerTest {

	@InjectMocks
	private UserListener listener;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMessageMapper userMessageMapper;

	@Test
	void when_user_create_is_given_then_they_are_mapped() {
		this.listener.handleUserCreatedMessage(
			new UserCreateMessageBuilder().build(3)
		);

		verify(this.userMessageMapper).toUser(new UserCreateMessageBuilder().build(3).getContent());
	}


	@Test
	void when_user_create_is_mapped_then_it_is_created() throws ResourceCreateException {
		when(this.userMessageMapper.toUser(any(UserContentCreateMessage.class)))
			.thenReturn(new UserBuilder().build(3));

		this.listener.handleUserCreatedMessage(
			new UserCreateMessageBuilder().build(3)
		);

		verify(this.userRepository).create(new UserBuilder().build(3));
	}

	@Test
	void when_user_update_is_given_then_they_are_mapped() {
		this.listener.handleUserUpdatedMessage(
			new UserUpdateMessageBuilder().build(3)
		);

		verify(this.userMessageMapper).toUser(new UserUpdateMessageBuilder().build(3).getContent());
	}


	@Test
	void when_user_update_is_mapped_then_it_is_updated() throws ResourceUpdateException {
		when(this.userMessageMapper.toUser(any(UserContentUpdateMessage.class)))
			.thenReturn(new UserBuilder().build(3));

		this.listener.handleUserUpdatedMessage(
			new UserUpdateMessageBuilder().build(3)
		);

		verify(this.userRepository).update(new UserBuilder().build(3));
	}

}