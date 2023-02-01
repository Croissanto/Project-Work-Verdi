package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Configuration
public class AccountConfiguration {
	
	
	
	@Bean
	IAccountManagerVerdi getManager(HttpSession session, UserRepository userRepo) {
		//return new DummyAccountManagerVerdi();
		return new RealAccountManagerVerdi(session, userRepo) ;
			
		}
	}
