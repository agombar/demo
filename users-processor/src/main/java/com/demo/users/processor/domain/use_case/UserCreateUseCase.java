package com.demo.users.processor.domain.use_case;

import com.demo.users.processor.domain.exception.PublishMessageException;
import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.domain.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserCreateUseCase {

	private final MessagingService messagingService;

	public void execute(User user) {
		try {
			this.messagingService.publishUserCreated(user);
		} catch(PublishMessageException e) {
			log.error("Cannot publish user created {}", user, e);
		}
	}

}
