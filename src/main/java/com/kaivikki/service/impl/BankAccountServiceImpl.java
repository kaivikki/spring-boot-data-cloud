package com.kaivikki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaivikki.entities.transaction.BankAccount;
import com.kaivikki.repositories.BankAccountRepository;
import com.kaivikki.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		BankAccount fromAccount = bankAccountRepository.findById(1).get();
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		bankAccountRepository.save(fromAccount);
			
		BankAccount toAccount = bankAccountRepository.findById(2).get();
		toAccount.setBalance(toAccount.getBalance()+amount);
		bankAccountRepository.save(toAccount);

	}

}
