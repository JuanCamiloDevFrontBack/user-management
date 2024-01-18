package com.autodidact.usermanagement.module.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-features")
@CrossOrigin(origins = {"*"})
public record UserController() {

}