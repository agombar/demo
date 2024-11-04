package com.demo.payments.processor.domain.service;

import com.demo.payments.processor.domain.exception.PublishMessageException;
import com.demo.payments.processor.domain.model.Payment;

public interface MessagingService {

	void publishPaymentCreated(Payment payment) throws PublishMessageException;

}
