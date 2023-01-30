package com.example.demo.dto;

public class RatingDTO {
	private int userId;
	private int libroId;
	private int star;

	public RatingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingDTO(int userId, int libroId, int star) {
		super();
		this.userId = userId;
		this.libroId = libroId;
		this.star = star;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

}
