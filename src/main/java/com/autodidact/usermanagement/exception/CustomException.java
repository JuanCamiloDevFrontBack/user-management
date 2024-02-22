package com.autodidact.usermanagement.exception;

/* Mirar si se pueden implementar las clases de tipo record
 * al manejar excepciones. */
public class CustomException extends RuntimeException {
	
	public CustomException(String message) {
		super(message);
	}
	
}
