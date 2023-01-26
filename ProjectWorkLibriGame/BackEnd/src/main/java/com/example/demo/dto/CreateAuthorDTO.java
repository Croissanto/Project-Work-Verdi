package com.example.demo.dto;

import java.sql.Date;

public class CreateAuthorDTO {
	private String name;
	private String surname;
	private Date dataDiNascita;
	private String luogoDiNascita;

	public CreateAuthorDTO() {

	}

	public CreateAuthorDTO(String name, String surname, Date dataDiNascita, String luogoDiNascita) {
		super();
		this.name = name;
		this.surname = surname;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
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
		return "CreateAuthorDTO [name=" + name + ", surname=" + surname + ", dataDiNascita=" + dataDiNascita
				+ ", luogoDiNascita=" + luogoDiNascita + "]";
	}

}
