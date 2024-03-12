package com.autodidact.usermanagement.exception;

public class CustomException {

	public static CustomException.RecordsNotFound msgNotFound(String msg) {
		return new RecordsNotFound(msg);
	}
	
	public static CustomException.RequestEmpty msgRequestEmpty(String msg, String fieldClassError) {
		return new RequestEmpty(msg, fieldClassError);
	}

	/* Clases Manejadoras de Excepciones Presonalizadas :) */
	public static class RecordsNotFound extends RuntimeException {

		private String message;

		public RecordsNotFound(String message) {
			super(message);
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}

	public static class RequestEmpty extends RuntimeException {

		private String fieldReqError;

		public RequestEmpty(String message, String fieldReqError) {
			super(message + " --- " + fieldReqError);
			// utilizar map o una list
			this.fieldReqError = fieldReqError;
		}

		public String getFieldError() {
			return this.fieldReqError;
		}
	}

}
