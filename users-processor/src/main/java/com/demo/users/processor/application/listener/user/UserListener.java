package com.demo.users.processor.application.listener.user;

import com.demo.users.processor.application.listener.user.create.UserCreateMessage;
import com.demo.users.processor.application.listener.user.mapper.UserMessageConsumeMapper;
import com.demo.users.processor.application.listener.user.update.UserUpdateMessage;
import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.domain.use_case.UserCreateUseCase;
import com.demo.users.processor.domain.use_case.UserUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RequiredArgsConstructor
public class UserListener {

	private final UserCreateUseCase userCreateUseCase;
	private final UserUpdateUseCase userUpdateUseCase;
	private final UserMessageConsumeMapper userMessageConsumeMapper;

	@RabbitListener(queues = "${messaging.userExternalCreated.queue}")
	public void handleUserCreatedMessage(UserCreateMessage userMessage) {
		try {
			User user = this.userMessageConsumeMapper.toUser(userMessage.getContent());
			this.userCreateUseCase.execute(user);
			log.info("User created consumed: {}", user);
		} catch(Exception e) {
			log.error("Error processing user created message: {}", userMessage, e);
		}
	}

	@RabbitListener(queues = "${messaging.userExternalUpdated.queue}")
	public void handleUserUpdatedMessage(UserUpdateMessage userMessage) {
		try {
			User user = this.userMessageConsumeMapper.toUser(userMessage.getContent());
			this.userUpdateUseCase.execute(user);
			log.info("User updated consumed: {}", user);
		} catch(Exception e) {
			log.error("Error processing user updated message: {}", userMessage, e);
		}
	}

}
