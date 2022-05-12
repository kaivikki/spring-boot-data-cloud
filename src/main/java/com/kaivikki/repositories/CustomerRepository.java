package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.mappings.onetomany.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
