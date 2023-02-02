package com.example.demo;

import com.example.demo.dto.AccountDTO;
import com.example.demo.model.User;

public interface IAccountManagerVerdi {
	
	public static String LOGGED_USER = "account_logged_user";
	public static String LOGGED_ACCOUNT = "account_logged";
	
	boolean login(String user,String password);
	
	boolean logout();
	
	boolean isAdmin();
	
	boolean isUser();
	
	boolean isLogged();
	
	boolean create(String username, String password, String name, String surname, String email);
}
