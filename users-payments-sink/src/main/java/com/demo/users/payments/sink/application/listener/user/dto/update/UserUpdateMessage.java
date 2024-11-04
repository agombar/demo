package com.demo.users.payments.sink.application.listener.user.dto.update;

import com.demo.users.payments.sink.application.listener.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserUpdateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final UserContentUpdateMessage content;

}
