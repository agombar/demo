package com.demo.users.payments.api.intrastructure.jpa.entity.payment;

import com.demo.users.payments.api.builder.Builder;
import com.demo.users.payments.api.builder.FakeClock;
import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.api.intrastructure.jpa.entity.user.UserEntityBuilder;

import java.math.BigDecimal;

public class PaymentEntityBuilder extends Builder<PaymentEntity> {

	@Override
	public PaymentEntity build(int index) {
		return new PaymentEntity()
			.setId(FakeUuid.uuid(index))
			.setAmount(new BigDecimal(index * 10000))
			.setUser(new UserEntityBuilder().build(index))
			.setPaymentDate(FakeClock.dateTime(index));
	}

}
