package com.example.demo;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.LocalAccountDTO;
import com.example.demo.model.User;

public class DummyAccountManagerVerdi implements IAccountManagerVerdi{

	@Override
	public boolean login(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLogged() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(String username, String password, String name, String surname, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LocalAccountDTO findAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
