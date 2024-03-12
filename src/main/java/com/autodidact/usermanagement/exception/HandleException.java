package com.autodidact.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {
	
	/* TODO: Nota: aquí se pueden especificar las excepciones generales
	 * de cualquier tipo que sucedan en toda la aplicación,
	 * como las de sql, nofound, entre otras.*/

	@ExceptionHandler(CustomException.RecordsNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<ResponseErrorDTO> handleExceptionNotFound(CustomException.RecordsNotFound exception) {
		
		var customError = ResponseErrorDTO
				.builder()
				.message((String) exception.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.build();
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(customError);
		
	}
	
	@ExceptionHandler(CustomException.RequestEmpty.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	protected ResponseEntity<ResponseErrorDTO> handleExceptionReqInputsEmptyInner(CustomException.RequestEmpty exception) {
		
		var customError = ResponseErrorDTO
				.builder()
				.message((String) exception.getMessage())
				//.message((String) exception.getMessage() + exception.getErrorCampo())
				.status(HttpStatus.CONFLICT)
				.build();
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(customError);
		
	}
	
	/* 
	 * TODO: se pone de ejemplo como segunda forma de crear excepciones
	 * personalizadas de manera centralizada.
	*/
	@ExceptionHandler(CustomRequestEmpty.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	protected ResponseEntity<ResponseErrorDTO> handleExceptionReqInputsEmpty(CustomRequestEmpty exception) {
		
		var customError = ResponseErrorDTO
				.builder()
				.message((String) exception.getMessage() + " - " + exception.getErrorCampo())
				.status(HttpStatus.CONFLICT)
				.build();
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(customError);
		
	}
	
}
