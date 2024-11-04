package com.demo.users.processor.application.bean;

import com.demo.users.processor.application.listener.user.UserListener;
import com.demo.users.processor.application.listener.user.mapper.UserMessageConsumeMapper;
import com.demo.users.processor.domain.use_case.UserCreateUseCase;
import com.demo.users.processor.domain.use_case.UserUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Consumer {

	@Bean
	public UserListener userListener(
		UserCreateUseCase userCreateUseCase,
		UserUpdateUseCase userUpdateUseCase
	) {
		return new UserListener(
			userCreateUseCase,
			userUpdateUseCase,
			UserMessageConsumeMapper.INSTANCE
		);
	}

}
