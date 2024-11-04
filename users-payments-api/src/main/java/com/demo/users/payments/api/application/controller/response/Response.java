package com.demo.users.payments.api.application.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Response<T> {

	@Valid
	@NotNull
	@JsonProperty("content")
	private final T content;

	@JsonCreator
	public Response(
		@JsonProperty("content") T content
	) {
		this.content = content;
	}

}
