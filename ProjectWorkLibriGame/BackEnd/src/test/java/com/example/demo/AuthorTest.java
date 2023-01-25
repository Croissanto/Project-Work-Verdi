package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
		Author author = new Author("Antonio", "Talluccio", null,"Rimini");
		assertTrue(repository.save(author) != null);
	}

}
