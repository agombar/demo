package com.demo.users.processor.infrastructure.rabbit.user.update;

import com.demo.users.processor.infrastructure.rabbit.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserUpdateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final UserContentUpdateMessage content;

}
