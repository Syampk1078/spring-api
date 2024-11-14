package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.SignupApi;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	@Autowired
	AuthService service;
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://127.0.0.1:5501")
	public ResponseEntity<Map<String, Object>> signup(@Valid @RequestBody SignupApi signupData, BindingResult result) {
		System.out.println("Respond");
		HashMap<String, Object> response = new HashMap<>();
		
		  if (result.hasErrors()) {
			  response.put("status", "failed");
		        Map<String, String> errors = new HashMap<String, String>();
		        result.getFieldErrors().forEach(fieldError ->{
		        	errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		        });
		        response.put("errors", errors);  // List of all error messages
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		    }		
		 Object user = service.addUser(signupData);
	        response.put("status", "success");
	        response.put("data", user);
	        response.put("message", "User signed up successfully.");
	        return ResponseEntity.ok(response);
	}
}
