package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.repositories.BlogRepository;

@Controller
public class BlogController {
	
	@Autowired
	private BlogRepository blogRepo;
	
	@GetMapping("/thread/{id}")
	public String thread(Model model,
			@PathVariable
			int id) {
		
		model.addAttribute("idBlog", id);
		
		return "thread";
	}
}
