package com.autodidact.usermanagement.module.login.dto;

import java.io.Serializable;

public record LoginDTORes(String token, Boolean isLoggedIn) implements Serializable {
	
	public LoginDTORes(String token, Boolean isLoggedIn) {
		this.token = token;
		this.isLoggedIn = isLoggedIn;
	}
	
}
