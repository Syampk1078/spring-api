package com.example.demo.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupApi {
	
	@NotNull( message = "Name is required" )
	@NotBlank( message = "Name field is blank" )
	private String name;
	
	@NotBlank( message = "Email field is blank" )
	@NotNull( message = "Email is required" )
	@Pattern
	(
		regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
        message = "Invalid email format"
	)
	private String email;
	
	private long mobile;
	
	
	@NotBlank( message = "Password field is blank" )
	@Size(min = 8, message = "size minimum 8")
	private String password;
}
