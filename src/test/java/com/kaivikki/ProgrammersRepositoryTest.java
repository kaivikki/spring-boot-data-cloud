package com.kaivikki;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.entities.mappings.manytomany.Programmer;
import com.kaivikki.entities.mappings.manytomany.Project;
import com.kaivikki.repositories.ProgrammersRepository;

@SpringBootTest
public class ProgrammersRepositoryTest {

	@Autowired
	private ProgrammersRepository programmersRepository;
	
	@Test
	public void deleteAllTest() {
		programmersRepository.deleteAll();
	}
	
	@Test
	public void createProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Vikram");
		programmer.setSalary(1000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project e = new Project();
		e.setName("Home");
		projects.add(e);
		Project e1 = new Project();
		e1.setName("Office");
		projects.add(e1);
		
		programmer.setProjects(projects);
		programmersRepository.save(programmer);
	}
}
