package com.example.demo.dto;

public class AccountDTO{
	
	private String username;
	private String encryptedPassword;
	private String name;
	private String surname;
	private String email;
	
	public AccountDTO() {
		
	}

	public AccountDTO(String username, String encryptedPassword, String name, String surname, String email) {
		this.username = username;
		this.encryptedPassword = encryptedPassword;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return encryptedPassword;
	}

	public void setPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
