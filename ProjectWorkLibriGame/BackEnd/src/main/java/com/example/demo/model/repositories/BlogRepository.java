package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {

}
