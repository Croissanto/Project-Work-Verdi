package com.example.demo.dto;


public class CreateCommentoDTO {
	private String contenuto;
	private String date;
	private String time;
	private int idUser;
	private int idPost;

	public CreateCommentoDTO() {

	}

	public CreateCommentoDTO(String contenuto, String date, String time, int idUser, int idPost) {
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.idUser = idUser;
		this.idPost = idPost;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUserCommento(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

}
