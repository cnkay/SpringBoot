package com.cenkay.staj.service.exception;

public class BusinessRuleException extends RuntimeException {

	private static final long serialVersionUID = 4123755609913243250L;
	private String message;

	public BusinessRuleException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
