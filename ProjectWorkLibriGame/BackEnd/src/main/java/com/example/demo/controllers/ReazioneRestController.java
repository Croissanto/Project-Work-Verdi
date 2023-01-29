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
			Optional<Post> tmp = postRepo.findById(dto.getIdPost());
			Post post = new Post();
			if (tmp.isPresent()) {
				post = tmp.get();
			}
			List<Reazione> reactList = post.getReazione();
			UserDummy user = new UserDummy();

			if (opt.isPresent()) {

				user = opt.get();

			}

			Reazione reazione = new Reazione(user, dto.getUpVote(), dto.getDownVote());
			reactList.add(reazione);
			reazioneRepo.save(reazione);
			postRepo.save(post);
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
