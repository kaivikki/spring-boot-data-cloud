package com.kaivikki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.entities.transaction.BankAccount;
import com.kaivikki.repositories.BankAccountRepository;
import com.kaivikki.service.BankAccountService;

@SpringBootTest
public class BankAccountRepositoryTest {

	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Test
	public void createBankAccounts() {
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setAccount_number(1);
		bankAccount1.setFname("Vikram");
		bankAccount1.setLname("Arora");
		bankAccount1.setBalance(1000);
		
		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.setAccount_number(2);
		bankAccount2.setFname("Kaira");
		bankAccount2.setLname("Arora");
		bankAccount2.setBalance(500);
		
		bankAccountRepository.save(bankAccount1);
		bankAccountRepository.save(bankAccount2);
	}
	
	@Test
	public void testTransfer() {
		bankAccountService.transfer(500);
	}
	
	
}
