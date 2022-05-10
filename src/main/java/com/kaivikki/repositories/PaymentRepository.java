package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
