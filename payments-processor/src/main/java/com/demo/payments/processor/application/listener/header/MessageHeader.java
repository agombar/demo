package com.demo.payments.processor.application.listener.header;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageHeader {

	@JsonProperty("objectName")
	private final String objectName;

	@JsonProperty("version")
	private final Integer version;

	@JsonProperty("createdAt")
	private final String createdAt;

}
