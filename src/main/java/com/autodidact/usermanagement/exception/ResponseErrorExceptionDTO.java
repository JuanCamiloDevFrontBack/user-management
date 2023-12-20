package com.autodidact.usermanagement.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ResponseErrorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;
	
}
