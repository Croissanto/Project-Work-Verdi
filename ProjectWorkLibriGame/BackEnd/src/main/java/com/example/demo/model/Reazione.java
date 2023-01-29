package com.example.demo.model;

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
	private int upvote;
	private int downvote;

	public Reazione() {

	}

	public Reazione(int id, UserDummy user, int upvote, int downvote) {
		super();
		this.id = id;
		this.user = user;
		this.upvote = upvote;
		this.downvote = downvote;
	}

	public Reazione( UserDummy user, int upvote, int downvote) {
		super();
		
		this.user = user;
		this.upvote = upvote;
		this.downvote = downvote;
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

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public int getDownvote() {
		return downvote;
	}

	public void setDownvote(int downvote) {
		this.downvote = downvote;
	}

}