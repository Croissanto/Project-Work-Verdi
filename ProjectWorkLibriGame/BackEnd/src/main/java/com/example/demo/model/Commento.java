package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Commento {
	

	@Id
	@SequenceGenerator(
			name = "comm_sequence", 
			sequenceName ="comm_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comm_sequence")
	private int id;
	@Column(length = 2000)
	private String contenuto;
	private Date date;
	private Time time;
	@ManyToOne
	private UserDummy user;
	
	public Commento() {
		
	}

	public Commento(int id, String contenuto, Date date, Time time, UserDummy user) {
		this.id = id;
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.user = user;
	}

	public Commento(String contenuto, Date date, Time time, UserDummy user) {
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
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

	public UserDummy getUser() {
		return user;
	}

	public void setUserCommento(UserDummy user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Commento [id=" + id + ", contenuto=" + contenuto + ", date=" + date + ", time=" + time
				+ ", user=" + user + "]";
	}

}
