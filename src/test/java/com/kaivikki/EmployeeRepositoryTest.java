package com.kaivikki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.entities.componentmapping.Address;
import com.kaivikki.entities.componentmapping.Employee;
import com.kaivikki.repositories.EmployeeRepository;

@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void saveEmployeeTest() {
		
		Employee e1  = new Employee();
		e1.setId(1);
		e1.setName("Vikram");
		
		Address a1 = new Address();
		a1.setStreet("22, Sector 13 Extension");
		a1.setCity("Karnal");
		a1.setState("haryana");
		a1.setZipcode("132001");
		a1.setCountry("India");
		
		e1.setAddress(a1);
		
		employeeRepository.save(e1);
		
		
		
	}
	
	
}
