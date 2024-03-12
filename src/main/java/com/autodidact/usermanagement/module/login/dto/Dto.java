package com.autodidact.usermanagement.module.login.dto;

import java.io.Serializable;

public record Dto() {
	
	public static LoginRes loginRes(String token, boolean isLoggedIn) {
		return new LoginRes(token, isLoggedIn);
	}

	public record LoginReq(String user, String password) {
		
	}
	
	public record LoginRes(String token, boolean isLoggedIn) implements Serializable {
		
	}
	
}
