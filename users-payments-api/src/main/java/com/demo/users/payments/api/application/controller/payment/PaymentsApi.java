package com.demo.users.payments.api.application.controller.payment;

import com.demo.users.payments.api.application.controller.payment.response.PaymentResponse;
import com.demo.users.payments.api.application.controller.response.Response;
import com.demo.users.payments.api.application.controller.response.error.ErrorResponse;
import com.demo.users.payments.api.domain.model.Search;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PaymentsApi {

	@Operation(
		summary = "Get payment",
		description = "Get payment",
		operationId = "getPayment",
		tags = "User")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Payment detail have been returned successfully"),
		@ApiResponse(responseCode = "404", description = "Payment not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<Response<PaymentResponse>> getPayment(
		@Parameter(name = "id", description = "Payment id", required = true) UUID id
	);

	@Operation(
		summary = "Search payments by user",
		description = "Get payments searched",
		operationId = "getUsers",
		tags = "User")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Payments detail have been returned successfully"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<Search<PaymentResponse>> getPaymentsByUser(
		@Parameter(name = "size", description = "page size", required = true) int size,
		@Parameter(name = "page", description = "page number", required = true) int page,
		@Parameter(name = "userId", description = "User id", required = true) UUID id
	);

}
