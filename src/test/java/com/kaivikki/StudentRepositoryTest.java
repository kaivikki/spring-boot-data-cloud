package com.kaivikki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.kaivikki.entities.Student;
import com.kaivikki.repositories.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void createStudentstTest() {
		
		Student s1 = new Student();
		s1.setFirstName("Vikram");
		s1.setLastName("Arora");
		s1.setScore(77d);
		
		Student s2 = new Student();
		s2.setFirstName("Kaira");
		s2.setLastName("Arora");
		s2.setScore(87d);
		
		Student s3 = new Student();
		s3.setFirstName("Varsha");
		s3.setLastName("Kapoor");
		s3.setScore(97d);
		
		Student s4 = new Student();
		s4.setFirstName("Suhani");
		s4.setLastName("Arora");
		s4.setScore(67d);
		
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);
		studentRepository.save(s4);
	}
	
	@Test
	public void deleteAllTest() {
		studentRepository.deleteAll();
	}
	
	
	@Test
	public void findAllStudentsTest() {
		studentRepository.findAllStudents().stream().map(s -> s.toString()).forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentsNQTest() {
		studentRepository.findAllStudentsNQ().stream().map(s -> s.toString()).forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentByFirstName() {
		studentRepository.
		findStudentByFirstName("Kaira")
		.stream()
		.map(s -> s.toString())
		.forEach(System.out::println);
		
	}
	
	@Test
	public void findAllStudentFirstNameAndLastName() {
		studentRepository.
		findAllStudentFirstNameAndLastName()
		.stream()
		.map(s -> "FirstName= " +String.valueOf(s[0]) + " LastName= "+String.valueOf(s[1]))
		.forEach(System.out::println);		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void deleteStudentByFirstNameTest() {
		studentRepository.deleteStudentByFirstName("Varsha");
	}
	
}
