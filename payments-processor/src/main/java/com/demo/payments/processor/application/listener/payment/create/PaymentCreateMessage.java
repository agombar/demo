package com.demo.payments.processor.application.listener.payment.create;

import com.demo.payments.processor.application.listener.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentCreateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final PaymentContentCreateMessage content;

}
