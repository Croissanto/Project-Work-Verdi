package com.example.demo.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.IMostRated;
import com.example.demo.model.LibriGame;
import com.example.demo.model.Rating;
import com.example.demo.model.User;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

	boolean existsRatingByUserAndLibri(User user,LibriGame libri);
	Optional<Rating> findByUserAndLibri(User user,LibriGame libri);
	

	Iterable<Rating> findByUserOrderByStarDesc(User user);
     @Procedure("most_rated")
     List<IMostRated> avg();
     
	
}
