package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateLibriGameDTO;
import com.example.demo.model.Author;
import com.example.demo.model.Gallery;
import com.example.demo.model.LibriGame;
import com.example.demo.model.repositories.AuthorRepository;
import com.example.demo.model.repositories.GalleryRepository;
import com.example.demo.model.repositories.LibriGameRepository;


@RestController
public class LibriGameRestController {

	@Autowired
	private AuthorRepository repoA;
	@Autowired
	private LibriGameRepository repoL;
	@Autowired
	private GalleryRepository repoG;
	

	@PostMapping("/createlibrogame")
	public boolean createLibroGame(@RequestBody CreateLibriGameDTO dtoLibro) {
		try {
			Optional<Author> opt = repoA.findById(dtoLibro.getIdAutore());
			Author author = new Author();
			if (opt.isPresent()) {
				author = opt.get();
			}
			LibriGame libroGame = new LibriGame(dtoLibro.getTitle(), author, dtoLibro.getPublisher(),
					dtoLibro.getAnnoDiPubblicazione(), dtoLibro.getGenre());
			repoL.save(libroGame);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	@GetMapping("/getalllibrigame")
	public List<LibriGame> getAllLibriGame() {
		Iterable<LibriGame> it = repoL.findAll();
		List<LibriGame> list = new LinkedList<>();
		for (LibriGame libriGame : it) {
			list.add(libriGame);
		}
		return list;
	}

	@GetMapping("/getlibrogamebyid/{id}")
	public LibriGame getLibroGameById(@PathVariable("id") int id) {
		Optional<LibriGame> opt = repoL.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new LibriGame(id, null);

	}

	@DeleteMapping("deletelibrogamebyid/{id}")
	public boolean deleteLibroGameById(@PathVariable("id") int id) {

		try {
			repoL.deleteById(id);
			return true;
		} catch (Exception e) {

			return false;

		}

	}

	@GetMapping("/getlibrigamebygalleryid/{id}")
	public List<LibriGame> getLibriGameByGalleryId(@PathVariable("id") int id) {
		Optional<Gallery> opt = repoG.findById(id);
		Gallery gallery = new Gallery();
		if (opt.isPresent()) {

			gallery = opt.get();
		}
		
            List<LibriGame> list= gallery.getLibriGame();
		    return list;
	}
	
	

}
