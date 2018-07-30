package com.cenkay.staj.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.cenkay.staj.service.exception.BusinessRuleException;

@ControllerAdvice
public class GlobalControllerAdvice extends Throwable {

	private static final long serialVersionUID = 8876900866425575445L;

	@ExceptionHandler(value = BusinessRuleException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public void runtimeException409(BusinessRuleException exception) {

	}

	@ExceptionHandler(value = HttpClientErrorException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public void runtimeException404(HttpClientErrorException exception) {

	}

}
