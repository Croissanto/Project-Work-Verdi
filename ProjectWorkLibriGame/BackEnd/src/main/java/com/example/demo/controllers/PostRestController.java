package com.example.demo.controllers;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreatePostDTO;
import com.example.demo.model.Blog;
import com.example.demo.model.Commento;
import com.example.demo.model.Post;
import com.example.demo.model.Reazione;
import com.example.demo.model.UserDummy;
import com.example.demo.model.repositories.BlogRepository;
import com.example.demo.model.repositories.PostRepository;
import com.example.demo.model.repositories.UserDummyRepository;

@RestController
public class PostRestController {

	@Autowired
	private BlogRepository blogRepo;

	@Autowired
	private UserDummyRepository userDummyRepo;

	@Autowired
	private PostRepository postRepo;

	@PostMapping("/createpost")
	public boolean createPost(@RequestBody CreatePostDTO dto) {
		try {
			Optional<Blog> tmp = blogRepo.findById(dto.getBlogId());
			Blog blog = new Blog();
			if (tmp.isPresent()) {
				blog = tmp.get();
			}
			List<Post> postList = blog.getListaDeiPost();
			List<Commento> list = new LinkedList<>();
			List<Reazione> reactList = new LinkedList<>();
 			Optional<UserDummy> opt = userDummyRepo.findById(dto.getIdUser());
			UserDummy user = new UserDummy();
			if (opt.isPresent()) {

				user = opt.get();
			}
			Date date = Date.valueOf(dto.getDate());
			Time time = Time.valueOf(dto.getTime());
			Post post = new Post(user, dto.getTitolo(), dto.getContenuto(), date, time, reactList, list);
			postRepo.save(post);
			postList.add(post);
			blogRepo.save(blog);
			return true;

		} catch (Exception e) {

			return false;
		}
	}

	// commlist sta per lista di commenti
	@GetMapping("/getcommlist/{id}")
	public List<Commento> getCommList(@PathVariable("id") int id) {
		Optional<Post> tmp = postRepo.findById(id);
		Post post = new Post();
		if (tmp.isPresent()) {
			post = tmp.get();
			return post.getCommento();
		}
		return null;
	}
	
	@GetMapping("/getreactlist/{id}")
	public List<Reazione> getReactList(@PathVariable("id") int id) {
		Optional<Post> tmp = postRepo.findById(id);
		Post post = new Post();
		if (tmp.isPresent()) {
			post = tmp.get();
			return post.getReazione();
		}
		return null;
	}
	
	
	@GetMapping("/getAllOrderByDateAndTime")
	public List<Post> getAll () {
		Iterable<Post> tmp = postRepo.findTop2ByOrderByDateDescTimeDesc();
		List<Post> postList = new LinkedList<>();
		for (Post post : tmp) {
			postList.add(post);
		}
		return postList;
	}
}
