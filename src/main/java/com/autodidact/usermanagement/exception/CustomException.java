package com.autodidact.usermanagement.exception;

/* Mirar si se pueden implementar las clases de tipo record
 * al manejar excepciones. */
public class CustomException extends RuntimeException {
	
	private String message;
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public CustomException.CustomRequestEmpty msgCustomRequestEmpty(String msg) {
		return new CustomRequestEmpty(this.getMessage(), msg);
	}
	
	public class CustomRequestEmpty extends RuntimeException {
		
		private String errorCampo;
		
		public CustomRequestEmpty(String message, String errorCampo) {
			super(message + " --- " + errorCampo);
			// utilizar map o una list
			this.errorCampo = errorCampo;
		}
		
		public String getErrorCampo() {
			return this.errorCampo;
		}
	}
	
}
