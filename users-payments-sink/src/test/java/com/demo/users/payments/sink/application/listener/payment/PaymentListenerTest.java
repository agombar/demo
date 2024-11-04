package com.demo.users.payments.sink.application.listener.payment;

import com.demo.users.payments.sink.application.listener.payment.create.PaymentCreateMessageBuilder;
import com.demo.users.payments.sink.application.listener.payment.mapper.PaymentMessageMapper;
import com.demo.users.payments.sink.domain.exception.ResourceCreateException;
import com.demo.users.payments.sink.domain.model.PaymentBuilder;
import com.demo.users.payments.sink.domain.repository.PaymentRepository;
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
	private PaymentRepository paymentRepository;

	@Mock
	private PaymentMessageMapper paymentMessageMapper;

	@Test
	void when_values_are_given_then_they_are_mapped() {
		this.listener.handleUserCreatedMessage(
			new PaymentCreateMessageBuilder().build(3)
		);

		verify(this.paymentMessageMapper).toPayment(new PaymentCreateMessageBuilder().build(3).getContent());
	}


	@Test
	void when_payment_is_mapped_then_it_is_created() throws ResourceCreateException {
		when(this.paymentMessageMapper.toPayment(any())).thenReturn(new PaymentBuilder().build(3));

		this.listener.handleUserCreatedMessage(
			new PaymentCreateMessageBuilder().build(3)
		);

		verify(this.paymentRepository).create(new PaymentBuilder().build(3));
	}

}