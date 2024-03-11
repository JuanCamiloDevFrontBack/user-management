package com.autodidact.usermanagement.module.login.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autodidact.usermanagement.module.login.dto.LoginDTOReq;
import com.autodidact.usermanagement.module.login.dto.LoginDTORes;
import com.autodidact.usermanagement.module.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginS;
	
	@GetMapping("/welcome-msg")
	public ResponseEntity<Map<String, String>> welcomeUrl() {
		var msg = new HashMap<String, String>();
		msg.put("Bienvenido", "Ahora puedes levantar el proyecto front y consumir esta API.");
		msg.put("RepoFront", "https://github.com/JuanCamiloDevFrontBack/user-management-front");
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/test")
	public ResponseEntity<LoginDTORes> requestLoginUserTest(@RequestBody LoginDTOReq user) {
		/*
		 * user1: Martha123@gmail.com -- pass: 98765432
		 * user2: admin@autodidact.com -- pass: 12345678
		 * */
		return new ResponseEntity<>(this.loginS.accesValidTest(user), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<LoginDTORes> requestLoginUser(@RequestBody LoginDTOReq user) {
		return new ResponseEntity<>(this.loginS.accesValid(user), HttpStatus.OK);
	}
	
}
