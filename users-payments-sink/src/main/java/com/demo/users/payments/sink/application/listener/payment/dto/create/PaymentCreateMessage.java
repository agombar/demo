package com.demo.users.payments.sink.application.listener.payment.dto.create;

import com.demo.users.payments.sink.application.listener.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentCreateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final PaymentContentCreateMessage content;

}
