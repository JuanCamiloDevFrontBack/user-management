package com.autodidact.usermanagement.module.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping
	public ResponseEntity<Map<String, String>> requestLoginUser(@RequestBody String user) {
		System.out.println("post user: " + user);
		 Map<String, String> map = new HashMap<>();
		  map.put("user", user);
		/* Opción # 1
		 * return new ResponseEntity<>(map, HttpStatus.OK);
		 * */
		// Opción # 2
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
}
