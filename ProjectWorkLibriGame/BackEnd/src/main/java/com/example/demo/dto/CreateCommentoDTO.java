package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

public class CreateCommentoDTO {
	private String contenuto;
	private String date;
	private String time;
	private int idUserCommento;
	private int idPost;

	public CreateCommentoDTO() {

	}

	public CreateCommentoDTO(String contenuto, String date, String time, int idUserCommento, int idPost) {
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.idUserCommento = idUserCommento;
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

	public int getIdUserCommento() {
		return idUserCommento;
	}

	public void setIdUserCommento(int idUserCommento) {
		this.idUserCommento = idUserCommento;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

}
