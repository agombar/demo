package com.demo.payments.processor.domain.model;

import com.demo.payments.processor.builder.Builder;
import com.demo.payments.processor.builder.FakeClock;
import com.demo.payments.processor.builder.FakeUuid;

import java.math.BigDecimal;

public class PaymentBuilder extends Builder<Payment> {

	@Override
	public Payment build(int index) {
		return new Payment()
			.setId(FakeUuid.uuid(index))
			.setAmount(new BigDecimal(index * 10000))
			.setUserId(FakeUuid.uuid(index + 1))
			.setPaymentDate(FakeClock.dateTime(index));
	}

}
