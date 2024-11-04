package com.demo.payments.processor.intrastructure.rabbit.payment.create;

import com.demo.payments.processor.builder.Builder;
import com.demo.payments.processor.builder.FakeClock;
import com.demo.payments.processor.builder.FakeUuid;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.PaymentContentCreateMessage;

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
