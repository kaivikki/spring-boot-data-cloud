package com.kaivikki.entities.compositekey;

import java.io.Serializable;

public class PatientId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
