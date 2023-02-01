package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.IAccountManagerVerdi;
import com.example.demo.dto.LoggedDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
	
	
	@Autowired
	private IAccountManagerVerdi accountManager;
	
	@PostMapping("/login")
	public User tryToLogin (@RequestBody LoginDTO dto, HttpSession session) {
		boolean logged =accountManager.login(dto.getUsername(), dto.getPassword());
		if (logged) {
			if (accountManager.isUser()) {
				System.out.println("Sono un user");
				User user = (User) session.getAttribute(IAccountManagerVerdi.LOGGED_USER);
				return user;
			} else if (accountManager.isAdmin()) {
				System.out.println("Sono un admin");
				User admin = (User) session.getAttribute(IAccountManagerVerdi.LOGGED_USER);
				return admin;
			}
		}
		System.out.println("Non so chi sono");
		return new User();
		
	}
	
	
	
}
