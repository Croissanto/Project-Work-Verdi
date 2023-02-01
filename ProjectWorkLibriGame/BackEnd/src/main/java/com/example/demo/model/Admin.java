package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Admin {
	
	@Id
	@SequenceGenerator(
			name = "admin_sequence", 
			sequenceName ="admin_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sequence")
	private int id;
	private int idAccount;
	
	public Admin() {

	}

	public Admin(int id, int idAccount) {
		this.id = id;
		this.idAccount = idAccount;
	}

	public Admin(int idAccount) {
		super();
		this.idAccount = idAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", idAccount=" + idAccount + "]";
	}
	
	
}
