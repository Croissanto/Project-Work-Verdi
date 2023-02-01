package com.example.demo;

public interface IAccountManagerVerdi {
	
	public static String LOGGED_USER = "account_logged_user";
	
	boolean login(String user,String password);
	
	boolean logout();
	
	boolean isAdmin();
	
	boolean isUser();
	
	boolean isLogged();
}
