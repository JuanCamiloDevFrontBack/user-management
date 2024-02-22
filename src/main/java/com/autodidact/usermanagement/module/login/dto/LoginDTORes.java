package com.autodidact.usermanagement.module.login.dto;

import java.io.Serializable;

public record LoginDTORes(String token, boolean isLoggedIn) implements Serializable {
	
}
