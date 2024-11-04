package com.demo.users.payments.api.application.controller.payment.response;

import com.demo.users.payments.api.application.controller.user.response.UserResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class PaymentResponse {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("amount")
	private BigDecimal amount;

	@JsonProperty("paymentDate")
	private LocalDateTime paymentDate;

	@JsonProperty("user")
	private UserResponse user;

}
