package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateUserDummyDTO;
import com.example.demo.model.UserDummy;
import com.example.demo.model.repositories.UserDummyRepository;

@RestController
public class UserDummyRestController {

	@Autowired
	private UserDummyRepository userDummyRepo;

	@PostMapping("/createuserdummy")
	public boolean createAuthor(@RequestBody CreateUserDummyDTO dto) {
		try {
			UserDummy userDummy = new UserDummy(dto.getUsername());
			userDummyRepo.save(userDummy);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	@GetMapping("/getallusers")
	public List<UserDummy> getUsers() {
		List<UserDummy> userlist = new LinkedList<>();
		Iterable<UserDummy> list = userDummyRepo.findAll();
		for (UserDummy user : list) {

			
			userlist.add(user);
			
		}

		return userlist;
	}

}
