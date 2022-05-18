package com.kaivikki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.entities.compositekey.Patient;
import com.kaivikki.repositories.PatientRepository;

@SpringBootTest
public class PatientRepositoryTest {

	@Autowired
	PatientRepository patientRepository;
	
	@Test
	public void createPatientTest() {
		Patient patient = new Patient();
		patient.setId(1);
		patient.setEmail("aa@gmail.com");
		patient.setName("vikram");
		patientRepository.save(patient);
	}
}
