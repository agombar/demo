package com.demo.users.payments.sink.application.listener.user;

import com.demo.users.payments.sink.application.listener.user.dto.create.UserCreateMessage;
import com.demo.users.payments.sink.application.listener.user.dto.update.UserUpdateMessage;
import com.demo.users.payments.sink.application.listener.user.mapper.UserMessageMapper;
import com.demo.users.payments.sink.domain.model.User;
import com.demo.users.payments.sink.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RequiredArgsConstructor
public class UserListener {

	private final UserRepository userRepository;
	private final UserMessageMapper userMessageMapper;

	@RabbitListener(queues = "${messaging.userCreated.queue}")
	public void handleUserCreatedMessage(UserCreateMessage userMessage) {
		try {
			User user = this.userRepository.create(this.userMessageMapper.toUser(userMessage.getContent()));
			log.info("User created consumed: {}", user);
		} catch(Exception e) {
			log.error("Error processing user created message: {}", userMessage, e);
		}
	}

	@RabbitListener(queues = "${messaging.userUpdated.queue}")
	public void handleUserUpdatedMessage(UserUpdateMessage userMessage) {
		try {
			User user = this.userRepository.update(this.userMessageMapper.toUser(userMessage.getContent()));
			log.info("User updated consumed: {}", user);
		} catch(Exception e) {
			log.error("Error processing user updated message: {}", userMessage, e);
		}
	}

}
