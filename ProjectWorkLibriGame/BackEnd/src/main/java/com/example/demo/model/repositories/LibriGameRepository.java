package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LibriGame;
import com.example.demo.model.Rating;

public interface LibriGameRepository extends CrudRepository<LibriGame, Integer> {

	
	
}
