package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.SignupApi;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {
	
	 	@Autowired
	    UserRepository repo;

	
		public Map<String, Object> addUser(SignupApi signUpApi) {
	        Map<String, Object> response = new HashMap<>();
	        
	        Optional<User> res = repo.findByEmail(signUpApi.getEmail());
	        
	        if (res.isEmpty()) {
	            User user = new User();
	            user.setName(signUpApi.getName());
	            user.setEmail(signUpApi.getEmail());
	            user.setMobile(signUpApi.getMobile());
	            user.setPassword(signUpApi.getPassword());
	            repo.save(user);
	            
	            response.put("status", "success");
	            response.put("user", user);
	        } else {
	            response.put("status", "error");
	            response.put("message", "User already exists");
	        }
	        
	        return response;
	}
	
	
}
