package com.demo.users.processor.infrastructure.rabbit.user.update.creator;

import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.users.processor.infrastructure.rabbit.user.mapper.UserMessageProduceMapper;
import com.demo.users.processor.infrastructure.rabbit.user.update.UserUpdateMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUpdateMessageCreator {

	private final MessageHeaderCreator messageHeaderCreator;
	private final UserMessageProduceMapper userMessageProduceMapper;

	public UserUpdateMessage create(User user) {
		return new UserUpdateMessage(
			this.messageHeaderCreator.create("user-updated"),
			this.userMessageProduceMapper.toUserUpdatedMessage(user)
		);
	}

}