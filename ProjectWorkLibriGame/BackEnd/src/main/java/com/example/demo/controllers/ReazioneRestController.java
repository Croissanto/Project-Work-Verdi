package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateReazioneDTO;
import com.example.demo.model.Post;
import com.example.demo.model.Reazione;
import com.example.demo.model.User;
import com.example.demo.model.repositories.PostRepository;
import com.example.demo.model.repositories.ReazioneRepository;
import com.example.demo.model.repositories.UserRepository;

@RestController
public class ReazioneRestController {

	@Autowired
	private ReazioneRepository reazioneRepo;
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PostRepository postRepo;

	
	@PostMapping("/createreazione")
	public boolean createReazione(@RequestBody CreateReazioneDTO dto) {
		
		Optional<User> opt = userRepo.findById(dto.getIdUser());
		Optional<Post> opt2 = postRepo.findById(dto.getIdPost());
		User user = new User();
		Post post = new Post();
		if(opt.isPresent() && opt2.isPresent()) {
			
			post = opt2.get();
			user = opt.get();
			
		}
			List<Reazione> reactList = post.getReazione();
			System.out.println(reactList);
			if(reactList.size() == 0) {
				Reazione reaction = new Reazione(user,dto.getReactions());
				reaction = reazioneRepo.save(reaction);
				reactList.add(reaction);
				postRepo.save(post);
			}
			for(Reazione reazione: reactList) {
			if(reazione.getUser().getId() == user.getId()) {
					System.out.println("if");
					reazione.setReactions(dto.getReactions());
					reazione = reazioneRepo.save(reazione);	
				}
			}	
		return false;
	}
}
