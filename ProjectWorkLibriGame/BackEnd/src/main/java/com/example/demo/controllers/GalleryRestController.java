package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateGalleryDTO;
import com.example.demo.model.Gallery;
import com.example.demo.model.LibriGame;
import com.example.demo.model.repositories.GalleryRepository;
import com.example.demo.model.repositories.LibriGameRepository;

@RestController
public class GalleryRestController {
	@Autowired
	private GalleryRepository repoG;
	@Autowired
	private LibriGameRepository repoL;
	
	@PostMapping("/creategallery")
	public boolean createGallery(@RequestBody CreateGalleryDTO dtoG) {
			try {
		List<LibriGame> list = new LinkedList<>();
		for (Integer id : dtoG.getIdLibriGame()) {
			Optional<LibriGame> opt2 = repoL.findById(id);
			if(opt2.isPresent()) {
				list.add(opt2.get());
			}	
		}
		Gallery gallery = new Gallery(dtoG.getTitoloSaga(), list,dtoG.getNumeroLibri());
		repoG.save(gallery);
			return true;
		}catch(Exception e) {
			
			return false;
		}
		}
	}

		
	



