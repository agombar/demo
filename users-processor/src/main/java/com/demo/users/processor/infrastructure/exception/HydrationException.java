package com.demo.users.processor.infrastructure.exception;

public class HydrationException extends Exception {

	public HydrationException(String message, Throwable e) {
		super(message, e);
	}

}