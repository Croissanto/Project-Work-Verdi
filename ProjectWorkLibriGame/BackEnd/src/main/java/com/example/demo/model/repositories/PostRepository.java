package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{
	
	Iterable<Post> findTop2ByOrderByDateDescTimeDesc();
}
