package com.example.demo.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.IMostRated;
import com.example.demo.model.LibriGame;
import com.example.demo.model.Rating;
import com.example.demo.model.UserDummy;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
	boolean existsRatingByUserAndLibri(UserDummy user,LibriGame libri);
	Optional<Rating> findByUserAndLibri(UserDummy user,LibriGame libri);
	Iterable<Rating> findByOrderByStarDesc();
     @Procedure("most_rated")
     List<IMostRated> avg();
     
	
}
