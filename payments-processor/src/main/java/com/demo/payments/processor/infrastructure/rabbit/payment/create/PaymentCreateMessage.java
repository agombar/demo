package com.demo.payments.processor.infrastructure.rabbit.payment.create;

import com.demo.payments.processor.infrastructure.rabbit.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentCreateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final PaymentContentCreateMessage content;

}
