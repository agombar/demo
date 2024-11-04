package com.demo.users.payments.sink.domain.exception;

public class ResourceCreateException extends Exception {

	public ResourceCreateException(String message) {
		super(message);
	}

	public ResourceCreateException(String message, Throwable cause) {
		super(message, cause);
	}

}
