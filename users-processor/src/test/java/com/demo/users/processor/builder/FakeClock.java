package com.demo.users.processor.builder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FakeClock {

	private final static Map<Integer, LocalDateTime> dateTimeSeeds = new HashMap<>();

	public static LocalDateTime dateTime(int seed) {
		if(!dateTimeSeeds.containsKey(seed)) {
			dateTimeSeeds.put(
				seed,
				LocalDateTime.now()
					.minusSeconds(new Random().nextInt(86400) + 10)
					.plusSeconds(new Random().nextInt(86400) + 10)
			);
		}

		return dateTimeSeeds.get(seed);
	}

}

