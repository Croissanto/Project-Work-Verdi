package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Blog {

	@Id
	@SequenceGenerator(
			name = "blog_sequence", 
			sequenceName ="blog_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_sequence")
	private int id;
	private String titolo;
	@OneToMany
	private List<Post> listaDeiPost;
	
	public Blog() {
	
	}

	public Blog(int id, String titolo, List<Post> listaDeiPost) {
		this.id = id;
		this.titolo = titolo;
		this.listaDeiPost = listaDeiPost;
	}

	public Blog(String titolo, List<Post> listaDeiPost) {
		this.titolo = titolo;
		this.listaDeiPost = listaDeiPost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Post> getListaDeiPost() {
		return listaDeiPost;
	}

	public void setListaDeiPost(List<Post> listaDeiPost) {
		this.listaDeiPost = listaDeiPost;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", titolo=" + titolo +", listaDeiPost=" + listaDeiPost + "]";
	}
	
	
}
