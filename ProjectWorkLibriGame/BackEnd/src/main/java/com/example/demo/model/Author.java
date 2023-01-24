package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	
	@Id
	@SequenceGenerator(
			name = "author_sequence", 
			sequenceName ="author_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
	private int id;
	private String name;
	private String surname;
	private Date dataDiNascita;
	private String luogoDiNascita;
	
	public Author() {
		
	}

	public Author(int id, String name, String surname, Date dataDiNascita, String luogoDiNascita) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
	}

	public Author(String name, String surname, Date dataDiNascita, String luogoDiNascita) {
		this.name = name;
		this.surname = surname;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", dataDiNascita=" + dataDiNascita
				+ ", luogoDiNascita=" + luogoDiNascita + "]";
	}
	
}
