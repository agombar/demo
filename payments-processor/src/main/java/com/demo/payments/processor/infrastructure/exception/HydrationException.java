package com.demo.payments.processor.infrastructure.exception;

public class HydrationException extends Exception {

	public HydrationException(String message, Throwable e) {
		super(message, e);
	}

}