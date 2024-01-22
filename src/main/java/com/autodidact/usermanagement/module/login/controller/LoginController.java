package com.autodidact.usermanagement.module.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autodidact.usermanagement.module.login.dto.LoginDTOReq;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping
	// LoginDTORes
	public ResponseEntity<LoginDTOReq> requestLoginUser(@RequestBody LoginDTOReq user) {
		System.out.println("post user: " + user);
		var userDetails = new LoginDTOReq(user.user(), user.password());
		/* Opción # 1
		 * return new ResponseEntity<>(userDetails, HttpStatus.OK);
		 * */
		// Opción # 2
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
	
}
