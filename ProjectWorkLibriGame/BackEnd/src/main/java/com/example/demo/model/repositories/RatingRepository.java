package com.example.demo.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LibriGame;
import com.example.demo.model.Rating;
import com.example.demo.model.UserDummy;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
	boolean existsRatingByUserAndLibri(UserDummy user,LibriGame libri);
	Optional<Rating> findByUserAndLibri(UserDummy user,LibriGame libri);

}
