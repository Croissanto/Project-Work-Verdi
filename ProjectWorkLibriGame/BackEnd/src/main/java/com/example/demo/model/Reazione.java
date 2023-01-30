package com.example.demo.model;

import com.example.demo.model.enums.Reactions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Reazione {

	@Id
	@SequenceGenerator(name = "reazione_sequence", sequenceName = "reazione_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reazione_sequence")
	private int id;
	@ManyToOne
	private UserDummy user;
	private Reactions reactions;

	public Reazione() {

	}

	public Reazione(int id, UserDummy user, Reactions reactions) {
		super();
		this.id = id;
		this.user = user;
		this.reactions = reactions;
	}

	public Reazione(UserDummy user, Reactions reactions) {
		super();
		this.user = user;
		this.reactions = reactions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDummy getUser() {
		return user;
	}

	public void setUser(UserDummy user) {
		this.user = user;
	}

	public Reactions getReactions() {
		return reactions;
	}

	public void setReactions(Reactions reactions) {
		this.reactions = reactions;
	}

}