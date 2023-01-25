package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Gallery {
	@Id
	@SequenceGenerator(
			name = "gallery_sequence", 
			sequenceName ="gallery_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gallery_sequence")
	private int idGallery;
	private String titoloSaga;
	@ManyToMany
	private List<LibriGame> libriGame;
	private int numeroLibri;
	public Gallery() {
		super();
		
	}
	public Gallery(int idGallery, String titoloSaga, List<LibriGame> libriGame, int numeroLibri) {
		super();
		this.idGallery = idGallery;
		this.titoloSaga = titoloSaga;
		this.libriGame = libriGame;
		this.numeroLibri = numeroLibri;
	}
	public Gallery(String titoloSaga, List<LibriGame> libriGame, int numeroLibri) {
		super();
		this.titoloSaga = titoloSaga;
		this.libriGame = libriGame;
		this.numeroLibri = numeroLibri;
	}
	public int getIdGallery() {
		return idGallery;
	}
	public void setIdGallery(int idGallery) {
		this.idGallery = idGallery;
	}
	public String getTitoloSaga() {
		return titoloSaga;
	}
	public void setTitoloSaga(String titoloSaga) {
		this.titoloSaga = titoloSaga;
	}
	public List<LibriGame> getLibriGame() {
		return libriGame;
	}
	public void setLibriGame(List<LibriGame> libriGame) {
		this.libriGame = libriGame;
	}
	public int getNumeroLibri() {
		return numeroLibri;
	}
	public void setNumeroLibri(int numeroLibri) {
		this.numeroLibri = numeroLibri;
	}
	@Override
	public String toString() {
		return "Gallery [idGallery=" + idGallery + ", titoloSaga=" + titoloSaga + ", libriGame=" + libriGame
				+ ", numeroLibri=" + numeroLibri + "]";
	}
	
	
	
	
	

}
