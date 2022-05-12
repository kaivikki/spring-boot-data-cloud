package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.mappings.manytomany.Programmer;

public interface ProgrammersRepository extends CrudRepository<Programmer, Integer> {

}
