package com.example.demo.dto;

public class CreatePostDTO {

	private int idReazione;
	private int idUser;
	private String titolo;
	private String contenuto;
	private String date;
	private String time;
	private int blogId;

	public CreatePostDTO() {

	}

	public CreatePostDTO(int idUser, String titolo, String contenuto, String date, String time, int blogId) {
		this.idUser = idUser;
		this.titolo = titolo;
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.blogId = blogId;
	}

	public CreatePostDTO(int idReazione, int idUser, String titolo, String contenuto, String date, String time,
			int blogId) {
		super();
		this.idReazione = idReazione;
		this.idUser = idUser;
		this.titolo = titolo;
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.blogId = blogId;
	}

	public int getIdReazione() {
		return idReazione;
	}

	public void setIdReazione(int idReazione) {
		this.idReazione = idReazione;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

}
