package com.cenkay.staj.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cenkay.staj.service.exception.BusinessRuleException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(value = BusinessRuleException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public void runtimeExceptionHandler(BusinessRuleException exception) {

	}
}
