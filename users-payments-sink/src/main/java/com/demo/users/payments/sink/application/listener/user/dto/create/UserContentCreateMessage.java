package com.demo.users.payments.sink.application.listener.user.dto.create;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserContentCreateMessage {

	private UUID id;
	private String username;
	private String email;

}
