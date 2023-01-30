package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfiguration {
	
	
	@Bean
	public IAccountManagerVerdi getManager() {
		return new DummyAccountManagerVerdi();
		//return new RealAccountManagerVerdi();
	}
}
