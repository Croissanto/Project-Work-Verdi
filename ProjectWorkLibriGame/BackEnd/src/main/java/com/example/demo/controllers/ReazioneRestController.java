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

import com.example.demo.dto.CreateReazioneDTO;

import com.example.demo.model.Post;
import com.example.demo.model.Reazione;
import com.example.demo.model.UserDummy;
import com.example.demo.model.repositories.PostRepository;
import com.example.demo.model.repositories.ReazioneRepository;
import com.example.demo.model.repositories.UserDummyRepository;

@RestController
public class ReazioneRestController {

	@Autowired
	private ReazioneRepository reazioneRepo;
	@Autowired
	private UserDummyRepository userDummyRepo;
	@Autowired
	private PostRepository postRepo;

	@PostMapping("/createreazione")
	public boolean createReazione(@RequestBody CreateReazioneDTO dto) {
		try {
			Optional<UserDummy> opt = userDummyRepo.findById(dto.getIdUser());
			Optional<Post> opt2 = postRepo.findById(dto.getIdPost());
			UserDummy user = new UserDummy();
			Post post = new Post();
			if (opt.isPresent() && opt2.isPresent()) {

				user = opt.get();
				post = opt2.get();

			}

			Reazione reazione = new Reazione(post, user, dto.getUpVote(), dto.getDownVote());
			reazioneRepo.save(reazione);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	@GetMapping("/getreazionebypost/{id}")
	public List<Reazione> getReazioneByPostId(@PathVariable("id") int id) {

		Iterable<Reazione> tmp = reazioneRepo.findByPostId(id);
		List<Reazione> list = new LinkedList<>();
		for (Reazione reazione : tmp) {

			list.add(reazione);
		}
		return list;
	}
	
	

}
