package com.demo.users.payments.sink.domain.repository;

import com.demo.users.payments.sink.domain.exception.ResourceCreateException;
import com.demo.users.payments.sink.domain.model.Payment;

public interface PaymentRepository {

	Payment create(Payment payment) throws ResourceCreateException;

}
