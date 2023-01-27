package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reazione;

import com.example.demo.model.repositories.ReazioneRepository;

@RestController
public class ReazioneRestController {

	@Autowired
	private ReazioneRepository reazioneRepo;

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
