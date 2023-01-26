package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

public class CreatePostDTO {
	
	private int idCommento;
	private int idUser;
	private String contenuto;
	private String link;
	private Date date;
	private Time time;
	
	
	public CreatePostDTO() {
		
		
	}


	public CreatePostDTO(int idCommento, int idUser, String contenuto, String link, Date date, Time time) {
		super();
		this.idCommento = idCommento;
		this.idUser = idUser;
		this.contenuto = contenuto;
		this.link = link;
		this.date = date;
		this.time = time;
	}


	public int getIdCommento() {
		return idCommento;
	}


	public void setIdCommento(int idCommento) {
		this.idCommento = idCommento;
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


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
	

}
