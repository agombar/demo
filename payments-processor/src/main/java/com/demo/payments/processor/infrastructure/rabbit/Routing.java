package com.demo.payments.processor.infrastructure.rabbit;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Routing {

	private final String exchange;
	private final String routingKey;

	public Routing resolve() {
		return new Routing(
			this.exchange,
			this.routingKey
		);
	}

}
