package com.demo.payments.processor.application.bean;

import com.demo.payments.processor.application.listener.payment.PaymentListener;
import com.demo.payments.processor.application.listener.payment.mapper.PaymentMessageConsumeMapper;
import com.demo.payments.processor.domain.use_case.PaymentCreateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Consumer {

	@Bean
	public PaymentListener paymentListener(PaymentCreateUseCase paymentCreateUseCase) {
		return new PaymentListener(
			paymentCreateUseCase,
			PaymentMessageConsumeMapper.INSTANCE
		);
	}

}
