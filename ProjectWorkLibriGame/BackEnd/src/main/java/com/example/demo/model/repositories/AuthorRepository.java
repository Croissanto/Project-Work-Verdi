package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
