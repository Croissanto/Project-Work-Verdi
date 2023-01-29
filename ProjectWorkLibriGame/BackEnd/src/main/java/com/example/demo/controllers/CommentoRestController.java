package com.example.demo.controllers;

import java.sql.Date;
import java.sql.Time;
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

import com.example.demo.dto.CreateCommentoDTO;
import com.example.demo.model.Commento;
import com.example.demo.model.Post;
import com.example.demo.model.UserDummy;
import com.example.demo.model.repositories.CommentoRepository;
import com.example.demo.model.repositories.PostRepository;
import com.example.demo.model.repositories.UserDummyRepository;

@RestController
public class CommentoRestController {
	@Autowired
	private PostRepository repoP;
	@Autowired
	private CommentoRepository repoC;
	@Autowired
	private UserDummyRepository repoU;

	@PostMapping("/createcommento")
	public boolean createCommento(@RequestBody CreateCommentoDTO dto) {
		try {
			Optional<Post> tmp = repoP.findById(dto.getIdPost());
			Post post = new Post();
			if (tmp.isPresent()) {
				post = tmp.get();
			}
			List<Commento> commList = post.getCommento();
			Optional<UserDummy> opt = repoU.findById(dto.getIdUser());
			UserDummy user = new UserDummy();
			if (opt.isPresent()) {

				user = opt.get();
			}
			Date date = Date.valueOf(dto.getDate());
			Time time = Time.valueOf(dto.getTime());
			Commento commento = new Commento(dto.getContenuto(), date, time, user);
			repoC.save(commento);
			commList.add(commento);
			repoP.save(post);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@GetMapping("/getallcommenti")
	public List<Commento> getAllCommenti() {

		Iterable<Commento> it = repoC.findAll();
		List<Commento> list = new LinkedList<>();
		for (Commento commento : it) {
			list.add(commento);
		}
		return list;
	}

	@GetMapping("/getcommentobyid/{id}")
	public Commento getCommentoById(@PathVariable("id") int id) {
		Optional<Commento> opt = repoC.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Commento(id, "", null, null, null);

	}

	@DeleteMapping("/deletecommentobyid/{id}")
	public boolean deleteCommentoByid(@PathVariable("id") int id) {

		try {
			repoC.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
