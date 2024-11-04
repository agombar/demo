package com.demo.users.payments.api.application.controller.payment;

import com.demo.users.payments.api.application.controller.payment.mapper.PaymentResponseMapper;
import com.demo.users.payments.api.application.controller.payment.response.PaymentResponse;
import com.demo.users.payments.api.application.controller.payment.response.PaymentResponseBuilder;
import com.demo.users.payments.api.application.controller.response.Response;
import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.PaymentBuilder;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentsApiControllerTest {

	@InjectMocks
	private PaymentsApiController controller;

	@Mock
	private PaymentRepository paymentRepository;

	@Mock
	private PaymentResponseMapper paymentResponseMapper;

	@Test
	void when_payment_id_is_given_then_it_is_retrieve() {
		this.controller.getPayment(
			FakeUuid.uuid(3)
		);

		verify(this.paymentRepository).findById(FakeUuid.uuid(3));
	}

	@Test
	void when_payment_is_retrieve_then_it_is_mapped() {
		when(this.paymentRepository.findById(any())).thenReturn(Optional.of(new PaymentBuilder().build(3)));

		this.controller.getPayment(
			FakeUuid.uuid(3)
		);

		verify(this.paymentResponseMapper).toPaymentResponse(new PaymentBuilder().build(3));
	}


	@Test
	void when_payment_is_mapped_then_it_is_returned() {
		when(this.paymentRepository.findById(any())).thenReturn(Optional.of(new PaymentBuilder().build(3)));
		when(this.paymentResponseMapper.toPaymentResponse(any())).thenReturn(new PaymentResponseBuilder().build(3));

		ResponseEntity<Response<PaymentResponse>> payment = this.controller.getPayment(
			FakeUuid.uuid(3)
		);

		assertThat(payment.getBody().getContent()).isEqualTo(new PaymentResponseBuilder().build(3));
	}

	@Test
	void when_user_id_is_given_then_payments_retrieve() {
		when(this.paymentRepository.findByUserId(any(), any())).thenReturn(
			new Search<>(
				List.of(new PaymentBuilder().build(3)),
				0,
				1,
				1
			)
		);

		this.controller.getPaymentsByUser(
			1,
			0,
			FakeUuid.uuid(3)
		);

		verify(this.paymentRepository).findByUserId(FakeUuid.uuid(3), new Paging(0, 1));
	}

	@Test
	void when_payments_are_retrieve_then_it_is_mapped() {
		when(this.paymentRepository.findByUserId(any(), any())).thenReturn(
			new Search<>(
				List.of(new PaymentBuilder().build(3)),
				0,
				1,
				1
			)
		);

		this.controller.getPaymentsByUser(
			1,
			0,
			FakeUuid.uuid(3)
		);

		verify(this.paymentResponseMapper).toPaymentResponse(new PaymentBuilder().build(3));
	}


	@Test
	void when_payments_are_mapped_then_it_is_returned() {
		when(this.paymentRepository.findByUserId(any(), any())).thenReturn(
			new Search<>(
				List.of(new PaymentBuilder().build(3)),
				0,
				1,
				1
			)
		);
		when(this.paymentResponseMapper.toPaymentResponse(any())).thenReturn(new PaymentResponseBuilder().build(3));

		ResponseEntity<Search<PaymentResponse>> payment = this.controller.getPaymentsByUser(
			1,
			0,
			FakeUuid.uuid(3)
		);

		assertThat(payment.getBody().getContent()).isEqualTo(List.of(new PaymentResponseBuilder().build(3)));
	}

}