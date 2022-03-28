package com.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

	@ExceptionHandler(LoginException.class)
	public String handle(LoginException ex)	{
		return "error-login";
	}
}
