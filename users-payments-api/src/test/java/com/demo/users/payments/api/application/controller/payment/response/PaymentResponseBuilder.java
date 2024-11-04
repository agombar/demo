package com.demo.users.payments.api.application.controller.payment.response;

import com.demo.users.payments.api.application.controller.user.response.UserResponseBuilder;
import com.demo.users.payments.api.builder.Builder;
import com.demo.users.payments.api.builder.FakeClock;
import com.demo.users.payments.api.builder.FakeUuid;

import java.math.BigDecimal;

public class PaymentResponseBuilder extends Builder<PaymentResponse> {

	@Override
	public PaymentResponse build(int index) {
		return new PaymentResponse()
			.setId(FakeUuid.uuid(index))
			.setAmount(new BigDecimal(index * 10000))
			.setUser(new UserResponseBuilder().build(index))
			.setPaymentDate(FakeClock.dateTime(index));
	}

}
