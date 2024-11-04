package com.demo.payments.processor.application.bean;

import com.demo.payments.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.creator.PaymentCreateMessageCreator;
import com.demo.payments.processor.infrastructure.rabbit.payment.mapper.PaymentMessageProduceMapper;
import com.demo.payments.processor.infrastructure.util.LocalDateTimeFormatter;
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
	public PaymentCreateMessageCreator paymentCreateMessageCreator(
		MessageHeaderCreator messageHeaderCreator
	) {
		return new PaymentCreateMessageCreator(messageHeaderCreator, PaymentMessageProduceMapper.INSTANCE);
	}

}
