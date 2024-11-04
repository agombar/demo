package com.demo.payments.processor.application.listener.payment;

import com.demo.payments.processor.application.listener.payment.create.PaymentCreateMessageBuilder;
import com.demo.payments.processor.application.listener.payment.mapper.PaymentMessageConsumeMapper;
import com.demo.payments.processor.domain.model.PaymentBuilder;
import com.demo.payments.processor.domain.use_case.PaymentCreateUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentListenerTest {

	@InjectMocks
	private PaymentListener listener;

	@Mock
	private PaymentCreateUseCase paymentCreateUseCase;

	@Mock
	private PaymentMessageConsumeMapper paymentMessageConsumeMapper;

	@Test
	void when_values_are_given_then_they_are_mapped() {
		this.listener.handleUserCreatedMessage(
			new PaymentCreateMessageBuilder().build(3)
		);

		verify(this.paymentMessageConsumeMapper).toPayment(new PaymentCreateMessageBuilder().build(3).getContent());
	}


	@Test
	void when_payment_is_mapped_then_it_is_created() {
		when(this.paymentMessageConsumeMapper.toPayment(any())).thenReturn(new PaymentBuilder().build(3));

		this.listener.handleUserCreatedMessage(
			new PaymentCreateMessageBuilder().build(3)
		);

		verify(this.paymentCreateUseCase).execute(new PaymentBuilder().build(3));
	}

}