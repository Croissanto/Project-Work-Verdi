package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Post {
	
	@Id
	@SequenceGenerator(
			name = "post_sequence", 
			sequenceName ="post_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
	private int id;
	@ManyToOne
	private UserDummy userPost;
	private String contenuto;
	private String link;
	private Date date;
	private Time time;
	@OneToMany
	private List<Commento> commento;
	
	public Post() {
		
	}

	public Post(int id, UserDummy userPost, String contenuto, String link, Date date, Time time,
			List<Commento> commento) {
		this.id = id;
		this.userPost = userPost;
		this.contenuto = contenuto;
		this.link = link;
		this.date = date;
		this.time = time;
		this.commento = commento;
	}

	public Post(UserDummy userPost, String contenuto, String link, Date date, Time time, List<Commento> commento) {
		this.userPost = userPost;
		this.contenuto = contenuto;
		this.link = link;
		this.date = date;
		this.time = time;
		this.commento = commento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDummy getUserPost() {
		return userPost;
	}

	public void setUserPost(UserDummy userPost) {
		this.userPost = userPost;
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

	public List<Commento> getCommento() {
		return commento;
	}

	public void setCommento(List<Commento> commento) {
		this.commento = commento;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userPost=" + userPost + ", contenuto=" + contenuto + ", link=" + link + ", date="
				+ date + ", time=" + time + ", commento=" + commento + "]";
	}
	
	
}
