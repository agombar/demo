package com.demo.users.processor.infrastructure.rabbit.user.create.creator;

import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.users.processor.infrastructure.rabbit.user.create.UserCreateMessage;
import com.demo.users.processor.infrastructure.rabbit.user.mapper.UserMessageProduceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCreateMessageCreator {

	private final MessageHeaderCreator messageHeaderCreator;
	private final UserMessageProduceMapper userMessageProduceMapper;

	public UserCreateMessage create(User user) {
		return new UserCreateMessage(
			this.messageHeaderCreator.create("user"),
			this.userMessageProduceMapper.toUserCreatedMessage(user)
		);
	}

}