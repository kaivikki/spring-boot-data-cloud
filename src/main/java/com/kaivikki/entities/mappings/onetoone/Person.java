package com.kaivikki.entities.mappings.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person_t")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int age;
	
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="licence_id")
	private DrivingLicence licence;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public DrivingLicence getLicence() {
		return licence;
	}

	public void setLicence(DrivingLicence licence) {
		if(null!=licence) {
			licence.setPerson(this);
			this.licence = licence;
		}
	}
	
	
	
}
