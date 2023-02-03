package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.IAccountManagerVerdi;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.LocalAccountDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
	
	
	@Autowired
	private IAccountManagerVerdi accountManager;
	@Autowired
	private HttpSession session;
	
	@PostMapping("/login")
	public User tryToLogin (@RequestBody LoginDTO dto) {
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
	
	@PostMapping("/create")
	public boolean create(@RequestBody AccountDTO dto) {
		boolean createAccount = accountManager.create(dto.getUsername(),dto.getPassword(),dto.getName(),dto.getSurname(),dto.getEmail());
		if(createAccount) {
			System.out.println("Ho creato l'account?");
			return true;
		}
		
		return false;
	}
	
	@GetMapping("/userInSession")
	public User getUserInSession() {
		System.out.println(session.getAttribute(IAccountManagerVerdi.LOGGED_USER));
		return (User) session.getAttribute(IAccountManagerVerdi.LOGGED_USER); 
	}
	
	@GetMapping("/accountInSession")
	public LocalAccountDTO getAccountInSession() {
		AccountDTO acc = (AccountDTO) session.getAttribute(IAccountManagerVerdi.LOGGED_ACCOUNT);
		System.out.println((AccountDTO )session.getAttribute(IAccountManagerVerdi.LOGGED_ACCOUNT));
		return new LocalAccountDTO(acc.getUsername(),acc.getName(),acc.getSurname(),acc.getEmail()); 
	}
	
	@GetMapping("/logout")
	public boolean logout() {
		return accountManager.logout();
	}
	
	@GetMapping("/findAccount/{id}")
	public LocalAccountDTO findAccountById(@PathVariable int id) {
		return accountManager.findAccountById(id);
	}
}
