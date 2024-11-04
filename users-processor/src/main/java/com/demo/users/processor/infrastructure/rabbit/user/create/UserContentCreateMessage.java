package com.demo.users.processor.infrastructure.rabbit.user.create;

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
