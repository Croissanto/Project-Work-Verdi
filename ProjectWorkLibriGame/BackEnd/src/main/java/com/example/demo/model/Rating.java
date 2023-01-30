package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int star;
	@ManyToOne
	private LibriGame libri;
	@ManyToOne
	private UserDummy user;
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Rating(int id, int star, LibriGame libri, UserDummy user) {
		super();
		this.id = id;
		this.star = star;
		this.libri = libri;
		this.user = user;
	}



	public Rating(int star, LibriGame libri, UserDummy user) {
		super();
		this.star = star;
		this.libri = libri;
		this.user = user;
	}

	public Rating(int id, int star, LibriGame libri) {
		super();
		this.id = id;
		this.star = star;
		this.libri = libri;
	}

	public Rating(int star, LibriGame libri) {
		super();
		this.star = star;
		this.libri = libri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public LibriGame getLibri() {
		return libri;
	}

	public void setLibri(LibriGame libri) {
		this.libri = libri;
	}

}
