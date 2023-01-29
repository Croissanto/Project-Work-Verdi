package com.example.demo.dto;

import java.util.List;

public class CreateBlogDTO {
	private String titolo;
	private List<Integer> idListaPost;

	public CreateBlogDTO() {

	}

	public CreateBlogDTO(String titolo, List<Integer> idListaPost) {
		super();
		this.titolo = titolo;
		this.idListaPost = idListaPost;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Integer> getIdListaPost() {
		return idListaPost;
	}

	public void setIdListaPost(List<Integer> idListaPost) {
		this.idListaPost = idListaPost;
	}

	@Override
	public String toString() {
		return "CreateBlogDTO [titolo=" + titolo + ", idListaPost=" + idListaPost + "]";
	}
	
}
