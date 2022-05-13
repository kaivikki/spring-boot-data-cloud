package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.transaction.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
