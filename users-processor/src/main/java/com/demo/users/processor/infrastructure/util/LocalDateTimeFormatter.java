package com.demo.users.processor.infrastructure.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {

	public static final String ISO_8601_STANDARD = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	public String toISO(LocalDateTime localDateTime) {
		return localDateTime.format(DateTimeFormatter.ofPattern(ISO_8601_STANDARD));
	}


}
