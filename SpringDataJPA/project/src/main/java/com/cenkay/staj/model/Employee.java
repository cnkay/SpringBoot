package com.cenkay.staj.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = -2478081250589060210L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String username;
	private String password;
	private String citizenNumber;

	public Employee() {

	}

	public Employee(String username, String password, String citizenNumber) {
		this.username = username;
		this.password = password;
		this.citizenNumber = citizenNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCitizenNumber() {
		return citizenNumber;
	}

	public void setCitizenNumber(String citizenNumber) {
		this.citizenNumber = citizenNumber;
	}

}
