package com.example.demo;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AccountDTO;
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
			String url1 = "http://localhost:8080/accounts/account/"+response.getBody();
			ResponseEntity<AccountDTO> response1 = restTemplate.getForEntity(url1, AccountDTO.class);
			session.setAttribute(LOGGED_ACCOUNT, response1.getBody());
			return true;
		} else if (response.getBody() >= 0) {
			User newUser = new User(0, response.getBody(), AccountType.USER, "");
			newUser = userRepo.save(newUser);
			session.setAttribute(LOGGED_USER, newUser);
			String url1 = "http://localhost:8080/accounts/account/"+response.getBody();
			ResponseEntity<AccountDTO> response1 = restTemplate.getForEntity(url1, AccountDTO.class);
			session.setAttribute(LOGGED_ACCOUNT, response1.getBody());
			return true;
		}
		return false;
	}

	@Override
	public boolean logout() {
		Object user = session.getAttribute(IAccountManagerVerdi.LOGGED_USER);
		Object account = session.getAttribute(IAccountManagerVerdi.LOGGED_ACCOUNT);
		if(user!= null && account != null) {
			session.setAttribute(IAccountManagerVerdi.LOGGED_ACCOUNT, null);
			session.setAttribute(IAccountManagerVerdi.LOGGED_USER, null);
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

	@Override
	public boolean create(String username, String password, String name, String surname, String email) {
		AccountDTO tmp = new AccountDTO(username,password,name,surname,email);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/accounts";
		ResponseEntity<Integer> response = restTemplate.postForEntity(url, tmp, Integer.class);
		if (response.getBody() >= 0) {
			User newUser = new User(0, response.getBody(), AccountType.USER, null);
			newUser = userRepo.save(newUser);
			return true;
		}
		
		return false;
	}
//metodo che restituisce l'user loggato
	// 2 4 USER null
}
