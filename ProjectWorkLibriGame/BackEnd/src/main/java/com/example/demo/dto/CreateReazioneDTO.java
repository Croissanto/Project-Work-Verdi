package com.example.demo.dto;

public class CreateReazioneDTO {

	private int idUser;
	private int upVote;
	private int downVote;

	public CreateReazioneDTO() {

	}

	public CreateReazioneDTO(int idUser, int upVote, int downVote) {
		super();

		this.idUser = idUser;
		this.upVote = upVote;
		this.downVote = downVote;
	}

	public CreateReazioneDTO(int upVote, int downVote) {
		super();

		this.upVote = upVote;
		this.downVote = downVote;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getUpVote() {
		return upVote;
	}

	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}

	public int getDownVote() {
		return downVote;
	}

	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}

}
