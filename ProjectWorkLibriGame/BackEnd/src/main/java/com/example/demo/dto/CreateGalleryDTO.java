package com.example.demo.dto;

import java.util.List;

public class CreateGalleryDTO {
	private int idLibroGame;
	private String titoloSaga;
	//togli
	private int numeroLibri;
	private List<Integer> idLibriGame;

	public CreateGalleryDTO() {

	}

	public CreateGalleryDTO(int idLibroGame, String titoloSaga, int numeroLibri, List<Integer> idLibriGame) {
		super();
		this.idLibroGame = idLibroGame;
		this.titoloSaga = titoloSaga;
		this.numeroLibri = numeroLibri;
		this.idLibriGame = idLibriGame;
	}

	public int getIdLibroGame() {
		return idLibroGame;
	}

	public void setIdLibroGame(int idLibroGame) {
		this.idLibroGame = idLibroGame;
	}

	public String getTitoloSaga() {
		return titoloSaga;
	}

	public void setTitoloSaga(String titoloSaga) {
		this.titoloSaga = titoloSaga;
	}

	public int getNumeroLibri() {
		return numeroLibri;
	}

	public void setNumeroLibri(int numeroLibri) {
		this.numeroLibri = numeroLibri;
	}

	public List<Integer> getIdLibriGame() {
		return idLibriGame;
	}

	public void setIdLibriGame(List<Integer> idLibriGame) {
		this.idLibriGame = idLibriGame;
	}

	@Override
	public String toString() {
		return "CreateGalleryDTO [idLibroGame=" + idLibroGame + ", titoloSaga=" + titoloSaga + ", numeroLibri="
				+ numeroLibri + ", idLibriGame=" + idLibriGame + "]";
	}
	


}
