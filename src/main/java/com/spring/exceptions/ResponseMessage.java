package com.spring.exceptions;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6441912769850355124L;

	private String responseMessage;

	public ResponseMessage(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
