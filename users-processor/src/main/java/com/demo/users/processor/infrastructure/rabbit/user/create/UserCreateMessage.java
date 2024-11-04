package com.demo.users.processor.infrastructure.rabbit.user.create;

import com.demo.users.processor.infrastructure.rabbit.header.MessageHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCreateMessage {

	@JsonProperty("header")
	private final MessageHeader header;

	@JsonProperty("content")
	private final UserContentCreateMessage content;

}
