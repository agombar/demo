package com.demo.payments.processor.application.bean;

import com.demo.payments.processor.domain.service.MessagingService;
import com.demo.payments.processor.domain.use_case.PaymentCreateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCase {

	@Bean
	public PaymentCreateUseCase paymentProcessorUseCase(MessagingService messagingService) {
		return new PaymentCreateUseCase(messagingService);
	}

}
