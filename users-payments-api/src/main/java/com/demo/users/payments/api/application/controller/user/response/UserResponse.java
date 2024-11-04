package com.demo.users.payments.api.application.controller.user.response;

import com.demo.users.payments.api.application.controller.payment.response.PaymentResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserResponse {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("username")
	private String username;

	@JsonProperty("email")
	private String email;

	@JsonProperty("payments")
	private List<PaymentResponse> payments;

}
