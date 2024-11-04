package com.demo.users.processor.application.bean;

import com.demo.users.processor.domain.service.MessagingService;
import com.demo.users.processor.domain.use_case.UserCreateUseCase;
import com.demo.users.processor.domain.use_case.UserUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCase {

	@Bean
	public UserCreateUseCase userCreateUseCase(MessagingService messagingService) {
		return new UserCreateUseCase(messagingService);
	}

	@Bean
	public UserUpdateUseCase userUpdateUseCase(MessagingService messagingService) {
		return new UserUpdateUseCase(messagingService);
	}

}
