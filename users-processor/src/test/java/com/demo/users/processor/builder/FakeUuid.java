package com.demo.users.processor.builder;

import java.util.UUID;

public class FakeUuid {

	public static UUID uuid(int index) {
		return UUID.fromString(String.format("6a1beabe-1550-4235-874a-%012d", index));
	}

}

