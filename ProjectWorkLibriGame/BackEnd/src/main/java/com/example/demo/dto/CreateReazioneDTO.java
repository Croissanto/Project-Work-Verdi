package com.example.demo.dto;

import com.example.demo.model.enums.Reactions;

public class CreateReazioneDTO {

	private int idPost;
	private int idUser;
	private Reactions reactions;

	public CreateReazioneDTO() {

	}

	public CreateReazioneDTO(int idPost, int idUser, Reactions reactions) {
		super();
		this.idPost = idPost;
		this.idUser = idUser;
		this.reactions = reactions;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Reactions getReactions() {
		return reactions;
	}

	public void setReactions(Reactions reactions) {
		this.reactions = reactions;
	}

	
}
