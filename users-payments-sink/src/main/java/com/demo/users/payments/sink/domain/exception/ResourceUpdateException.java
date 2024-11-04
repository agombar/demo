package com.demo.users.payments.sink.domain.exception;

public class ResourceUpdateException extends Exception {

	public ResourceUpdateException(Throwable cause) {
		super(cause);
	}

	public ResourceUpdateException(String message) {
		super(message);
	}

	public ResourceUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

}
