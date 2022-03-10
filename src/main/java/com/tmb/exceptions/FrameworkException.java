package com.tmb.exceptions;

@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(String message, Throwable e) {
		super(message, e);
	}
}
