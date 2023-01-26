package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Commento;
import com.example.demo.model.UserDummy;
import com.example.demo.model.repositories.CommentoRepository;
import com.example.demo.model.repositories.UserDummyRepository;


@SpringBootTest
class CommentoTest {
	
	@Autowired
	private CommentoRepository repo;
	
	@Autowired
	private UserDummyRepository repos;
	//Pietro il padre dei test
	@Test
	void create() {
		UserDummy user = new UserDummy(1,"Talluccio");
		repos.save(user);
		Date date;
		Time time;
		date = Date.valueOf("2023-01-26");
		time = Time.valueOf("18:11:43");
		Commento comm = new Commento(2,"Camadonna",date,time,user);
		System.out.println(comm);
		assertNotNull(repo.save(comm));
	}

}
