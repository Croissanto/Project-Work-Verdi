package com.example.demo.dto;

import com.example.demo.model.enums.AccountType;

public class LoggedDTO {
	private boolean logged;
	private String username;
	private AccountType type;
	
	public LoggedDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoggedDTO(boolean logged, String username, AccountType type) {
		this.logged = logged;
		this.username = username;
		this.type = type;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}
	
	
}
