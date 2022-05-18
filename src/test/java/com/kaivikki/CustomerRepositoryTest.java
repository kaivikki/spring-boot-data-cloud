package com.kaivikki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.kaivikki.entities.mappings.onetomany.Customer;
import com.kaivikki.entities.mappings.onetomany.PhonNumber;
import com.kaivikki.repositories.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void deleteAll() {
		customerRepository.deleteAll();
	}
	
	@Test
	public void saveCustomerTest() {
		PhonNumber p1= new PhonNumber();
		p1.setNumber("7206488813");
		PhonNumber p2= new PhonNumber();
		p2.setNumber("7206433310");
		Customer customer = new Customer();
		customer.setName("Vikram");
		customer.addPhoneNumber(p1);
		customer.addPhoneNumber(p2);
		customerRepository.save(customer);
	}
	
	@Test
	@Transactional
	public void readCustomerTest() {
		Customer customer = customerRepository.findById(9).get();
		System.out.println(customer.getName());
		
		customer.getPhoneNumbers().forEach(p->{
			System.out.println(p.getNumber());
		});
	}
	
}
