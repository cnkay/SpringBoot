package com.cenkay.staj.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class HttpErrorException extends HttpClientErrorException{
	public HttpErrorException(HttpStatus statusCode) {
		super(statusCode);
		// TODO Auto-generated constructor stub
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
