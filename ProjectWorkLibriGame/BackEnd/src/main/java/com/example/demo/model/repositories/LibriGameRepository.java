package com.example.demo.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LibriGame;
import com.example.demo.model.enums.Genre;

public interface LibriGameRepository extends CrudRepository<LibriGame, Integer> {
	List<LibriGame> findByGenre(Genre genre);

}
