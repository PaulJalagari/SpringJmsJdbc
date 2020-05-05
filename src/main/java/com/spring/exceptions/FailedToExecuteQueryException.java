package com.spring.exceptions;

public class FailedToExecuteQueryException extends RuntimeException {

	private static final long serialVersionUID = -5725055899793801738L;

	public static final String FAILED_QUERY = "Could not process your request";

	private String message;;

	public FailedToExecuteQueryException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public FailedToExecuteQueryException() {
		super();
		message = FAILED_QUERY;
	}

	@Override
	public String toString() {
		return message;
	}

}
