package com.example.demo.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Blog;
import com.example.demo.model.Post;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
	
	Optional<Blog> findById(int id);
	
	
}
