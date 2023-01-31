package com.example.demo.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Reazione;
import com.example.demo.model.UserDummy;

public interface ReazioneRepository extends CrudRepository<Reazione, Integer> {

	boolean existsReazioneByUser(UserDummy user);

	Optional<Reazione> findByUser(UserDummy user);
}
