package com.autodidact.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {
	
	/* Nota: aquí se pueden especificar las excepciones generales
	 * de cualquier tipo que sucedan en toda la aplicación,
	 * como las de sql, nofound, entre otras.*/

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ResponseErrorDTO> handleExceptionNotFound(CustomException exception) {
		
		var customError = ResponseErrorDTO
				.builder()
				.message((String) exception.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.build();
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(customError);
		
	}
	
}
