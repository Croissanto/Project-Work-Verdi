package com.example.demo.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LibriGame;
import com.example.demo.model.Rating;
import com.example.demo.model.User;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
	boolean existsRatingByUserAndLibri(User user,LibriGame libri);
	Optional<Rating> findByUserAndLibri(User user,LibriGame libri);
	
	Iterable<Rating> findByOrderByStarDesc();

}
