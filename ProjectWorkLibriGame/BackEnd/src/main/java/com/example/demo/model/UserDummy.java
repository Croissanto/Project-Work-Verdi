package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class UserDummy {

	

	@Id
	@SequenceGenerator(
			name = "user_sequence", 
			sequenceName ="user_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private int id;
	private String username;
	
	public UserDummy() {
		
	}
	
	public UserDummy(int id, String username) {
		this.id = id;
		this.username = username;
	}

	public UserDummy(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDummy [id=" + id + ", username=" + username + "]";
	}
	
	
}
