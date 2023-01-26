package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

public class CreateCommentoDTO {
	private String contenuto ; 
	private Date date;
	private Time time;
	private int idUserCommento;
	public CreateCommentoDTO() {
		
	}
	public CreateCommentoDTO(String contenuto, Date date, Time time, int idUserCommento) {
		super();
		this.contenuto = contenuto;
		this.date = date;
		this.time = time;
		this.idUserCommento = idUserCommento;
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
	public int getIdUserCommento() {
		return idUserCommento;
	}
	public void setIdUserCommento(int idUserCommento) {
		this.idUserCommento = idUserCommento;
	}
	@Override
	public String toString() {
		return "CreateCommentoDTO [contenuto=" + contenuto + ", date=" + date + ", time=" + time + ", idUserCommento="
				+ idUserCommento + "]";
	}
	
	
	

}
