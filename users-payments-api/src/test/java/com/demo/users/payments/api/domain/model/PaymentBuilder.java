package com.demo.users.payments.api.domain.model;

import com.demo.users.payments.api.builder.Builder;
import com.demo.users.payments.api.builder.FakeClock;
import com.demo.users.payments.api.builder.FakeUuid;

import java.math.BigDecimal;

public class PaymentBuilder extends Builder<Payment> {

	@Override
	public Payment build(int index) {
		return new Payment()
			.setId(FakeUuid.uuid(index))
			.setAmount(new BigDecimal(index * 10000))
			.setUser(new UserBuilder().build(index))
			.setPaymentDate(FakeClock.dateTime(index));
	}

}
