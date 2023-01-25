package com.example.demo.dto;

import com.example.demo.model.enums.Genre;

public class CreateLibriGameDTO {

	private String title;
	private int annoDiPubblicazione;
	private String publisher;
	private int idAutore;
	private Genre genre;

	public CreateLibriGameDTO() {

	}

	public CreateLibriGameDTO(String title, int annoDiPubblicazione, String publisher, int idAutore, Genre genre) {
		super();
		this.title = title;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.publisher = publisher;
		this.idAutore = idAutore;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}

	public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "CreateLibriGameDTO [title=" + title + ", annoDiPubblicazione=" + annoDiPubblicazione + ", publisher="
				+ publisher + ", idAutore=" + idAutore + ", genre=" + genre + "]";
	}

}
