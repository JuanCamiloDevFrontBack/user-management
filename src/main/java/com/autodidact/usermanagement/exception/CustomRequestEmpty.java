package com.autodidact.usermanagement.exception;

public class CustomRequestEmpty extends RuntimeException {
	
	private String errorCampo;
	
	public CustomRequestEmpty(String message, String errorCampo) {
		super(message);
		this.errorCampo = errorCampo;
	}
	
	public String getErrorCampo() {
		return this.errorCampo;
	}	
}
