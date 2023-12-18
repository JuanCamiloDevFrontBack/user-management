package com.autodidact.usermanagement.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
	/* Mirar si se pueden implementar las clases de tipo record
	 * al manejar excepciones.
	*/
	private String code;
	
	public CustomException(String code, String message) {
		super(message);
		this.code = code;
	}
	
}
