package com.example.demo.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByIdAccount(int idAccount);
}
