package com.demo.users.processor.domain.use_case;

import com.demo.users.processor.domain.exception.PublishMessageException;
import com.demo.users.processor.domain.model.UserBuilder;
import com.demo.users.processor.domain.service.MessagingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserCreateUseCaseTest {

	@InjectMocks
	private UserCreateUseCase useCase;

	@Mock
	private MessagingService messagingService;

	@Test
	void when_user_is_given_then_it_is_published() throws PublishMessageException {
		this.useCase.execute(new UserBuilder().build(3));

		verify(this.messagingService).publishUserCreated(new UserBuilder().build(3));
	}

}
