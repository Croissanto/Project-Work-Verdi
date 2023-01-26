package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.CreatePostDTO;
import com.example.demo.model.Commento;

import com.example.demo.model.Post;
import com.example.demo.model.UserDummy;
import com.example.demo.model.repositories.PostRepository;
import com.example.demo.model.repositories.UserDummyRepository;

@RestController
public class PostRestController {

	@Autowired
	private UserDummyRepository userDummyRepo;

	@Autowired
	private PostRepository postRepo;

	@PostMapping("/createpost")
	public boolean createPost(@RequestBody CreatePostDTO dto) {
		try {
			List<Commento> list = new LinkedList<>();
			Optional<UserDummy> opt = userDummyRepo.findById(dto.getIdUser());
			UserDummy user = new UserDummy();
			if (opt.isPresent()) {

				user = opt.get();
			}

			Post post = new Post(user, dto.getContenuto(), dto.getLink(), dto.getDate(), dto.getTime(), list);
			postRepo.save(post);
			return true;

		} catch (Exception e) {

			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	

}
