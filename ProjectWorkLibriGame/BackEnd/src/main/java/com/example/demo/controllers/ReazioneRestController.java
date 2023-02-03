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
		
		Optional<User> tmpU = userRepo.findById(dto.getIdUser());
		System.out.println("Id user = "+dto.getIdUser());
		Optional<Post> tmpP = postRepo.findById(dto.getIdPost());
		System.out.println("Id post = "+dto.getIdPost());
		if(tmpU.isPresent() && tmpP.isPresent()) {
			System.out.println("Sono entrambi presenti");
			Post thisPost = tmpP.get();
			User thisUser = tmpU.get();
			System.out.println("Post: "+ thisPost + " e l'user: "+thisUser);
			List<Reazione> thisReactionList = thisPost.getReazione();
			if(thisReactionList.size() == 0) {
				System.out.println("La lista delle reazioni è vuota");
				Reazione thisReazione = new Reazione(thisUser, dto.getReactions());
				thisReactionList.add(thisReazione);
				reazioneRepo.save(thisReazione);
				return true;
			} else {
				boolean userNotPresent = true;
				System.out.println(userNotPresent);
				for(Reazione singleReazione : thisReactionList) {
					if(singleReazione.getUser() == thisUser) {
						thisReactionList.remove(singleReazione);
						singleReazione = new Reazione(thisUser,dto.getReactions());
						thisReactionList.add(singleReazione);
						userNotPresent = false;
						System.out.println("Se sono qui l'utente ha già votato");
						reazioneRepo.save(singleReazione);
						return true;
					}
				}
				System.out.println("Il valore del booleano è "+userNotPresent);
				if(userNotPresent == true) {
					Reazione thisReazione = new Reazione(thisUser, dto.getReactions());
					thisReactionList.add(thisReazione);
					reazioneRepo.save(thisReazione);
					return true;
				}
			}
			
			
			
		}
		
		
		
		
		return false;
	}
}
