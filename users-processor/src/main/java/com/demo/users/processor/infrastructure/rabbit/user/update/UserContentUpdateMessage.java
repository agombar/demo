package com.demo.users.processor.infrastructure.rabbit.user.update;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserContentUpdateMessage {

	private UUID id;
	private String username;
	private String email;

}
