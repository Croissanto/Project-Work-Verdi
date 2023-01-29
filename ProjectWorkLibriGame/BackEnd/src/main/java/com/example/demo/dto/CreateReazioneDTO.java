package com.example.demo.dto;

public class CreateReazioneDTO {

	private int idPost;
	private int idUser;
	private int upVote;
	private int downVote;

	public CreateReazioneDTO() {

	}

	public CreateReazioneDTO(int idPost, int idUser, int upVote, int downVote) {
		super();
		this.idPost = idPost;
		this.idUser = idUser;
		this.upVote = upVote;
		this.downVote = downVote;
	}

	public CreateReazioneDTO(int idPost, int upVote, int downVote) {
		super();
		this.idPost = idPost;
		this.upVote = upVote;
		this.downVote = downVote;
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
