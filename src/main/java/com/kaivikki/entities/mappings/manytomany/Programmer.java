package com.kaivikki.entities.mappings.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="programmer_t")
public class Programmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int salary;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="programmer_projects_t",
						joinColumns = @JoinColumn(name="programmer_id", referencedColumnName = "id"), 
						inverseJoinColumns = @JoinColumn(name="project_id", referencedColumnName = "id"))		
	private Set<Project> projects;

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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	

}
