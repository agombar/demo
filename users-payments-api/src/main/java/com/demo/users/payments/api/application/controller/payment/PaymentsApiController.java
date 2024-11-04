package com.demo.users.payments.api.application.controller.payment;

import com.demo.users.payments.api.application.controller.payment.mapper.PaymentResponseMapper;
import com.demo.users.payments.api.application.controller.payment.response.PaymentResponse;
import com.demo.users.payments.api.application.controller.response.Response;
import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Payment;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.repository.PaymentRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsApiController implements PaymentsApi {

	private final PaymentRepository paymentRepository;
	private final PaymentResponseMapper paymentResponseMapper;

	@Override
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<PaymentResponse>> getPayment(@PathVariable("id") UUID id) {
		Optional<Payment> payment = this.paymentRepository.findById(id);

		return payment
			.map(value -> ResponseEntity.ok(new Response<>(this.paymentResponseMapper.toPaymentResponse(value))))
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Override
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Search<PaymentResponse>> getPaymentsByUser(
		@PathParam("size") int size,
		@PathParam("page") int page,
		@PathParam("userId") UUID userId
	) {
		Search<Payment> payments = this.paymentRepository.findByUserId(userId, new Paging(page, size));
		return ResponseEntity.ok(
			new Search<>(
				payments.getContent()
					.stream()
					.map(this.paymentResponseMapper::toPaymentResponse)
					.collect(Collectors.toList()),
				payments.getCurrentPage(),
				payments.getTotalItems(),
				payments.getTotalPages()
			)
		);
	}

}
