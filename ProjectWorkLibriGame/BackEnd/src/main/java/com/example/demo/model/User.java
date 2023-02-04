package com.example.demo.model;

import com.example.demo.model.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class User {

	

	@Id
	@SequenceGenerator(
			name = "utente_sequence", 
			sequenceName ="utente_sequence", 
			allocationSize =1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_sequence")
	private int id;
	private int idAccount;
	private AccountType type;
	@Column(length = 2000)
	private String proPic;
	
	public User() {

	}

	public User(int id, int idAccount, AccountType type, String proPic) {
		this.id = id;
		this.idAccount = idAccount;
		this.type = type;
		this.proPic = proPic;
	}

	public User(int idAccount, AccountType type, String proPic) {
		this.idAccount = idAccount;
		this.type = type;
		this.proPic = proPic;
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

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getProPic() {
		return proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", idAccount=" + idAccount + ", type=" + type + ", proPic=" + proPic + "]";
	}
	
	
}
