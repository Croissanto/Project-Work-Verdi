package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Author;
import com.example.demo.model.repositories.AuthorRepository;
@SpringBootTest
class AuthorTest {
	@Autowired
	private AuthorRepository repository;

	@Test
	public void createAuthor() {
		Author author = new Author("Alberto", "Barroero", null,"TRAPANI");
		assertNotNull(repository.save(author));
	}
	@Test
	public void getAllAuthor() {
		assertNotNull(repository.findAll());
	}
	
	@Test
	public void getAuthorById() {
		
		assertNotNull(repository.findById(1));
		System.out.println(repository.findById(1));
		
		
		
	}
	

}
