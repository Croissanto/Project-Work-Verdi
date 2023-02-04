package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RatingDTO;
import com.example.demo.model.IMostRated;
import com.example.demo.model.LibriGame;
import com.example.demo.model.Rating;
import com.example.demo.model.User;
import com.example.demo.model.repositories.LibriGameRepository;
import com.example.demo.model.repositories.RatingRepository;
import com.example.demo.model.repositories.UserRepository;

import jakarta.transaction.Transactional;

@RestController
public class RatingRestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LibriGameRepository libriRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@PostMapping("/createrating")
	public boolean createRating(@RequestBody RatingDTO dto) {
		try {
			Optional<User> opt = userRepository.findById(dto.getUserId());

			Optional<LibriGame> opt2 = libriRepository.findById(dto.getLibroId());

			User user = new User();

			LibriGame libro = new LibriGame();

			if (opt.isPresent() && opt2.isPresent()) {

				user = opt.get();
				libro = opt2.get();

			}
			boolean exists = ratingRepository.existsRatingByUserAndLibri(user, libro);
			if (!exists) {

				Rating rating = new Rating(dto.getStar(), libro, user);

				ratingRepository.save(rating);

				return true;
			} else {
				// System.out.println("entro");
				Optional<Rating> op3 = ratingRepository.findByUserAndLibri(user, libro);
				Rating newRating = new Rating();
				if (op3.isPresent()) {

					newRating = op3.get();

				}
				newRating.setStar(dto.getStar());
				ratingRepository.save(newRating);

				return true;

			}
		} catch (Exception e) {

			return false;
		}

	}

	@GetMapping("/getlibrigameorderbystar/{id}")
	public List<LibriGame> getLibriGameOrderByStar(@PathVariable("id") int id) {

		Optional<User> opt = userRepository.findById(id);
		if (opt.isPresent()) {

			User user = opt.get();
			Iterable<Rating> it = ratingRepository.findByUserOrderByStarDesc(user);
			List<LibriGame> list = new LinkedList<>();
			for (Rating rating : it) {

				list.add(rating.getLibri());

			}
			return list;
		}

		return new LinkedList<>();
	}

	@GetMapping("/getmostratedlibrogame")
	@Transactional
	public List<IMostRated> getMostRatedLibroGame() {
		List<IMostRated> list = ratingRepository.avg();
		System.out.println("ci sono entrato");
		return list;
	}

	@GetMapping("/getratingbyuser/{idU}")
	public List<Rating> getRating(@PathVariable("idU") int idU) {

		Optional<User> userOpt = userRepository.findById(idU);

		if (userOpt.isPresent()) {

			User user = userOpt.get();

			List<Rating> list = ratingRepository.findByUser(user);

			return list;
		}

		return new LinkedList<>();

	}

	@GetMapping("/getratingbyuserorderedbystar/{idU}")
	public List<Rating> getRatingOrdered(@PathVariable("idU") int idU) {

		Optional<User> userOpt = userRepository.findById(idU);

		if (userOpt.isPresent()) {

			User user = userOpt.get();

			Iterable<Rating> list = ratingRepository.findByUserOrderByStarDesc(user);
			List<Rating> ratings = new LinkedList<>();
			for (Rating rating : list) {
				ratings.add(rating);
			}

			return ratings;
		}
		return new LinkedList<>();
	}

}