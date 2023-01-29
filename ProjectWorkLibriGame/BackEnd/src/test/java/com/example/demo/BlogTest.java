package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Blog;
import com.example.demo.model.Post;
import com.example.demo.model.repositories.BlogRepository;

@SpringBootTest
class BlogTest {
	
	@Autowired
	private BlogRepository repo;

	@Test
	public void createBlog() {
		/*
		 * List<Post> idSium = new LinkedList<>(); Blog blog = new
		 * Blog("Forza Giuve","CR7MIOPADRE", idSium); assertNotNull(repo.save(blog))
		 */;
		//repo.delete(blog);
	}
	
	
}
