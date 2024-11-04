package com.demo.users.processor.application.listener.user;

import com.demo.users.processor.application.listener.user.create.UserContentCreateMessage;
import com.demo.users.processor.application.listener.user.create.UserCreateMessageBuilder;
import com.demo.users.processor.application.listener.user.mapper.UserMessageConsumeMapper;
import com.demo.users.processor.application.listener.user.update.UserContentUpdateMessage;
import com.demo.users.processor.application.listener.user.update.UserUpdateMessageBuilder;
import com.demo.users.processor.domain.model.UserBuilder;
import com.demo.users.processor.domain.use_case.UserCreateUseCase;
import com.demo.users.processor.domain.use_case.UserUpdateUseCase;
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
	private UserCreateUseCase userCreateUseCase;

	@Mock
	private UserUpdateUseCase userUpdateUseCase;

	@Mock
	private UserMessageConsumeMapper userMessageConsumeMapper;

	@Test
	void when_user_create_is_given_then_they_are_mapped() {
		this.listener.handleUserCreatedMessage(
			new UserCreateMessageBuilder().build(3)
		);

		verify(this.userMessageConsumeMapper).toUser(new UserCreateMessageBuilder().build(3).getContent());
	}


	@Test
	void when_user_create_is_mapped_then_it_is_created() {
		when(this.userMessageConsumeMapper.toUser(any(UserContentCreateMessage.class)))
			.thenReturn(new UserBuilder().build(3));

		this.listener.handleUserCreatedMessage(
			new UserCreateMessageBuilder().build(3)
		);

		verify(this.userCreateUseCase).execute(new UserBuilder().build(3));
	}

	@Test
	void when_user_update_is_given_then_they_are_mapped() {
		this.listener.handleUserUpdatedMessage(
			new UserUpdateMessageBuilder().build(3)
		);

		verify(this.userMessageConsumeMapper).toUser(new UserUpdateMessageBuilder().build(3).getContent());
	}


	@Test
	void when_user_update_is_mapped_then_it_is_updated() {
		when(this.userMessageConsumeMapper.toUser(any(UserContentUpdateMessage.class)))
			.thenReturn(new UserBuilder().build(3));

		this.listener.handleUserUpdatedMessage(
			new UserUpdateMessageBuilder().build(3)
		);

		verify(this.userUpdateUseCase).execute(new UserBuilder().build(3));
	}

}