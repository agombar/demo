package com.demo.users.processor.infrastructure.rabbit;

import com.demo.users.processor.domain.exception.PublishMessageException;
import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.domain.service.MessagingService;
import com.demo.users.processor.infrastructure.exception.HydrationException;
import com.demo.users.processor.infrastructure.rabbit.user.create.creator.UserCreateMessageCreator;
import com.demo.users.processor.infrastructure.rabbit.user.update.creator.UserUpdateMessageCreator;
import com.demo.users.processor.infrastructure.util.JsonHydrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RabbitMessagingService implements MessagingService {

	private final RabbitService rabbitService;

	private final JsonHydrator jsonHydrator;

	private final Routing userCreatedRouting;
	private final Routing userUpdatedRouting;

	private final UserCreateMessageCreator userCreateMessageCreator;
	private final UserUpdateMessageCreator userUpdateMessageCreator;

	@Override
	public void publishUserCreated(User user) throws PublishMessageException {
		log.info("User created published: {}", user);

		this.rabbitService.publish(
			this.userCreatedRouting.resolve(),
			new RabbitMessage(
				this.dehydrate(this.userCreateMessageCreator.create(user))
			)
		);

	}

	@Override
	public void publishUserUpdated(User user) throws PublishMessageException {
		log.info("User updated published: {}", user);

		this.rabbitService.publish(
			this.userUpdatedRouting.resolve(),
			new RabbitMessage(
				this.dehydrate(this.userUpdateMessageCreator.create(user))
			)
		);

	}

	private String dehydrate(Object object) throws PublishMessageException {
		try {
			return this.jsonHydrator.dehydrate(object);
		} catch(HydrationException e) {
			throw new PublishMessageException("Bad message format", e);
		}
	}

}
