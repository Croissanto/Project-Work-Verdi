package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

public class CreatePostDTO {
	
	private int idCommento;
	private int idUser;
	private String contenuto;
	private String link;
	private String date;
	private String time;
	private int blogId;
	
	public CreatePostDTO() {
		
		
	}


	public CreatePostDTO(int idCommento, int idUser, String contenuto, String link, String date, String time,int blogId) {
		super();
		this.idCommento = idCommento;
		this.idUser = idUser;
		this.contenuto = contenuto;
		this.link = link;
		this.date = date;
		this.time = time;
		this.blogId = blogId;
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
