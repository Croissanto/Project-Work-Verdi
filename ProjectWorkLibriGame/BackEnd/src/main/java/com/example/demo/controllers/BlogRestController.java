package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateBlogDTO;
import com.example.demo.model.Author;
import com.example.demo.model.Blog;
import com.example.demo.model.Post;
import com.example.demo.model.repositories.BlogRepository;

@RestController
public class BlogRestController {
	
	@Autowired
	private BlogRepository blogRepo;
	
	@PostMapping("/createBlog")
	public boolean createBlog(@RequestBody CreateBlogDTO dto) {
		try {
			List<Post> idPost = new LinkedList<>();
			Blog crBlog = new Blog(dto.getTitolo(), dto.getTema(), idPost);
			blogRepo.save(crBlog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("/blog/{id}")
	public Blog blogById(@PathVariable int id) {
		Optional<Blog> tmp = blogRepo.findById(id);
		Blog blog = new Blog();
		if(tmp.isPresent()) {
			blog = tmp.get();
		}
		return blog;
	}
	
	@GetMapping("/allblog")
	public List<Blog> getAll (){
		Iterable<Blog> tmp = blogRepo.findAll();
		List<Blog> blogList = new LinkedList<>();
		for (Blog blog : tmp) {
			blogList.add(blog);
		}
		return blogList;
	}

	@GetMapping("/getpostlist/{id}")
	public List<Post> getPostList(@PathVariable("id") int id) {
		Optional<Blog> tmp = blogRepo.findById(id);
		Blog blog = new Blog();
		if(tmp.isPresent()) {
			blog = tmp.get();
			return blog.getListaDeiPost();
		}
		return null;
	}
}
