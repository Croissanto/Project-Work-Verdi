package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.repositories.UserRepository;

@RestController
public class UserRestController {

	@Autowired
	private UserRepository userRepo;

	

}
