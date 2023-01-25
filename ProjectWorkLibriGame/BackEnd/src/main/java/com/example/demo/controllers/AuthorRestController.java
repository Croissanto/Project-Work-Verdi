package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateAuthorDTO;
import com.example.demo.model.Author;
import com.example.demo.model.repositories.AuthorRepository;

@RestController
public class AuthorRestController {
	@Autowired
	private AuthorRepository repository;

	@PostMapping("/createauthor")
	public boolean createAuthor(@RequestBody CreateAuthorDTO dto) {
		try {
			Author author = new Author(dto.getName(), dto.getSurname(), dto.getDataDiNascita(),
					dto.getLuogoDiNascita());
			repository.save(author);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	@GetMapping("/getallauthor")
	public List<Author> getAllAuthor() {

		Iterable<Author> it = repository.findAll();
		List<Author> list = new LinkedList<>();
		for (Author author : it) {
			list.add(author);

		}
		return list;

	}

	@GetMapping("/getauthorbyid/{id}")
	public Author getAuthorById(@PathVariable("id") int id) {
		Optional<Author> opt = repository.findById(id);
		if (opt.isEmpty()) {
			return opt.get();
		}
		return new Author(id, null, null, null, null);

	}

	@DeleteMapping("deleteauthorbyid/{id}")
	public boolean deleteAuthorById(@PathVariable("id") int id) {

		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {

			return false;

		}

	}

}