package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
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
	@SequenceGenerator(name = "post_sequence", sequenceName = "post_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
	private int id;
	@ManyToOne
	private UserDummy user;
	private String titolo;
	@Column(length = 2000)
	private String contenuto;
	private Date date;
	private Time time;
	@OneToMany
	private List<Reazione> reazione;
	@OneToMany
	private List<Commento> commento;

	public Post() {

	}

	public Post(UserDummy user, String titolo, String contenuto, Date date, Time time, List<Reazione> reazione,
			List<Commento> commento) {
		super();
		this.user = user;
		this.titolo = titolo;
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.reazione = reazione;
		this.commento = commento;
	}

	public Post(int id, UserDummy user, String titolo, String contenuto, Date date, Time time, List<Reazione> reazione,
			List<Commento> commento) {
		super();
		this.id = id;
		this.user = user;
		this.titolo = titolo;
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.reazione = reazione;
		this.commento = commento;
	}

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDummy getUser() {
		return user;
	}

	public void setUser(UserDummy user) {
		this.user = user;
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

	public List<Reazione> getReazione() {
		return reazione;
	}

	public void setReazione(List<Reazione> reazione) {
		this.reazione = reazione;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userPost=" + user + ", contenuto=" + contenuto + ", titolo=" + titolo + ", date="
				+ date + ", time=" + time + ", commento=" + commento + "]";
	}

}
