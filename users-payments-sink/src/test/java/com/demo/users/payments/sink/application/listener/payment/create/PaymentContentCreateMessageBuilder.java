package com.demo.users.payments.sink.application.listener.payment.create;

import com.demo.users.payments.sink.application.listener.payment.dto.create.PaymentContentCreateMessage;
import com.demo.users.payments.sink.builder.Builder;
import com.demo.users.payments.sink.builder.FakeClock;
import com.demo.users.payments.sink.builder.FakeUuid;

import java.math.BigDecimal;

public class PaymentContentCreateMessageBuilder extends Builder<PaymentContentCreateMessage> {

	@Override
	public PaymentContentCreateMessage build(int index) {
		return new PaymentContentCreateMessage()
			.setId(FakeUuid.uuid(index))
			.setAmount(new BigDecimal(index * 10000))
			.setUserId(FakeUuid.uuid(index + 1))
			.setPaymentDate(FakeClock.dateTime(index));
	}

}
