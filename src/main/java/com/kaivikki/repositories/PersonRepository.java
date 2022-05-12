package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.mappings.onetoone.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
