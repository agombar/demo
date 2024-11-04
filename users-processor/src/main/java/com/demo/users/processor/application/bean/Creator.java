package com.demo.users.processor.application.bean;


import com.demo.users.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.users.processor.infrastructure.rabbit.user.create.creator.UserCreateMessageCreator;
import com.demo.users.processor.infrastructure.rabbit.user.mapper.UserMessageProduceMapper;
import com.demo.users.processor.infrastructure.rabbit.user.update.creator.UserUpdateMessageCreator;
import com.demo.users.processor.infrastructure.util.LocalDateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class Creator {

	@Bean
	public MessageHeaderCreator messageHeaderCreator(
		LocalDateTimeFormatter localDateTimeFormatter,
		Clock clock
	) {
		return new MessageHeaderCreator(localDateTimeFormatter, clock);
	}

	@Bean
	public UserCreateMessageCreator userCreateMessageCreator(
		MessageHeaderCreator messageHeaderCreator
	) {
		return new UserCreateMessageCreator(messageHeaderCreator, UserMessageProduceMapper.INSTANCE);
	}

	@Bean
	public UserUpdateMessageCreator userUpdateMessageCreator(
		MessageHeaderCreator messageHeaderCreator
	) {
		return new UserUpdateMessageCreator(messageHeaderCreator, UserMessageProduceMapper.INSTANCE);
	}

}
