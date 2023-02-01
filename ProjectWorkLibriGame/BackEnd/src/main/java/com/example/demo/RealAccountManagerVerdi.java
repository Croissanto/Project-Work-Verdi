package com.example.demo;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.LoginDTO;
import com.example.demo.model.User;
import com.example.demo.model.enums.AccountType;
import com.example.demo.model.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

public class RealAccountManagerVerdi implements IAccountManagerVerdi {

	private HttpSession session;
	private UserRepository userRepo;
	// private AdminRepository adminRepo;

	/*
	 * public RealAccountManagerVerdi() {
	 * 
	 * }
	 */
	public RealAccountManagerVerdi(HttpSession session, UserRepository userRepo) {
		this.session = session;
		this.userRepo = userRepo;
	}

	@Override
	public boolean login(String user, String password) {
		// TODO Auto-generated method stub
		LoginDTO dto = new LoginDTO(user, password);
		// fetch
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/accounts/login";
		ResponseEntity<Integer> response = restTemplate.postForEntity(url, dto, Integer.class);

		Optional<User> opt = userRepo.findByIdAccount(response.getBody());
		if (opt.isPresent()) {
			session.setAttribute(LOGGED_USER, opt.get());
			return true;
		} else if (response.getBody() >= 0) {
			User newUser = new User(0, response.getBody(), AccountType.USER, "");
			newUser = userRepo.save(newUser);
			session.setAttribute(LOGGED_USER, newUser);
			return true;
		}
		return false;
	}

	@Override
	public boolean logout() {
		Object account = session.getAttribute(LOGGED_USER);
		if (account != null) {
			session.removeAttribute(LOGGED_USER);
			return true;
		}
		return false;
	}

	@Override
	public boolean isAdmin() {
		Object loggedUser = session.getAttribute(LOGGED_USER);
		if (loggedUser != null && loggedUser instanceof User) {
			if (((User) loggedUser).getType() == AccountType.ADMIN) {
				return true;

			}
		}
		return false;
	}

	@Override
	public boolean isUser() {
		Object loggedUser = session.getAttribute(LOGGED_USER);
		if (loggedUser != null && loggedUser instanceof User) {
			if (((User) loggedUser).getType() == AccountType.USER) {
				return true;

			}
		}
		return false;
	}

	@Override
	public boolean isLogged() {
		return session.getAttribute(LOGGED_USER) != null;
	}

}
