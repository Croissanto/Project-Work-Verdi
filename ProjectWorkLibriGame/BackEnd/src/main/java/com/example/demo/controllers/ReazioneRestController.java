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
		
		Optional<UserDummy> opt = userDummyRepo.findById(dto.getIdUser());
		Optional<Post> opt2 = postRepo.findById(dto.getIdPost());
		UserDummy user = new UserDummy();
		Post post = new Post();
		if(opt.isPresent() && opt2.isPresent()) {
			
			post = opt2.get();
			user = opt.get();
			
		}
		
		/*boolean exists = reazioneRepo.existsReazioneByUser(user);
		if(!exists) {
			
			Reazione reaction = new Reazione(user,dto.getReactions());
			reazioneRepo.save(reaction);
			
		}
		
		else {*/
			
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
