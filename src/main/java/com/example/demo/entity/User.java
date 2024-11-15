package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "user_id" )
	public int id;
	
	public String name;
	public String email;
	public long mobile;
	public String password;
	
	private LocalDateTime createdOn = LocalDateTime.now();
	private boolean isActive = true;
	private boolean isEmailVerified = false;
	
}

