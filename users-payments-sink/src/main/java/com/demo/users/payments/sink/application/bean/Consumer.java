package com.demo.users.payments.sink.application.bean;

import com.demo.users.payments.sink.application.listener.payment.PaymentListener;
import com.demo.users.payments.sink.application.listener.payment.mapper.PaymentMessageMapper;
import com.demo.users.payments.sink.application.listener.user.UserListener;
import com.demo.users.payments.sink.application.listener.user.mapper.UserMessageMapper;
import com.demo.users.payments.sink.domain.repository.PaymentRepository;
import com.demo.users.payments.sink.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Consumer {

	@Bean
	public UserListener userListener(UserRepository userRepository) {
		return new UserListener(
			userRepository,
			UserMessageMapper.INSTANCE
		);
	}

	@Bean
	public PaymentListener paymentListener(PaymentRepository paymentRepository) {
		return new PaymentListener(
			paymentRepository,
			PaymentMessageMapper.INSTANCE
		);
	}

}
