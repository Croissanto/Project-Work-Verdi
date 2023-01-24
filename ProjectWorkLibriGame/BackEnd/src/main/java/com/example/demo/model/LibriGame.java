package com.example.demo.model;

import com.example.demo.model.enums.Genre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LibriGame {
	

	@Id
	@SequenceGenerator(
			name = "libri_sequence", 
			sequenceName ="libri_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libri_sequence")
	private int id;
	private String title;
	@ManyToOne
	private Author autore;
	private String publisher;
	private int annoDiPubblicazione;
	private Genre genre;
	
	public LibriGame() {
		
	}

	public LibriGame(int id, String title, Author autore, String publisher, int annoDiPubblicazione, Genre genre) {
		this.id = id;
		this.title = title;
		this.autore = autore;
		this.publisher = publisher;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.genre = genre;
	}

	public LibriGame(String title, Author autore, String publisher, int annoDiPubblicazione, Genre genre) {
		this.title = title;
		this.autore = autore;
		this.publisher = publisher;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAutore() {
		return autore;
	}

	public void setAutore(Author autore) {
		this.autore = autore;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}

	public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "LibriGame [id=" + id + ", title=" + title + ", autore=" + autore + ", publisher=" + publisher
				+ ", annoDiPubblicazione=" + annoDiPubblicazione + ", genre=" + genre + "]";
	}
	
	
}
