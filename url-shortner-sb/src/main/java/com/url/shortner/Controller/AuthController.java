package com.url.shortner.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.shortner.dtos.LoginRequest;
import com.url.shortner.dtos.RegisterRequest;
import com.url.shortner.models.User;
import com.url.shortner.service.UserSevice;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	public UserSevice userSevice;
	
	@PostMapping("/public/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest ){ 
		
		return ResponseEntity.ok(userSevice.authenticateUser(loginRequest));
	}
	
	@PostMapping("/public/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest ){
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		user.setRole("ROLE_USER");
		userSevice.registerUser(user);
		return ResponseEntity.ok("User registered successfully");
		
		
	}

}
