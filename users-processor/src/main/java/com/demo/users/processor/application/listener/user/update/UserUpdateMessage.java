package com.demo.users.processor.application.listener.user.update;

import com.demo.users.processor.application.listener.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserUpdateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final UserContentUpdateMessage content;

}
