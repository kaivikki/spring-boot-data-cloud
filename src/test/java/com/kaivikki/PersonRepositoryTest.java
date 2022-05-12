package com.kaivikki;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.entities.mappings.onetoone.DrivingLicence;
import com.kaivikki.entities.mappings.onetoone.Person;
import com.kaivikki.repositories.PersonRepository;

@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void createPersonTest() {
		Person person = new Person();
		person.setName("Vikram");
		person.setAge(37);
		DrivingLicence licence = new DrivingLicence();
		licence.setType("MPV");
		licence.setValid_from(new Date());
		licence.setValid_to(new Date());
		person.setLicence(licence);
		personRepository.save(person);
	}
}
